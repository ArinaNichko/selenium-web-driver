package cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"cucumber.definitionSteps"}
       )
public class RunCucumberTest extends AbstractTestNGCucumberTests {

}
