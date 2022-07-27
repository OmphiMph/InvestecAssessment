package Runners;

import StepDefinitions.signUpSteps;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/SignUpForFocusInsights.feature",
        plugin = {"pretty","html:results/html/signUpCucumber-pretty"},
        glue = {"StepDefinitions"}
)
public class signUpRunner extends AbstractTestNGCucumberTests {
        
    @AfterClass
    public  static void tearDown(){
        //Close Browser   
        signUpSteps.tearDown();
    }
}
