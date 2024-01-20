package steps;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AllSteps {
	
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
	
	@When("the user clicks the log in option")
	public void theUserClicksTheLogInOption()
	{
		driver.findElement(By.id("login2")).click();
	}
	
	@When("the user clicks the log in button")
	public void theUserClicksTheLogInButton()
	{
		driver.findElement(By.cssSelector("button[onclick='logIn()']")).click();
	}
	
	@When("the user enters log in username {string}")
	public void theUserEntersLogInUsername(String username)
	{
		driver.findElement(By.id("loginusername")).sendKeys(username);
	}
	
	@When("the user enters log in password {string}")
	public void theUserEntersLogInPassword(String password)
	{
		driver.findElement(By.id("loginpassword")).sendKeys(password);
	}
	
	@When("the user clicks the log out option")
	public void theUserClicksTheLogOutOption()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement LogOut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));
		LogOut.click();
	}
	
	@When("the user clicks the product image option")
	public void theUserClicksTheProductImageOption()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='prod.html?idp_=1']")));
		productLink.click();
	}
		
	@When("the user clicks to close the pop up")
	public void theUserClicksToCloseThePopUp()
	{
		WebDriverWait popupwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Esperar a que aparezca la alerta (popup) con el mensaje "Product added"
        popupwait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	@When("the user clicks the cart option")
	public void theUserClicksTheCartOption()
	{
		driver.findElement(By.cssSelector("a#cartur.nav-link")).click();
	}
	
	@When("the user clicks the delete option")
	public void theUserClicksTheDeleteOption()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Delete')]")));
        deleteLink.click();
	}
	
	@When("the user clicks the Place Order option")
	public void theUserClicksThePlaceOrderOption()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By placeOrderButtonLocator = By.cssSelector("button.btn.btn-success[data-toggle='modal'][data-target='#orderModal']");
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(placeOrderButtonLocator));

        // Hacer clic en el botón "Place Order"
        placeOrderButton.click();
	}
	
	@When("the user enters name in name")
	public void theUserEntersNameInName()
	{
		driver.findElement(By.id("name")).sendKeys("Prova_TQS");
	}
	
	@When("the user enters the credit card in credit card")
	public void theUserEntersTheCreditCardInCreditCard()
	{
		driver.findElement(By.id("card")).sendKeys("123456789");
	}
	
	@When("the user clicks the Purchase button")
	public void theUserClicksThePurchaseButton() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement purchaseButton = driver.findElement(By.cssSelector("button.btn.btn-primary[onclick='purchaseOrder()']"));
        purchaseButton.click();
	}
	
	@When("the user clicks the categories")
	public void theUserClicksTheCategories() throws InterruptedException
	{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Hacemos click en las diferentes categorias hasta llegar a la última
        WebElement categoriaNotebook = driver.findElement(By.xpath("//a[@onclick=\"byCat('notebook')\"]"));
        categoriaNotebook.click();
        Thread.sleep(1000);
        WebElement categoriaMonitor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@onclick=\"byCat('monitor')\"]")));
        categoriaMonitor.click();
	}
	
	@Then("the contact pop up message appears")
	public void theContactPopUpMessageAppears()
	{
		String text = driver.switchTo().alert().getText();
		Assert.assertTrue(text.contains("Thanks for the message!!"));
	}
	
	@Then("the empty log in pop up message appears")
	public void theEmptyLogInPopUpMessageAppears()
	{
		String text = driver.switchTo().alert().getText();
		Assert.assertTrue(text.contains("Please fill out Username and Password."));
	}
	
	@Then("the incorrect log in pop up message appears")
	public void theIncorrectLogInPopUpMessageAppears()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.alertIsPresent());
		
		String text = driver.switchTo().alert().getText();
		Assert.assertTrue(text.contains("Wrong password."));
	}
	
	@Then("the video starts")
	public void theVideoStarts()
	{
		WebElement videoElement = driver.findElement(By.id("example-video_html5_api"));
		boolean isPlaying = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].paused === false;", videoElement);
		Assert.assertTrue(isPlaying);
	}
	
	@Then("the log out option appears")
	public void theLogOutOptionAppears()
	{
		driver.findElement(By.id("logout2"));
	}
	
	@Then("the welcome {string} message appears")
	public void theWelcomeMessageAppears(String name)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		String message = welcome.getText();
		Assert.assertTrue(message.contains("Welcome "+name));
	}
	
	@Then("the log in option appears")
	public void theLogInOptionAppears()
	{
		driver.findElement(By.id("login2"));
	}
	
	@Then("the sign up option appears")
	public void theSignUpOptionAppears()
	{
		driver.findElement(By.id("signin2"));
	}
	
	@Then("the product detail page appears")
	public void theProductDetailPageAppears()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src*='galaxy_s6.jpg']")));
		WebElement nameElement = driver.findElement(By.cssSelector("h2.name"));
        WebElement priceElement = driver.findElement(By.cssSelector("h3.price-container"));
        WebElement descriptionElement = driver.findElement(By.cssSelector("div.tab-pane.fade.active.in p"));        
        WebElement addToCartButton = driver.findElement(By.cssSelector("a[onclick='addToCart(1)']"));

        // Realizar la aserción
        Assert.assertTrue(productImage.isDisplayed(), "La imagen no existe");
        Assert.assertTrue(addToCartButton.isDisplayed(), "El botón 'Add to cart' no está presente");
        
        // Verificar los nombres, precios y descripciones correspondientes
        Assert.assertEquals("Samsung galaxy s6", nameElement.getText());
        Assert.assertEquals("$360 *includes tax", priceElement.getText());
        Assert.assertEquals("The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.", descriptionElement.getText());

	}
	
	@Then("the user clicks the Add to cart button")
	public void theUserClicksTheAddToCartButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[onclick='addToCart(1)']")));
        addToCartButton.click();
	}
	
	@Then("the product added pop up message appears")
	public void theProductAddedPopUpMessageAppears()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // Espera a que aparezca la alerta
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	    // Obtiene el texto de la alerta
	    String text = alert.getText();
	    // Cierra la alerta
	    alert.accept();
	    // Verifica el texto de la alerta
	    Assert.assertTrue(text.contains("Product added"));
	}
	
	@Then("the product added appears")
	public void theProductAddedAppears()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src*='galaxy_s6.jpg']")));
        Assert.assertTrue(productImage.isDisplayed(), "La imagen 'galaxy_s6.jpg' no está presente");
        
        WebElement cartTable = driver.findElement(By.id("tbodyid"));

        // Verificar la presencia del texto "Samsung galaxy s6"
        WebElement textElement = cartTable.findElement(By.xpath("//td[contains(text(),'Samsung galaxy s6')]"));
        Assert.assertEquals(textElement.getText(), "Samsung galaxy s6", "Texto incorrecto" );

        // Verificar el precio "360"
        WebElement priceElement = driver.findElement(By.xpath("//td[contains(text(),'360')]"));
        Assert.assertEquals(priceElement.getText(), "360", "Precio incorrecto" );

        // Verificar la presencia del botón "Delete"
        WebElement deleteButton = driver.findElement(By.cssSelector("a[onclick*='deleteItem']"));
        Assert.assertTrue(deleteButton.isDisplayed(), "El botón 'Delete' no está presente");
	}
	
	@Then("the product is eliminated")
	public void theProductIsEliminated()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By cartTableLocator = By.id("tbodyid");
        WebElement cartTable = wait.until(ExpectedConditions.presenceOfElementLocated(cartTableLocator));
        // Verificar cuantos elementos hay dentro de tbodyid 
        int numOfProductElements = cartTable.findElements(By.tagName("tr")).size();
        // Assert para verificar que los elementos del producto se han eliminado
        Assert.assertEquals(numOfProductElements, 1, "Los elementos del producto no se eliminaron correctamente del carrito");
	}

	@Then("the thanks pop up appears")
	public void theThanksPopUpAppears()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By popupLocator = By.cssSelector(".sweet-alert.showSweetAlert.visible");
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupLocator));

        // Verificar el texto "Thank you for your purchase!"
        WebElement popupText = popup.findElement(By.tagName("h2"));
        Assert.assertEquals(popupText.getText(), "Thank you for your purchase!");

        // Verificar el texto del Name, Card Number y Amount
        WebElement popupContent = popup.findElement(By.cssSelector("p.lead.text-muted"));
        String popupContentText = popupContent.getText();
        Assert.assertTrue(popupContentText.contains("Name: Prova_TQS"));
        Assert.assertTrue(popupContentText.contains("Card Number: 123456789"));
        Assert.assertTrue(popupContentText.contains("Amount: 360 USD"));
	}
	
	@Then("the related products appear")
	public void theRelatedProductsAppear() throws InterruptedException
	{
		Thread.sleep(2000);
        // Lista de identificadores que quieres verificar
	    List<String> idsToCheck = Arrays.asList("10", "14");

	    for (String id : idsToCheck) {
	        String enlaceXpath = "//a[contains(@href, 'prod.html?idp_=" + id + "')]";
	        WebElement enlace = driver.findElement(By.xpath(enlaceXpath));

	        // Utilizar assert para verificar si el enlace está presente
	        assert enlace.isDisplayed() : "Enlace con id " + id + " no encontrado.";
	        System.out.println("Enlace con id " + id + " encontrado: " + enlace.getAttribute("href"));
	    }
	}
	
	@Then("the categories list appears")
	public void theCategoriesListAppears()
	{
		driver.findElement(By.xpath("//a[@onclick=\"byCat('phone')\"]"));
		driver.findElement(By.xpath("//a[@onclick=\"byCat('notebook')\"]"));
		driver.findElement(By.xpath("//a[@onclick=\"byCat('monitor')\"]"));
	}
	
	@Then("the buttons have the correct colors")
	public void theButtonsHaveTheCorrectColors()
	{
		WebElement sendButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
		WebElement closeButton = driver.findElement(By.cssSelector("button.btn.btn-secondary"));
		
		String sendColor = sendButton.getCssValue("background-color");
		String closeColor = closeButton.getCssValue("background-color");
		
		Assert.assertEquals("rgb(2, 117, 216)", sendColor);
		Assert.assertEquals("rgb(255, 255, 255)", closeColor);
	}

}
