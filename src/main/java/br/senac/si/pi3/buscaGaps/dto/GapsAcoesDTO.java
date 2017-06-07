package br.senac.si.pi3.buscaGaps.dto;

import java.util.Date;
import java.util.List;

public class GapsAcoesDTO {
    private String codigoAcao;
    private String nomeAcao;
    private List<Date> datas;
    private TipoGap gap;

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

    public List<Date> getDatas() {
        return datas;
    }

    public void setData(List<Date> datas) {
        this.datas = datas;
    }

    public TipoGap getGap() {
        return gap;
    }

    public void setGap(TipoGap gap) {
        this.gap = gap;
    }
}
