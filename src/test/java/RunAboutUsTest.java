import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/aboutus.feature", glue="steps")
public class RunAboutUsTest extends AbstractTestNGCucumberTests{

}
