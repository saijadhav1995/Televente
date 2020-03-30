package testCases;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="src\\main\\resources\\features",
glue={"pages"},
plugin= {"pretty","html:target/cucumber-html-report","json:target/Cucumber.json"})



public class TestRunner {

	
	
}
