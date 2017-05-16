package br.senac.si.pi3.modelagemtendencia.webservice;

import br.senac.si.pi3.modelagemtendencia.dto.AcoesDTO;
import br.senac.si.pi3.modelagemtendencia.factory.EMFactory;
import br.senac.si.pi3.modelagemtendencia.service.InterpolarService;
import br.senac.si.pi3.modelagemtendencia.service.impl.InterpolarServiceImpl;
import java.text.ParseException;
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
public class ResultTendenciaWS {

    EntityManager em = new EMFactory().getEntityManager();

    @Context
    private UriInfo context;

    private final InterpolarService interpolarService;

    public ResultTendenciaWS() {

        this.interpolarService = new InterpolarServiceImpl();
    }

    @GET
//    @Path("{dataI}/{dataF}/json")
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AcoesDTO> getJson(@PathParam("dataI") String dataI, @PathParam("dataI") String dataF) throws ParseException {
        try {
            //Teste
            DividedDifferenceInterpolator divider = new DividedDifferenceInterpolator();
            LinearInterpolator interpolador = new LinearInterpolator();
            
            double[] x ={0.1,0.6,0.8}, y ={1.221,3.320,4.953};
            
            PolynomialSplineFunction re = interpolador.interpolate(x, y);
            PolynomialFunctionNewtonForm fn = divider.interpolate(x, y);
            
            PolynomialFunction[] resultado = re.getPolynomials();
            
            System.out.println("AQUI!!");
            System.out.println(Arrays.toString(resultado));
            System.out.println("AQUI É FN!!");
            System.out.println(Arrays.toString(fn.getNewtonCoefficients()));
            System.out.println("AQUI é COEF");
            System.out.println(Arrays.toString(fn.getCoefficients()));
            System.out.println("calculando");
            System.out.println(fn.value(0.2));
            
            return interpolarService.verificarEstadoNoPeriodo(dataI, dataF);
        } catch (ParseException e) {
            throw new WebApplicationException(500);

        }
    }

}
