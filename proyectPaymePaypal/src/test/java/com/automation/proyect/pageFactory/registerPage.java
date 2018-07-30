package com.automation.proyect.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class registerPage {

	final WebDriver driver;

	private String LOGIN_URL = "https://calidad.alignetsac.com/WALLET/faces/pages/registerUser.xhtml";

	public registerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "form_signin:nombre")
	public WebElement txtNombres;

	@FindBy(id = "form_signin:apellidos")
	public WebElement txtApellidos;

	@FindBy(id = "form_signin:correo_2")
	public WebElement txtCorreo;

	@FindBy(id = "form_signin:opt-pais2-th")
	public WebElement cmbPais;

	@FindBy(id = "form_signin:contraseña-th")
	public WebElement tctClave;

	@FindBy(id = "form_signin:confirmar-contraseña-th")
	public WebElement txtClave_confir;

	@FindBy(id = "form_signin:condiciones")
	public WebElement chkTerminos_condiciones;

	@FindBy(id = "form_signin:signin-boton2")
	public WebElement bntRegistar;

	@FindBy(id = "div-alerta")
	public WebElement lblMensajeValidacion;

	
	
	public void Access() {
		driver.get(LOGIN_URL);

		if (!LOGIN_URL.equals(driver.getCurrentUrl())) {
			throw new IllegalStateException("Esta no es la página de Registro de Pay-me");
		}

	}
	
	public String mensajeValidacion() {

		return lblMensajeValidacion.getText();

	}

}
