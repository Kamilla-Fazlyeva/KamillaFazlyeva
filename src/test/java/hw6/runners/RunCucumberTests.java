package hw6.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/hw6", glue = "hw6")
public class RunCucumberTests extends AbstractTestNGCucumberTests {
}
