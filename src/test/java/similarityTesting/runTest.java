package similarityTesting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/similarityTesting/features",
        glue = "similarityTesting.stepDefinition"
)

public class runTest {
}
