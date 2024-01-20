import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/loginbuit.feature", glue="steps")
public class RunLogInBuitTest extends AbstractTestNGCucumberTests{

}
