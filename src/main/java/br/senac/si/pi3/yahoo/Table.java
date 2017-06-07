package br.senac.si.pi3.yahoo;

import java.io.Serializable;

import br.senac.si.pi3.modelagemtendencia.entity.Acoes;

public class Table implements Serializable {
    Acoes[] data;
    
    public Acoes[] getData() {
        return data;
    }
    
    public void setData(Acoes[] data) {
        this.data = data;
    }
}
