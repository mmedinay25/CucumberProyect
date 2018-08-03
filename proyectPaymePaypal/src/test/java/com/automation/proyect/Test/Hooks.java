package com.automation.proyect.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;
	
	@Before
	public void before(Scenario scenario) {
	    System.out.println("--------------------------------------------------------------------");
	    System.out.println("Iniciando Escenario: " + scenario.getName());
	    System.out.println("--------------------------------------------------------------------");
	
	    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
	   
		driver = new FirefoxDriver();	
	    
	    driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
 	}
	
	@After
	public void after(Scenario scenario) {
		System.out.println("-----------------------------------------");
	    System.out.println("Estado ejecución: " + scenario.getStatus());
	    System.out.println("-----------------------------------------");
	    
	    driver.quit();	  
	}
}
