package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features/Login.feature",
        glue = {"stepDefinitions"},
        dryRun = true,
        monochrome = true,
        plugin = {"pretty", "html:testOutput/test-output.html"}
)
public class TestRun {
}
