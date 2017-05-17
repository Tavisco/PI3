package br.senac.si.pi3.modelagemtendencia.webservice.impl;

import br.senac.si.pi3.modelagemtendencia.dto.AcoesDTO;
import br.senac.si.pi3.modelagemtendencia.factory.EMFactory;
import br.senac.si.pi3.modelagemtendencia.service.InterpolarService;
import br.senac.si.pi3.modelagemtendencia.service.impl.InterpolarServiceImpl;
import br.senac.si.pi3.modelagemtendencia.webservice.TendenciaWebService;
import com.google.gson.Gson;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;
import org.apache.commons.math3.analysis.interpolation.DividedDifferenceInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionNewtonForm;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

@Path("tendencia")
public class TendenciaEndPoint implements TendenciaWebService{

    EntityManager em = new EMFactory().getEntityManager();

    @Context
    private UriInfo context;

    private final InterpolarService interpolarService;

    public TendenciaEndPoint() {

        this.interpolarService = new InterpolarServiceImpl();
    }

    @GET
    @Path("{dataI}/{dataF}/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcoesDTO> getJson(@PathParam("dataI") String dataI, @PathParam("dataF") String dataF) throws ParseException {
        try {
            System.out.println(dataI);
            System.out.println(dataF);
            List<AcoesDTO> ll;
            //Teste
//            DividedDifferenceInterpolator divider = new DividedDifferenceInterpolator();
//            LinearInterpolator interpolador = new LinearInterpolator();
//            
//            double[] x ={0.1,0.6,0.8}, y ={1.221,3.320,4.953};
//            
//            PolynomialSplineFunction re = interpolador.interpolate(x, y);
//            PolynomialFunctionNewtonForm fn = divider.interpolate(x, y);
//            
//            PolynomialFunction[] resultado = re.getPolynomials();
//            
//            System.out.println("AQUI!!");
//            System.out.println(Arrays.toString(resultado));
//            System.out.println("AQUI É FN!!");
//            System.out.println(Arrays.toString(fn.getNewtonCoefficients()));
//            System.out.println("AQUI é COEF");
//            System.out.println(Arrays.toString(fn.getCoefficients()));
//            System.out.println("calculando");
//            System.out.println(fn.value(0.2));
            Gson gson = new Gson();      
            ll = interpolarService.verificarEstadoNoPeriodo(dataI, dataF);
            
            return ll;
        } catch (ParseException e) {
            System.out.println("PARSE EX");
            throw new WebApplicationException(500);

        }
    }

}
