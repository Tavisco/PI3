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
import br.senac.si.pi3.modelagemtendencia.entity.Acoes;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import yahoofinance.histquotes.Interval;

@Path("yahoo")
public class YahooApi {

    @GET
    @Path("testar/{nomeAcao}")
    @Produces(MediaType.APPLICATION_JSON)
    public Acoes testa(@PathParam("nomeAcao") String _nAcao) throws IOException {
        System.out.println("=-=-=-=-=-=-=-= Teste Yahoo Finance =-=-=-=-=-=-=-= ");
        System.out.println("YH>>> Iniciando teste");

        return getAcao(_nAcao);
    }

    private Acoes getAcao(String _nAcao) {
        try {
            Stock stock = YahooFinance.get(_nAcao);
            Acoes acao = new Acoes();

            if (stock.isValid()) {
                acao.setNomeAcao(stock.getName());
                acao.setCodigoAcao(stock.getSymbol());
                acao.setValorAlta(stock.getQuote().getDayHigh().doubleValue());
                acao.setValorBaixa(stock.getQuote().getDayLow().doubleValue());
                acao.setVolume(stock.getQuote().getVolume());
                acao.setValorAbertura(stock.getQuote().getOpen().doubleValue());
                acao.setData(stock.getQuote().getLastTradeTime().getTime());
                acao.setValorFechamento(stock.getQuote().getPrice().doubleValue());
            } else {
                System.out.println("YH>>> Acao nao encontrada!");
                return null;
            }

            return acao;

        } catch (IOException ex) {
            Logger.getLogger(YahooApi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }


    public void testaHistorico() throws IOException {
        /**
         * Calendar from = Calendar.getInstance(); Calendar to =
         * Calendar.getInstance(); from.add(Calendar.YEAR, -1); // from 1 year
         * ago
         *
         * Stock google = YahooFinance.get("GOOG"); List<HistoricalQuote>
         * googleHistQuotes = google.getHistory(from, to, Interval.DAILY);
         */

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.YEAR, -5); // from 5 years ago

        Stock google = YahooFinance.get("GOOG", from, to, Interval.WEEKLY);
        
        String sla = "oi";

    }
    
    @POST
    @Path("absorver")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String absorver(@FormParam("sigla") String _nAcao, @FormParam("intervalo") String _periodo) throws IOException{
        String[] datas = _periodo.split("-");
        
        datas[0] = datas[0].replace(" ", "");
        datas[1] = datas[1].replace(" ", "");
        
        Calendar data1 = Calendar.getInstance();
        Calendar data2 = Calendar.getInstance();
        
        SimpleDateFormat df = new SimpleDateFormat("mm/dd/yyyy");
        try {
            data1.setTime(df.parse(datas[0]));
            data2.setTime(df.parse(datas[1]));
        } catch (ParseException ex) {
            ex.printStackTrace();
            return "false";
        }

        Stock google = YahooFinance.get("GOOG", data1, data2, Interval.WEEKLY);
        
        
        return "true";
    }

}
