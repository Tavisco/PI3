package br.senac.si.pi3.buscaGaps.dto;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class GapsAcoesDTO {
    private String codigoAcao;
    private String nomeAcao;
    private Date data;
    private boolean gap;

    public String getCodigoAcao() {
        return codigoAcao;
    }

    public void setCodigoAcao(String codigoAcao) {
        this.codigoAcao = codigoAcao;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isGap() {
        return gap;
    }

    public void setGap(boolean gap) {
        this.gap = gap;
    }
}
