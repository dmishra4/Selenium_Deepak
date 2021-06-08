package com.hydroottawa.ccbupgrade.poc.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/test/resources/com/hydroottawa/ccbupgrade/features",glue= {"com.hydroottawa.ccbupgrade.poc.stepdefs"},
plugin= {"html:Reports/Cucumber-StandardReport",
		  "json:target/Cucumber-Report/cucumber.json",
		  "com.cucumber.listener.ExtentCucumberFormatter:Reports/Cucumber-AdvanceReport/report.html"},
tags= {
		//"@Login"
		"@MeterRead"
		}
		
)
public class POC_Runner {

}
