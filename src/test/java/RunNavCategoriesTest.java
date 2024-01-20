import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/navcategories.feature", glue="steps")
public class RunNavCategoriesTest extends AbstractTestNGCucumberTests{

}