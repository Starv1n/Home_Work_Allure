package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm", "pretty"},
        glue = "stepdefs",
        features = "src/test/resources/features/avitoTest.feature",
        strict = true
)

public class ElementsTest extends AbstractTestNGCucumberTests {
}
