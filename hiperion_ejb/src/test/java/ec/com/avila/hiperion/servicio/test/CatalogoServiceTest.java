package ec.com.avila.hiperion.servicio.test;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.entities.Catalogo;
import ec.com.avila.hiperion.entities.DetalleCatalogo;
import ec.com.avila.hiperion.servicio.CatalogoServiceRemote;
import ec.com.avila.hiperion.servicio.test.utilitario.ClientUtility;

public class CatalogoServiceTest {

	private Context context;

	@Before
	public void iniciarContexto() throws NamingException {
		context = ClientUtility.getInitialContext();
	}

	//@Test
	public void consultarCatalogoById() throws NamingException, HiperionException {
		CatalogoServiceRemote remoto = (CatalogoServiceRemote) context
				.lookup("ejb:/hiperion_ejb-1.0/CatalogoServiceImpl!ec.com.avila.hiperion.servicio.CatalogoServiceRemoto");
		Catalogo catalogo = remoto.consultarCatalogoById(1);
		if (catalogo != null) {
			System.out.println(catalogo.getDescripcionCatalogo());
			List<DetalleCatalogo> detalles = catalogo.getDetalleCatalogos();
			for (DetalleCatalogo detalleCatalogo : detalles)
				System.out.println(detalleCatalogo);
		}
	}
}
