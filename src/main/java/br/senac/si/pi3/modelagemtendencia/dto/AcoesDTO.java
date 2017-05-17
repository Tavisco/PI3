package br.senac.si.pi3.modelagemtendencia.dto;

import br.senac.si.pi3.modelagemtendencia.Enum.TendenciaEnum;
import java.util.Date;

public class AcoesDTO {

    private String codigoAcao;
    private String nomeAcao;
    private Date data;
    private TendenciaEnum estadoNoPeriodo;

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
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
