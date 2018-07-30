package com.automation.proyect.Steps;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.proyect.Test.Hooks;
import com.automation.proyect.pageFactory.homePage;
import com.automation.proyect.pageFactory.loginPage;

import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class loginPayme_steps{
	
	WebDriver driver = Hooks.driver;
	
	loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
	homePage homePage = PageFactory.initElements(driver, homePage.class);
	

	@Dado("^que el usuario ingreso a la página de autenticación$")
	public void que_el_usuario_ingreso_a_la_página_de_autenticación() throws Throwable {
	    loginPage.Access();
	}

	@Cuando("^ingresa los siguientes valores válidos en el formulario$")
	public void ingresa_los_siguientes_valores_válidos_en_el_formulario(DataTable dataTable) throws Throwable {
	    
		List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class);
		
		for (Map<String, String> lista: datos) {
			loginPage.Autenticator(lista.get("correo"), lista.get("clave"));
		}
		
	}

	@Entonces("^el usuario debe acceder al home de bienvenida$")
	public void el_usuario_debe_acceder_al_home_de_bienvenida() throws Throwable {
		homePage.Access();
		assertEquals("¡Bienvenido!", homePage.mensajeBienvenida());
	}

	@Dado("^tiene su cuenta payme en estado bloqueado$")
	public void tiene_su_cuenta_payme_en_estado_bloqueado() throws Throwable {
		System.out.println("El usuario tiene su cuenta Payme bloqueado");
	}

	@Cuando("^ingresa los siguientes valores en el formulario$")
	public void ingresa_los_siguientes_valores_en_el_formulario(DataTable dataTable) throws Throwable {
		
		List<Map<String, String>> datos = dataTable.asMaps(String.class, String.class);
		
		for (Map<String, String> lista: datos) {
			loginPage.Autenticator(lista.get("t_correo"), lista.get("t_clave"));
		}
	}

	@Entonces("^el aplicativo debe mostrar el mensaje \"([^\"]*)\"$")
	public void el_aplicativo_debe_mostrar_el_mensaje(String msj) throws Throwable {
		assertEquals("Cuenta temporalmente bloqueada", loginPage.mensajeValidacion());
	}

	@Cuando("^seleccione la opción \"([^\"]*)\"$")
	public void seleccione_la_opción(String opcion) throws Throwable {
		System.out.println("El usuario seleciona la opción: " + opcion);
		loginPage.lnkOlvideClave.click();
	}

	@Entonces("^el aplicativo debe mostrar un formulario para ingresar su correo$")
	public void el_aplicativo_debe_mostrar_un_formulario_para_ingresar_su_correo() throws Throwable {
		loginPage.formularioOlvideClave();
	}
	
}
