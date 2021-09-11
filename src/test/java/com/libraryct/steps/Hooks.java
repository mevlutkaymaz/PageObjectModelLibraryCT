package com.libraryct.steps;

import com.libraryct.testbase.BaseClass;
import com.libraryct.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static Scenario scenario;
	@Before
	public void start(Scenario scenario) {
		BaseClass.setUp();
		Hooks.scenario=scenario;
	}
	@After
	public void end(Scenario scenario) {
		byte[] picture;
		if(scenario.isFailed())
			picture=CommonMethods.takeScreenshot("failed/"+scenario.getName());
		else
			picture=CommonMethods.takeScreenshot("passed/"+scenario.getName());
		scenario.attach(picture, "image/png", scenario.getName());
		BaseClass.quit();
	}

}
