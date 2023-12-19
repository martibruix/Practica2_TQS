package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactSteps {
	
	WebDriver driver;
	
	@Given("the user is in the index page")
	public void theUserIsInTheIndexPage()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.demoblaze.com/index.html");
	}
	
	@When("the user clicks the contact option")
	public void theUserClicksTheContactOption()
	{
		driver.findElement(By.cssSelector("a.nav-link[href='#'][data-toggle='modal'][data-target='#exampleModal']")).click();
	}
	
	@When("the user enters mail in contact email")
	public void theUserEntersMailInContactEmail()
	{
		driver.findElement(By.id("recipient-email")).sendKeys("mail@gmail.com");
	}
	
	@When("the user enters name in contact name")
	public void theUserEntersNameInContactName()
	{
		driver.findElement(By.id("recipient-name")).sendKeys("nom");
	}
	
	@When("the user enters the message in message")
	public void theUserEntersTheMessageInMessage()
	{
		driver.findElement(By.id("message-text")).sendKeys("missatge");
	}
	
	@When("the user clicks the send message button")
	public void theUserClicksTheSendMessageButton()
	{
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}
	
	@When("the user clicks the about us option")
	public void theUserClicksTheAboutUsOption()
	{
		driver.findElement(By.cssSelector("a.nav-link[href='#'][data-toggle='modal'][data-target='#videoModal']")).click();
	}
	
	@When("the user clicks the play button")
	public void theUserClicksThePlayButton()
	{
		WebElement videoElement = driver.findElement(By.id("example-video_html5_api"));
		((JavascriptExecutor) driver).executeScript("arguments[0].play();", videoElement);
	}
	
	@Then("the pop up message appears")
	public void thePopUpMessageAppears()
	{
		String text = driver.switchTo().alert().getText();
		Assert.assertTrue(text.contains("Thanks for the message!!"));
	}
	
	@Then("the video starts")
	public void theVideoStarts()
	{
		WebElement videoElement = driver.findElement(By.id("example-video_html5_api"));
		boolean isPlaying = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].paused === false;", videoElement);
		Assert.assertTrue(isPlaying);
	}

}
