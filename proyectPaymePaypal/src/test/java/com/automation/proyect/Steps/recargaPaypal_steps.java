package com.automation.proyect.Steps;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.proyect.Test.Hooks;
import com.automation.proyect.pageFactory.homePage;
import com.automation.proyect.pageFactory.loginPage;
import com.automation.proyect.pageFactory.movesPage;
import com.automation.proyect.pageFactory.rechargePage;

import cucumber.api.DataTable;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

public class recargaPaypal_steps {
	
	WebDriver driver = Hooks.driver;
	
	String moneda = "";
	
	loginPage loginPage = PageFactory.initElements(driver, loginPage.class);
	homePage homePage = PageFactory.initElements(driver, homePage.class);
	rechargePage recargaPage = PageFactory.initElements(driver, rechargePage.class);
	movesPage movimientosPage = PageFactory.initElements(driver, movesPage.class);
	
	
	@Dado("^que el usuario ingreso a la página de recarga$")
	public void que_el_usuario_ingreso_a_la_página_de_recarga() throws Throwable {
		loginPage.login();
	    homePage.btnRecargaYa.click();
	    Thread.sleep(1000);
	    recargaPage.Access();
	}

	@Cuando("^digita los siguientes valores:$")
	public void digita_los_siguientes_valores(DataTable valores) throws Throwable {
		List<Map<String, String>> inputs = valores.asMaps(String.class, String.class);
		
		for (Map<String, String> listaValores : inputs) {
			recargaPage.recargar(listaValores.get("t_monto_recarga"), listaValores.get("t_cod_moneda"), true);
			
			if("840".equals(listaValores.get("t_cod_moneda"))) {
				moneda = "Dolares"; 
			}
		}
		
	}

	@Entonces("^debe observar los valores: Monto en soles \"([^\"]*)\", Comisión \"([^\"]*)\", Total a pagar \"([^\"]*)\"$")
	public void debe_observar_los_valores_Monto_en_soles_Comisión_Total_a_pagar(String monto_soles, String comision, String total_pagar) throws Throwable {
		
		if (moneda.equals("Dolares")) {
			assertEquals(monto_soles, "S/ 00.00");
		}else {
			assertEquals(monto_soles, recargaPage.lblMontoSoles.getText());
		}
		
		assertEquals(comision, recargaPage.lblComision.getText());
		assertEquals(total_pagar, recargaPage.lblTotalPagar.getText());
	}

	@Cuando("^ingresa los siguientes valores en el formulario:$")
	public void ingresa_los_siguientes_valores_en_el_formulario(DataTable datos) throws Throwable {
		List<Map<String, String>> valores = datos.asMaps(String.class, String.class);
		
		for (Map<String, String> listaValores : valores)
			recargaPage.recargar(listaValores.get("t_monto"), listaValores.get("t_moneda"), false);
		
	}

	@Entonces("^el aplicativo debe mostrar el código de pago, asi como el monto a pagar \"([^\"]*)\"$")
	public void el_aplicativo_debe_mostrar_el_código_de_pago_asi_como_el_monto_a_pagar(String monto_pagar) throws Throwable {
	    System.out.println("Se muestra el código de pago: " + recargaPage.lblCodigoRecarga.getText());
	    assertEquals(monto_pagar, recargaPage.lblTotalPagarVerification.getText());
	}

	@Cuando("^el usuario selecciona la opción 'Movimientos'$")
	public void el_usuario_selecciona_la_opción_Movimientos() throws Throwable {
	    recargaPage.lnkMovimientos.click();
	}

	@Entonces("^debe observar el formulario de movimientos$")
	public void debe_observar_el_formulario_de_movimientos() throws Throwable {
	    movimientosPage.Access();
	}

	@Entonces("^el estado de su operación como \"([^\"]*)\"$")
	public void el_estado_de_su_operación_como(String estado) throws Throwable {
		assertEquals(estado, movimientosPage.tdEstado.getText());
	}

}
