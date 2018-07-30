package com.automation.proyect.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage{

	final WebDriver driver;

	private String LOGIN_URL = "https://calidad.alignetsac.com/WALLET/faces/pages/loginUser.xhtml";
		
	@FindBy(id = "formulario_login:signin-correo-ingreso")
	public WebElement txtUsername;

	@FindBy(id = "formulario_login:contrasenia_1")
	public WebElement txtPassword;

	@FindBy(id = "formulario_login:signin-boton")
	public WebElement btnIngresar;
	
	@FindBy(id = "formulario_login:olvido")
	public WebElement lnkOlvideClave;
	
	@FindBy(id = "formulario_login:correo-th")
	public WebElement txtCorreo;
	
	@FindBy(xpath = "//h2[contains(.,'¿Olvidaste tu contraseña?')]")
	public WebElement lblMsjOlvideClave;
	
	@FindBy(xpath = "//strong[contains(.,'Cuenta temporalmente bloqueada')]")
	public WebElement lblMensajeBloqueo;

	
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Access() {
		driver.navigate().to(LOGIN_URL);

		if (!LOGIN_URL.equals(driver.getCurrentUrl())) {
			throw new IllegalStateException("Esta no es la página de Login de Pay-me");
		}

	}

	public void Autenticator(String usuario, String clave) throws InterruptedException {
		
		txtUsername.sendKeys(usuario);
		txtPassword.sendKeys(clave);
		btnIngresar.click();
	
	}
	
	public String mensajeValidacion() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(lblMensajeBloqueo));
		
		return lblMensajeBloqueo.getText();

	}
	
	public void formularioOlvideClave() {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(txtCorreo));

	}
	
	public void login() throws InterruptedException {
		driver.navigate().to(LOGIN_URL);
		txtUsername.sendKeys("michael.medinay@gmail.com");
		txtPassword.sendKeys("Michael1%");
		btnIngresar.click();
		
		Thread.sleep(3500);
	}	
}
