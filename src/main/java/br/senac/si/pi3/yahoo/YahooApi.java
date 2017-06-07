/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.si.pi3.yahoo;

/**
 *
 * @author otavio.mpinheiro Link da API:
 * https://github.com/sstrickx/yahoofinance-api
 */
import br.senac.si.pi3.modelagemtendencia.dao.AcoesDao;
import br.senac.si.pi3.modelagemtendencia.dao.impl.AcoesDaoImpl;
import br.senac.si.pi3.modelagemtendencia.entity.Acoes;
import br.senac.si.pi3.modelagemtendencia.factory.EMFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@Path("yahoo")
public class YahooApi {

    private final EntityManager em;

    public YahooApi() {
        this.em = new EMFactory().getEntityManager();
    }
    


    @GET
    @Path("getAcoes")
    @Produces(MediaType.APPLICATION_JSON)
    public Table getAcoes(@PathParam("nomeAcao") String _nAcao) throws IOException {
        System.out.println("=-=-=-=-=-=-=-= Teste Yahoo Finance =-=-=-=-=-=-=-= ");
        System.out.println("YH>>> Iniciando teste");

        Table tbl = new Table();
        
        List<Acoes> lst = em.createNamedQuery("Acoes.findAll", Acoes.class)
                .getResultList();
        
        tbl.data = new Acoes[lst.size()];
        
        tbl.data = lst.toArray(tbl.data);

        System.out.println("YH>>> FIM teste");

        return tbl;
    }

    private List<Acoes> converteParaAcao(List<HistoricalQuote> historico, String nome) {
        List<Acoes> lst = new ArrayList<Acoes>();

        for (HistoricalQuote hq : historico) {
            Acoes acao = new Acoes();

            acao.setNomeAcao(nome);
            acao.setCodigoAcao(hq.getSymbol());
            acao.setValorAlta(hq.getHigh().doubleValue());
            acao.setValorBaixa(hq.getLow().doubleValue());
            acao.setVolume(hq.getVolume());
            acao.setValorAbertura(hq.getOpen().doubleValue());
            acao.setData(hq.getDate().getTime());
            acao.setValorFechamento(hq.getClose().doubleValue());

            lst.add(acao);
        }

        return lst;

    }

    @POST
    @Path("absorver")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String absorver(@FormParam("sigla") String _nAcao, @FormParam("intervalo") String _periodo) throws IOException {
        String[] datas = _periodo.split("-");

        datas[0] = datas[0].replace(" ", "");
        datas[1] = datas[1].replace(" ", "");

        Calendar dataDe = Calendar.getInstance();
        Calendar dataAte = Calendar.getInstance();

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Stock stock;

        try {
            dataDe.setTime(df.parse(datas[0]));
            dataAte.setTime(df.parse(datas[1]));
            stock = YahooFinance.get(_nAcao, dataDe, dataAte, Interval.DAILY);
        } catch (Exception e) {
            return "false";
        }

        if (!stock.isValid()) {
            return "false";
        }

        List<Acoes> acoes = new ArrayList<Acoes>();

        acoes = converteParaAcao(stock.getHistory(), stock.getName());

        try {
            for (Acoes acaoBD : acoes) {
                em.getTransaction().begin();
                em.persist(acaoBD);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            return "false";
        }

        return "true";
    }

}
