import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/checkbuttoncolor.feature", glue="steps")
public class RunCheckButtonColorTest extends AbstractTestNGCucumberTests{

}