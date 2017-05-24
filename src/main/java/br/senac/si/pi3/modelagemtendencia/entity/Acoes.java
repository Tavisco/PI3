package br.senac.si.pi3.modelagemtendencia.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "acoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acoes.findAll", query = "SELECT a FROM Acoes a")
    //query modulo de gaps
    ,@NamedQuery(name = "Acoes.findBetweenDatesTheValues", query = "SELECT a.valorAbertura a.valorFechamento a.valorAlta a.valorBaixa "
            + "FROM Acoes a WHERE a.data BETWEEN :dataI AND :dataF")
    //query modulo de tendencia
    , @NamedQuery(name = "Acoes.findBetweenDates ", query = "SELECT a FROM Acoes a WHERE a.data BETWEEN :dataI AND :dataF")
    //Ou essa query abaixo...
    //        , @NamedQuery(name = "Acoes.findBetweenDates ", query = "SELECT a FROM Acoes a WHERE a.data BETWEEN to_date(:dataI,'dd/mm/yyyy') AND to_date(:dataF,'dd/mm/yyyy')")
    , @NamedQuery(name = "Acoes.findByNomeAcao", query = "SELECT a FROM Acoes a WHERE a.nomeAcao = :nomeAcao")
    , @NamedQuery(name = "Acoes.findById", query = "SELECT a FROM Acoes a WHERE a.id = :id")
    , @NamedQuery(name = "Acoes.findByCodigoAcao", query = "SELECT a FROM Acoes a WHERE a.codigoAcao = :codigoAcao")
    , @NamedQuery(name = "Acoes.findByData", query = "SELECT a FROM Acoes a WHERE a.data = :data")
    , @NamedQuery(name = "Acoes.findByValorAbertura", query = "SELECT a FROM Acoes a WHERE a.valorAbertura = :valorAbertura")
    , @NamedQuery(name = "Acoes.findByValorAlta", query = "SELECT a FROM Acoes a WHERE a.valorAlta = :valorAlta")
    , @NamedQuery(name = "Acoes.findByValorBaixa", query = "SELECT a FROM Acoes a WHERE a.valorBaixa = :valorBaixa")
    , @NamedQuery(name = "Acoes.findByValorFechamento", query = "SELECT a FROM Acoes a WHERE a.valorFechamento = :valorFechamento")
    , @NamedQuery(name = "Acoes.findByVolume", query = "SELECT a FROM Acoes a WHERE a.volume = :volume")

})
public class Acoes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CodigoAcao")
    private String codigoAcao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NomeAcao")
    private String nomeAcao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorAbertura")
    private double valorAbertura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorAlta")
    private double valorAlta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorBaixa")
    private double valorBaixa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorFechamento")
    private double valorFechamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Volume")
    private double volume;

    public Acoes() {
    }

    public Acoes(Integer id) {
        this.id = id;
    }

    public Acoes(Integer id, String codigoAcao, String nomeAcao, Date data, double valorAbertura, double valorAlta, double valorBaixa, double valorFechamento, double volume) {
        this.id = id;
        this.codigoAcao = codigoAcao;
        this.nomeAcao = nomeAcao;
        this.data = data;
        this.valorAbertura = valorAbertura;
        this.valorAlta = valorAlta;
        this.valorBaixa = valorBaixa;
        this.valorFechamento = valorFechamento;
        this.volume = volume;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getValorAbertura() {
        return valorAbertura;
    }

    public void setValorAbertura(double valorAbertura) {
        this.valorAbertura = valorAbertura;
    }

    public double getValorAlta() {
        return valorAlta;
    }

    public void setValorAlta(double valorAlta) {
        this.valorAlta = valorAlta;
    }

    public double getValorBaixa() {
        return valorBaixa;
    }

    public void setValorBaixa(double valorBaixa) {
        this.valorBaixa = valorBaixa;
    }

    public double getValorFechamento() {
        return valorFechamento;
    }

    public void setValorFechamento(double valorFechamento) {
        this.valorFechamento = valorFechamento;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
