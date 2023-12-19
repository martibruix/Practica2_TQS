/*package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

//import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AboutUsSteps {
	
	WebDriver driver;
	
	@When("the user clicks the about us option")
	public void theUserClicksTheAboutUsOption()
	{
		driver.findElement(By.cssSelector("a.nav-link[data-toggle='modal'][data-target='#videoModal']:contains('About us')")).click();
	}
	
	@When("the user clicks the play button")
	public void theUserClicksThePlayButton()
	{
		WebElement videoElement = driver.findElement(By.id("example-video_html5_api"));
		((JavascriptExecutor) driver).executeScript("arguments[0].play();", videoElement);
	}
	
	@Then("the video starts")
	public void theVideoStarts()
	{
		WebElement videoElement = driver.findElement(By.id("example-video_html5_api"));
		boolean isPlaying = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].paused === false;", videoElement);
		Assert.assertTrue(isPlaying);
	}

}
*/