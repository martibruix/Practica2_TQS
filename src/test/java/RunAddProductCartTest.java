import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/addproductcart.feature", glue="steps")
public class RunAddProductCartTest extends AbstractTestNGCucumberTests{

}