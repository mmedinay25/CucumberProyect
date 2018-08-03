package com.automation.proyect.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homePage {

	final WebDriver driver;
	private String HOME_URL = "https://calidad.alignetsac.com/WALLET/faces/pages/session/welcome_user.xhtml";
	
	@FindBy(xpath = "//h2[contains(.,'¡Bienvenido!')]")
	public WebElement lblMensajeBienvenida;
	
	@FindBy(id = "welcomeUser:paypalRecargaHome")
	public WebElement btnRecargaYa;
	
	@FindBy(id = "welcomeUser:paypalRecargaHome")
	public WebElement btnComienzaYa;
	
	@FindBy(xpath = "//a[@class='btn pme-btn']")
	public WebElement btnAsociarAhora;
	
	@FindBy(id = "div-alerta")
	public WebElement lblMensajeValidacion;
	
	public homePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Access() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(lblMensajeBienvenida));
		
		if (!HOME_URL.equals(driver.getCurrentUrl())) {
			throw new IllegalStateException("Esta no es la página del home de Pay-me");
		}
		
	}

	public String mensajeBienvenida() {

		return lblMensajeBienvenida.getText();

	}
}
