import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/loginincorrecte.feature", glue="steps")
public class RunLogInIncorrecteTest extends AbstractTestNGCucumberTests{

}