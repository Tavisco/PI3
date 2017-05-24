package br.senac.si.pi3.modelagemtendencia.service.impl;

import br.senac.si.pi3.modelagemtendencia.Enum.TendenciaEnum;
import br.senac.si.pi3.modelagemtendencia.dto.AcoesDTO;
import br.senac.si.pi3.modelagemtendencia.entity.Acoes;
import br.senac.si.pi3.modelagemtendencia.service.InterpolarService;
import java.util.List;
import br.senac.si.pi3.modelagemtendencia.dao.AcoesDao;
import br.senac.si.pi3.modelagemtendencia.dao.impl.AcoesDaoImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InterpolarServiceImpl implements InterpolarService {

    private List<Acoes> acoes;
    private final AcoesDao dao;
    private final List<AcoesDTO> result;
    private final SimpleDateFormat sdf;

    public InterpolarServiceImpl() {
        this.sdf = new SimpleDateFormat("yyyy/MM/dd");
        this.dao = new AcoesDaoImpl();
        this.result = new ArrayList<AcoesDTO>();
    }

    @Override
    public List<AcoesDTO> verificarEstadoNoPeriodo(String dataI, String dataF) throws ParseException {
        this.acoes = dao.selectRange(convertDate(dataI), convertDate(dataF));
        //fazer contas e popular a lista com os DTO
        //Teste
        for (int i = 0; i < acoes.size(); i++) {
            AcoesDTO d = new AcoesDTO();
            d.setId((acoes.get(i).getId()));
            d.setNomeAcao(acoes.get(i).getNomeAcao());
            d.setCodigoAcao(acoes.get(i).getCodigoAcao());
            d.setEstadoNoPeriodo(TendenciaEnum.ESTAGNADO);
            d.setData(acoes.get(i).getData());
            result.add(d);
        }
        return this.result;
    }
    private Date convertDate(String data) throws ParseException{
        return sdf.parse(data.replace("-", "/"));
    }
}
