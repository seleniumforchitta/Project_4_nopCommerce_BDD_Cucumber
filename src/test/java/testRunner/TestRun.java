package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = ".//Features/Customer.feature",
		glue= {"stepDefinitions"},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output"}
		)

/*@RunWith(Cucumber.class)

@CucumberOptions(
features = {"src/test/java/Features"},
tags= {"@FirstTimeLaunch, @SignUpPage"},
glue= {"testCode"},
plugin = { "pretty", "html:target/htmlreports" }
)
*/

public class TestRun {

}
