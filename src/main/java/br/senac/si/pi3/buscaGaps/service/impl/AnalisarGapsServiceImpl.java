package br.senac.si.pi3.buscaGaps.service.impl;

import br.senac.si.pi3.buscaGaps.dto.GapsAcoesDTO;
import br.senac.si.pi3.buscaGaps.service.AnalisarGapsService;
import br.senac.si.pi3.modelagemtendencia.dao.AcoesDao;
import br.senac.si.pi3.modelagemtendencia.dao.impl.AcoesDaoImpl;
import br.senac.si.pi3.modelagemtendencia.entity.Acoes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class AnalisarGapsServiceImpl implements AnalisarGapsService{
    
    private List<Acoes> acoes;
    private final AcoesDao dao;
    private final List<GapsAcoesDTO> result;
    private final SimpleDateFormat sdf;

    public AnalisarGapsServiceImpl() {
        this.dao = new AcoesDaoImpl();
        this.result = new ArrayList<GapsAcoesDTO>();
        this.sdf = new SimpleDateFormat("yyyy/MM/dd");
    }
    
    public List<GapsAcoesDTO> analisaGaps(String dataI, String dataF) throws ParseException {
        this.acoes = dao.selectValueRange(convertDate(dataI), convertDate(dataF));
        //faz logica e popula result
        
        //depois agnt melhora isso que vou fazer aqui
        int i = 0;
        while(i < acoes.size()){
            
            if(acoes.get(i).getValorFechamento() > acoes.get(i+1).getValorAbertura()){
                System.out.println("Gap de baixa");
                
            }
            if(acoes.get(i).getValorFechamento() < acoes.get(i+1).getValorAbertura()){
                System.out.println("Gap de alta");
            }
            i+=1;
        }
                
        
        //faze um teste aqui 
        popula(acoes.get(0).getNomeAcao(),acoes.get(0).getCodigoAcao(),acoes.get(0).getData());
        popula(acoes.get(1).getNomeAcao(),acoes.get(1).getCodigoAcao(),acoes.get(1).getData());
        return result;
    }
    
    private void popula(String nome, String cod, Date data){
        GapsAcoesDTO d = new GapsAcoesDTO();
        d.setCodigoAcao(cod);
        d.setNomeAcao(nome);
        d.setData(data);
        d.setGap(true);
        
        result.add(d);
    }
    private Date convertDate(String data) throws ParseException{
        return sdf.parse(data.replace("-", "/"));
    }
}
