package com.automation.proyect.pageFactory;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class asociacionPage {

	final WebDriver driver;
	
	private String ASOCIACION_URL = "https://calidad.alignetsac.com/WALLET/faces/pages/session/paypal_recharge.xhtml#";
	
	@FindBy(id = "correoPayPalAsoc")
	public WebElement txtEmailPaypal;
	
	@FindBy(id = "assoc-boton")
	public WebElement btnAsociar;
	
	/* PASO 1 */
	
	@FindBy(id = "contentForm:correo-th")
	public WebElement txtCorreoPaypal;
	
	@FindBy(id = "contentForm:firstname-th")
	public WebElement txtNombres;
	
	@FindBy(id = "contentForm:first-lastname-th")
	public WebElement txtApellidos;
	
	@FindBy(id = "contentForm:opt-documento-th")
	public WebElement cmbTipoDocumento;
	
	@FindBy(id = "contentForm:numero-documento-th")
	public WebElement txtNroDocumento;
	
	@FindBy(id = "contentForm:expiryday-day-cd-register")
	public WebElement cmbDiaNacimiento;
	
	@FindBy(id = "contentForm:expiryday-month-cd-register")
	public WebElement cmbMesNacimiento;
	
	@FindBy(id = "contentForm:expiryday-year-cd-register")
	public WebElement cmbAnioNacimiento;
	
	@FindBy(id = "contentForm:first-phone-th")
	public WebElement txtNroCelular;
	
	@FindBy(id = "contentForm:operator-list")
	public WebElement cmbOperador;
	
	@FindBy(id = "contentForm:btn-update-data")
	public WebElement btnSiguiente1;
	
	/* PASO 2 */
	
	@FindBy(id = "contentForm:opt-pais2-th")
	public WebElement cmbPais;
	
	@FindBy(id = "contentForm:opt-dept2-th")
	public WebElement cmbDepartamento;
	
	@FindBy(id = "contentForm:opt-ciudad2-th")
	public WebElement cmbCiudad;
	
	@FindBy(id = "contentForm:opt-dist2-th")
	public WebElement cmbDistrito;
	
	@FindBy(id = "contentForm:direccion-th")
	public WebElement txtDireccion;
	
	@FindBy(id = "contentForm:btn-update-data-paypal")
	public WebElement btnSiguiente2;
	
	/* PASO 3 */
	
	@FindBy(id = "contentForm:btn-end-data-paypal")
	public WebElement btnFinalizar;
	
	/* PASO AUTENTICACION PAYPAL */
	
	@FindBy(id = "password")
	public WebElement txtClavePaypal;
	
	@FindBy(id = "authorize")
	public WebElement btnAutorizar;
	
	@FindBy(id = "returnLink")
	public WebElement btnCerrarPaypal;
	
	@FindBy(id = "div-alerta")
	public WebElement lblMensajeValidacion;
	
	
	public asociacionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Access() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(btnAsociar));

		if (!ASOCIACION_URL.equals(driver.getCurrentUrl())) {
			throw new IllegalStateException("Esta no es la página de asociación");
		}

	}
	
	public void iniciarAsociacion(String correoPaypal) throws InterruptedException {
		txtEmailPaypal.sendKeys(correoPaypal);
		btnAsociar.click();
		Thread.sleep(1000);
	}
	
	public void ingresarDatosPersonales(String nombres, String apellidos, String tipoDocu, String nroDocu, String nroCel, String operador, boolean next) throws InterruptedException {
		txtNombres.clear();
		txtNombres.sendKeys(nombres);
		
		txtApellidos.clear();
		txtApellidos.sendKeys(apellidos);
		
		selectText(tipoDocu, cmbTipoDocumento);
		
		txtNroDocumento.clear();
		txtNroDocumento.sendKeys(nroDocu);
		
		txtNroDocumento.clear();
		txtNroDocumento.sendKeys(nroDocu);
		
		txtNroCelular.clear();
		txtNroCelular.sendKeys(nroCel);
		
		selectText(operador, cmbOperador);
		
		if (next)
			btnSiguiente1.click();
		
		Thread.sleep(2000);
	}
	
	public void ingresarDatosDireccion(String pais, String depa, String ciudad, String distrito, String direc) throws InterruptedException {
		selectText(pais, cmbPais);
		selectText(depa, cmbDepartamento);
		selectText(ciudad, cmbCiudad);
		selectValue(distrito, cmbDistrito);
		
		txtDireccion.clear();
		txtDireccion.sendKeys(direc);
		
		btnSiguiente2.click();
		
		Thread.sleep(1500);
	}
	
	public void ingresarDatosTarjeta() throws InterruptedException {
		btnFinalizar.click();
	}
	
	public void ingresarDatosPaypal(String clave) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		
		String mainWindows = iterator.next();
		String subWindowHandler = iterator.next();

		driver.switchTo().window(subWindowHandler);
		wait.until(ExpectedConditions.visibilityOf(txtClavePaypal));
		
		txtClavePaypal.sendKeys(clave);
		btnAutorizar.click();
		
		driver.switchTo().window(mainWindows);
		
		wait.until(ExpectedConditions.visibilityOf(lblMensajeValidacion));
	}
	
	public void selectText(String valor, WebElement e) {
		Select passCnt = new Select(e);
		passCnt.selectByVisibleText(valor);
	}
	
	public void selectValue(String valor, WebElement e) {
		Select passCnt = new Select(e);
		passCnt.selectByValue(valor);
	}
	
}
