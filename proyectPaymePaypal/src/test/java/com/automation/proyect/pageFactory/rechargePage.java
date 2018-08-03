package com.automation.proyect.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class rechargePage {

	final WebDriver driver;

	private String RECARGA_URL = "https://calidad.alignetsac.com/WALLET/faces/pages/session/paypal_recharge.xhtml";

	@FindBy(id = "formulario_login:signin-correo-ingreso")
	public WebElement txtUsername;

	@FindBy(id = "formulario_login:contrasenia_1")
	public WebElement txtPassword;

	@FindBy(id = "formulario_login:signin-boton")
	public WebElement btnIngresar;

	@FindBy(id = "montoDolar")
	public WebElement txtMontoRecargar;

	@FindBy(id = "cbo-cta")
	public WebElement cmbMoneda;

	@FindBy(xpath = "//*[@id='content-exchange-rate']/div[2]")
	public WebElement lblMontoSoles;

	@FindBy(xpath = "//*[@id='ajaxContent']/div[1]/div[2]")
	public WebElement lblComision;

	@FindBy(xpath = "//*[@id='ajaxContent']/div[2]/div[2]")
	public WebElement lblTotalPagar;

	@FindBy(id = "register-boton")
	public WebElement btnGenerarCodigo;
	
	@FindBy(id = "div-alerta")
	public WebElement lblMensajeValidacion;

	@FindBy(xpath = "//*[@id='contentForm']/div[1]/div/div[2]/div/div/div/div[2]/div/div[1]/b")
	public WebElement lblCodigoRecarga;

	@FindBy(xpath = "//*[@id='contentForm']/div[1]/div/div[2]/div/div/div/div[2]/div/div[2]/b")
	public WebElement lblTotalPagarVerification;

	@FindBy(id = "paypalConsulta")
	public WebElement lnkMovimientos;

	public rechargePage(WebDriver driver) {
		this.driver = driver;
	}

	public void Access() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(btnGenerarCodigo));

		if (!RECARGA_URL.equals(driver.getCurrentUrl())) {
			throw new IllegalStateException("Esta no es la página de recarga");
		}

	}

	public void recargar(String monto, String codMoneda, boolean verificar) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		txtMontoRecargar.sendKeys(monto);
		selectValue(codMoneda);

		Thread.sleep(2000);

		if (verificar == false) {
			btnGenerarCodigo.click();
			wait.until(ExpectedConditions.visibilityOf(lblCodigoRecarga));
		}
		
	}

	public void selectValue(String valor) {
		Select passCnt = new Select(cmbMoneda);
		passCnt.selectByValue(valor);

	}
	
	
}
