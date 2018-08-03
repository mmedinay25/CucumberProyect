package com.automation.proyect.Steps;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.proyect.Test.Hooks;
import com.automation.proyect.pageFactory.asociacionPage;
import com.automation.proyect.pageFactory.homePage;
import com.automation.proyect.pageFactory.loginPage;

import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class asociacionPaypal_steps {
	
	WebDriver driver = Hooks.driver;
	
	loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
	homePage homePage = PageFactory.initElements(driver, homePage.class);
	asociacionPage asociacionPage = PageFactory.initElements(driver, asociacionPage.class);
	
	@Dado("^que el usuario ha ingresado a la opción de asociación$")
	public void que_el_usuario_ha_ingresado_a_la_opción_de_asociación() throws Throwable {
		loginPage.loginUsuarioPorAsociar("michael.medinay@gmail.com");
	    homePage.btnComienzaYa.click();
	    homePage.btnAsociarAhora.click();
	    Thread.sleep(1000);
	    asociacionPage.Access();
	}

	@Cuando("^ingrese el correo: \"([^\"]*)\"$")
	public void ingrese_el_correo(String correo_paypal) throws Throwable {
	    asociacionPage.iniciarAsociacion(correo_paypal);
	}

	@Cuando("^complete los siguientes campos:$")
	public void complete_los_siguientes_campos(DataTable datos) throws Throwable {
		List<Map<String, String>> valores = datos.asMaps(String.class, String.class);
		
		for (Map<String, String> listaValores : valores) {
			String nombres = listaValores.get("t_nombres");
			String apellidos = listaValores.get("t_apellidos");
			String tipoDocu = listaValores.get("t_tipo_documento");
			String nroDocu = listaValores.get("t_nro_documento");
			String nroCel = listaValores.get("t_nro_celular");
			String operador = listaValores.get("t_operador");
			
			asociacionPage.ingresarDatosPersonales(nombres, apellidos, tipoDocu, nroDocu, nroCel, operador, false);
		}
	}

	@Cuando("^selecciona la opción 'Siguiente'$")
	public void selecciona_la_opción_Siguiente() throws Throwable {
	    asociacionPage.btnSiguiente1.click();
	    Thread.sleep(1500);
	}

	@Entonces("^se debe visualizar el mensaje de validacion \"([^\"]*)\"$")
	public void se_debe_visualizar_el_mensaje_de_validacion(String msj) throws Throwable {
	    assertEquals(msj, homePage.lblMensajeValidacion.getText());
	}

	@Cuando("^complete los siguientes datos personales:$")
	public void complete_los_siguientes_datos_personales(DataTable datosPersonales) throws Throwable {
		List<Map<String, String>> valores = datosPersonales.asMaps(String.class, String.class);
		
		String nombres = valores.get(0).get("nombres");
		String apellidos = valores.get(0).get("apellidos");
		String tipoDocu = valores.get(0).get("tipo_documento");
		String nroDocu = valores.get(0).get("nro_documento");
		String nroCel = valores.get(0).get("nro_celular");
		String operador = valores.get(0).get("operador");
			
		asociacionPage.ingresarDatosPersonales(nombres, apellidos, tipoDocu, nroDocu, nroCel, operador, true);
		
	}

	@Cuando("^complete los siguientes datos de direccion:$")
	public void complete_los_siguientes_datos_de_direccion(DataTable datosDireccion) throws Throwable {
		List<Map<String, String>> valores = datosDireccion.asMaps(String.class, String.class);
		
		String pais = valores.get(0).get("pais");
		String depa = valores.get(0).get("departamento");
		String ciudad = valores.get(0).get("ciudad");
		String distrito = valores.get(0).get("distrito");
		String direc = valores.get(0).get("direccion");
			
		asociacionPage.ingresarDatosDireccion(pais, depa, ciudad, distrito, direc);
		asociacionPage.ingresarDatosTarjeta();
		
	}

	@Cuando("^complete finalmente la clave paypal \"([^\"]*)\"$")
	public void complete_finalmente_la_clave_paypal(String clave) throws Throwable {
	    asociacionPage.ingresarDatosPaypal(clave);
	}

	@Entonces("^se debe visualizar el mensaje de confirmación: \"([^\"]*)\"$")
	public void se_debe_visualizar_el_mensaje_de_confirmación(String mensaje) throws Throwable {
	    assertEquals(mensaje, homePage.lblMensajeValidacion.getText());
	    Thread.sleep(1000);
	}

}
