package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/SignUpForFocusInsights.feature",
        plugin = {"pretty","html:results/html/signUpCucumber-pretty"},
        glue = {"StepDefinitions"}
)
public class signUpRunner extends AbstractTestNGCucumberTests {
}
