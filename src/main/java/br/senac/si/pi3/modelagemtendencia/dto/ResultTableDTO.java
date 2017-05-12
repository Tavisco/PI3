package br.senac.si.pi3.modelagemtendencia.dto;

import br.senac.si.pi3.modelagemtendencia.Enum.TendenciaEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultTableDTO {

    private String codigoAcao;
    private Date data;
    private TendenciaEnum estadoNoPeriodo;

    private final List<ResultTableDTO> resultList;

    public List<ResultTableDTO> getResultList() {
        return resultList;
    }

    public ResultTableDTO() {
        this.resultList = new ArrayList<ResultTableDTO>();
    }

    public String getCodigoAcao() {
        return codigoAcao;
    }

    public void setCodigoAcao(String codigoAcao) {
        this.codigoAcao = codigoAcao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TendenciaEnum getEstadoNoPeriodo() {
        return estadoNoPeriodo;
    }

    public void setEstadoNoPeriodo(TendenciaEnum estadoNoPeriodo) {
        this.estadoNoPeriodo = estadoNoPeriodo;
    }
    
    
}   
