package br.senac.si.pi3.modelagemtendencia.service.impl;

import br.senac.si.pi3.modelagemtendencia.Enum.TendenciaEnum;
import br.senac.si.pi3.modelagemtendencia.dto.AcoesDTO;
import br.senac.si.pi3.modelagemtendencia.entity.Acoes;
import br.senac.si.pi3.modelagemtendencia.service.InterpolarService;
import java.util.List;
import br.senac.si.pi3.modelagemtendencia.dao.AcoesDao;
import br.senac.si.pi3.modelagemtendencia.dao.impl.AcoesDaoImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

public class InterpolarServiceImpl implements InterpolarService {

    private List<Acoes> acoes;
    private final AcoesDao dao;
    private final List<AcoesDTO> result;
    private final SimpleDateFormat sdf;
    private LinearInterpolator interpolador;

    public InterpolarServiceImpl() {
        this.sdf = new SimpleDateFormat("yyyy/dd/MM");
        this.dao = new AcoesDaoImpl();
        this.result = new ArrayList<AcoesDTO>();
        this.interpolador = new LinearInterpolator();
    }

    @Override
    public List<AcoesDTO> verificarEstadoNoPeriodo(String dataI, String dataF) throws ParseException {
        this.acoes = dao.selectRange(sdf.parse(dataI), sdf.parse(dataF));
        
//        double[] x = {0.1, 0.6}, y = {1.221, 3.320};
//        PolynomialSplineFunction re = interpolador.interpolate(x, y);
//        PolynomialFunction[] resultado = re.getPolynomials();
//        System.out.println(resultado[0].toString());
        
        //fazer contas e popular a lista com os DTO

        //Teste
        for (int i = 0; i < acoes.size(); i++) {
            AcoesDTO d = new AcoesDTO();
            d.setCodigoAcao(acoes.get(i).getCodigoAcao());
            d.setEstadoNoPeriodo(TendenciaEnum.ESTAGNADO);
            d.setData(acoes.get(i).getData());
            result.add(d);
        }
        return this.result;
    }

}
