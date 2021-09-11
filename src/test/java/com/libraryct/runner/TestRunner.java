package com.libraryct.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//you can specify which feature file to run or you can choose all of them such as this feature file
		features ="src/test/resources/features/",
		//where the steps files implementation
		glue = "com.libraryct.steps",
		//if true it doesn't run the steps, just checks if the implementation is there
		dryRun=false,
		//same as groups in testNG
		//tags="@filter",
		monochrome =false,
		plugin= {
				"pretty", //prints gherkin steps in console
				"html:target/cucumber-default-report", //create a basic html report in target folder
				"json:target/cucumber.json",
				"rerun:target/failed.txt"
		}	
		)


public class TestRunner {

}
