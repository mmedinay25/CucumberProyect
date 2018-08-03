package com.automation.proyect.Steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.proyect.Test.Hooks;
import com.automation.proyect.pageFactory.asociacionPage;
import com.automation.proyect.pageFactory.homePage;
import com.automation.proyect.pageFactory.loginPage;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
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
	public void complete_los_siguientes_campos(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
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
	public void complete_los_siguientes_datos_personales(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
	}

	@Cuando("^complete los siguientes datos de direccion:$")
	public void complete_los_siguientes_datos_de_direccion(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
	}

	@Cuando("^complete finalmente la clave paypal \"([^\"]*)\"$")
	public void complete_finalmente_la_clave_paypal(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Entonces("^se debe visualizar el mensaje de confirmación: \"([^\"]*)\"$")
	public void se_debe_visualizar_el_mensaje_de_confirmación(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dado("^que el usuario se ubica en el formulario de asociación$")
	public void que_el_usuario_se_ubica_en_el_formulario_de_asociación() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Cuando("^selecciona la opción 'Asociar'$")
	public void selecciona_la_opción_Asociar() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
