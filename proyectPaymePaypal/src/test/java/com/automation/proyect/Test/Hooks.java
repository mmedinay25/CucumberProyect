package com.automation.proyect.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	    
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//	    System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
	    
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();	
	    
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().maximize();
		
//	    driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
 	}
	
	@After
	public void after(Scenario scenario) {
		System.out.println("-----------------------------------------");
	    System.out.println("Estado ejecución: " + scenario.getStatus());
	    System.out.println("-----------------------------------------");
	    
	    driver.quit();	  
	}
}
