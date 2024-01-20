import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/removeproductcart.feature", glue="steps")
public class RunRemoveProductCartTest extends AbstractTestNGCucumberTests{

}