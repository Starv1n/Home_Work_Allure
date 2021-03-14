package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        glue = "stepdefs",
        features = "src/test/resources/features/avitoTest.feature"
)

public class ElementsTest extends AbstractTestNGCucumberTests {
}
