import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/categories.feature", glue="steps")
public class RunCategoriesTest extends AbstractTestNGCucumberTests{

}