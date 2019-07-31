package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src\\main\\java\\Feature\\discovery.feature",
	    glue= "step_defination",
	    monochrome=true)

public class TestRunner {
	

}
