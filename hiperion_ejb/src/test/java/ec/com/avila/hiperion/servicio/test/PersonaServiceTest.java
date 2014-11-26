package ec.com.avila.hiperion.servicio.test;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;

import ec.com.avila.hiperion.comun.HiperionException;
import ec.com.avila.hiperion.emision.entities.Persona;
import ec.com.avila.hiperion.servicio.PersonaServiceRemote;
import ec.com.avila.hiperion.servicio.test.utilitario.ClientUtility;

public class PersonaServiceTest {

	private Context context;

	@Before
	public void iniciarContexto() throws NamingException {
		context = ClientUtility.getInitialContext();
	}

	// @Test
	public void guardarPersonaTest() throws NamingException {
		try {
			Persona persona = new Persona();
			PersonaServiceRemote remoto = (PersonaServiceRemote) context.lookup("ejb:/hiperion_ejb-1.0/PersonaServiceImpl!ec.com.avila.hiperion.servicio.PersonaServiceRemoto");
			remoto.guardarPersona(persona);
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void consultarPersonas() throws NamingException {
		try {
			PersonaServiceRemote remoto = (PersonaServiceRemote) context.lookup("ejb:/hiperion_ejb-1.0/PersonaServiceImpl!ec.com.avila.hiperion.servicio.PersonaServiceRemoto");
			List<Persona> personas;

			personas = remoto.consultarPersonas();
			if (personas != null && personas.size() != 0) {
				for (Persona persona : personas)
					System.out.println(persona);
			} else {
				System.out.println("No existen Usuarios..");
			}
		} catch (HiperionException e) {
			e.printStackTrace();
		}
	}
}
