package br.senac.si.pi3.buscaGaps.service.impl;

import br.senac.si.pi3.buscaGaps.dto.GapsAcoesDTO;
import br.senac.si.pi3.buscaGaps.dto.TipoGap;
import br.senac.si.pi3.buscaGaps.service.AnalisarGapsService;
import br.senac.si.pi3.modelagemtendencia.dao.AcoesDao;
import br.senac.si.pi3.modelagemtendencia.dao.impl.AcoesDaoImpl;
import br.senac.si.pi3.modelagemtendencia.entity.Acoes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class AnalisarGapsServiceImpl implements AnalisarGapsService {

    private List<Date> datas;
    private GapsAcoesDTO d;
    private List<Acoes> acoes;
    private final AcoesDao dao;
    private final List<GapsAcoesDTO> result;
    private final SimpleDateFormat sdf;

    public AnalisarGapsServiceImpl() {
        this.dao = new AcoesDaoImpl();
        this.result = new ArrayList<GapsAcoesDTO>();
        this.sdf = new SimpleDateFormat("yyyy/MM/dd");
    }

    public List<GapsAcoesDTO> analisaGaps(String dataI, String dataF) throws ParseException {
        this.acoes = this.dao.selectValueRange(convertDate(dataI), convertDate(dataF));
        this.populaResult();
        
        return result;
    }

    private void populaResult() {

        for (int i = 0; i < this.acoes.size(); i++) {
            this.d = new GapsAcoesDTO();
            this.datas = new ArrayList();

            this.d.setCodigoAcao(this.acoes.get(i).getCodigoAcao());
            this.d.setNomeAcao(this.acoes.get(i).getNomeAcao());
            this.datas.add(this.acoes.get(i).getData());
            this.datas.add(this.acoes.get(i + i).getData());
            this.d.setData(this.datas);
            this.d.setGap(isGap(i));
            this.result.add(this.d);
        }
    }

    private TipoGap isGap(int i) {
        if (this.acoes.get(i + 1) == null) {
            return TipoGap.SEM_GAP;
        } else {
            if (this.acoes.get(i).getValorBaixa() > this.acoes.get(i + 1).getValorAlta()) {
                System.out.println("Gap de baixa");
                return TipoGap.BAIXA;
            } else {
                if (this.acoes.get(i).getValorAlta() < this.acoes.get(i + 1).getValorBaixa()) {
                    System.out.println("Gap de alta");
                    return TipoGap.ALTA;
                }
            }
        }
        return TipoGap.SEM_GAP;
    }

    private Date convertDate(String data) throws ParseException {
        return this.sdf.parse(data.replace("-", "/"));
    }
}
