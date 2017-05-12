package br.senac.si.pi3.modelagemtendencia.service.impl;

import br.senac.si.pi3.modelagemtendencia.dto.ResultTableDTO;
import br.senac.si.pi3.modelagemtendencia.entity.Acoes;
import br.senac.si.pi3.modelagemtendencia.service.InterpolarService;
import java.util.Date;
import java.util.List;
import br.senac.si.pi3.modelagemtendencia.dao.AcoesDao;
import br.senac.si.pi3.modelagemtendencia.dao.impl.AcoesDaoImpl;
import java.util.ArrayList;

public class InterpolarServiceImpl implements InterpolarService {

    private List<Acoes> acoes;
    private final AcoesDao dao;
    private final List<ResultTableDTO> result;
    
    public InterpolarServiceImpl() {
        this.dao = new AcoesDaoImpl();
        this.result = new ArrayList<ResultTableDTO>();
    }

    @Override
    public List<ResultTableDTO> verificarEstadoNoPeriodo(Date dataI, Date dataF) {
        this.acoes = dao.selectRange(dataI, dataF);
        //fazer contas e popular a lista com os DTO
        
        return this.result;
    }

}
