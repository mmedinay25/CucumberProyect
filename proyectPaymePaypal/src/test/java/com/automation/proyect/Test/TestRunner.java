package com.automation.proyect.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"pe.com.automation.exam.Steps"},
		tags = {"@RecargaFeature"},
		plugin = {
				"pretty",
				"json:target/cucumber-reports/Cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports/cucumber-pretty" 	                
		        }
		)
	
public class TestRunner {
 
}