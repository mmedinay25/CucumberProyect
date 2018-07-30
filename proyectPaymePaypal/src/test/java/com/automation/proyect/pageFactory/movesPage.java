package com.automation.proyect.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class movesPage {

	final WebDriver driver;
	
	private String MOVIMIENTOS_URL = "https://calidad.alignetsac.com/WALLET/faces/pages/session/paypal_transactions.xhtml";
	
	@FindBy(xpath = "//h2[contains(.,'Movimientos')]")
	public WebElement lblMovimientos;
	
	@FindBy(xpath = "//*[@id='table-address']/tbody/tr[1]/td[1]/div")
	public WebElement tdCodigoPago;
	
	@FindBy(xpath = "//*[@id='table-address']/tbody/tr[1]/td[6]/div")
	public WebElement tdEstado;
	
	public movesPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void Access() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(lblMovimientos));

		if (!MOVIMIENTOS_URL.equals(driver.getCurrentUrl())) {
			throw new IllegalStateException("Esta no es la página de movimientos");
		}
		
		Thread.sleep(1500);

	}
	
	
	
}
