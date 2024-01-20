import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/addproduct.feature", glue="steps")
public class RunAddProductTest extends AbstractTestNGCucumberTests{

}