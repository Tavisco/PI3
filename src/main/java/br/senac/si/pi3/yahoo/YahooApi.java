/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.si.pi3.yahoo;

/**
 *
 * @author otavio.mpinheiro
 * Link da API: https://github.com/sstrickx/yahoofinance-api
 */

import br.senac.si.pi3.modelagemtendencia.entity.Acoes;
import java.io.IOException;
import java.math.BigDecimal;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Path("yahoo")
public class YahooApi {
    
    @GET
    @Path("testar/{nomeAcao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Acoes testa(@PathParam("nomeAcao") String _nAcao) throws IOException{
        System.out.println("=-=-=-=-=-=-=-= Teste Yahoo Finance =-=-=-=-=-=-=-= ");
        System.out.println("YH>> Iniciando teste");
        
        Stock stock = YahooFinance.get(_nAcao);
 
        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
        
        System.out.println("Price: " + price);
        System.out.println("Change: " + change);
        System.out.println("Peg: " + peg);
        System.out.println("Dividend" + dividend);
        
        System.out.println("Exibindo acao: ");
        System.out.println("");
        stock.print();
        
        Acoes acao = new Acoes();
        
        acao.setNomeAcao(stock.getName());
        acao.setCodigoAcao(stock.getSymbol());
        acao.setValorAlta(stock.getQuote().getDayHigh().doubleValue());
        acao.setValorBaixa(stock.getQuote().getDayLow().doubleValue());
        acao.setVolume(stock.getQuote().getVolume());
        acao.setValorAbertura(stock.getQuote().getOpen().doubleValue());
        acao.setData(stock.getQuote().getLastTradeTime().getTime());
        acao.setValorFechamento(stock.getQuote().getPrice().doubleValue());
        
        return acao;
    }
    
    
    
}
