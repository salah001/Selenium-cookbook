package fundtransfer;

import static org.junit.Assert.*;

//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;




public class FundTransferStepDefs {
	
	protected WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","/Users/salah/eclipse-workspace/SeleniumTest/src/main/resources/chromedriver1");
		driver = new ChromeDriver();
	}
	
	@Given("the user is on Fund Transfer Page")
	public void theUserisonFundTransferPage() {
		
		driver.get("http://cookbook.seleniumacademy.com/fundTransfer.html");
	}
	
	@When("he enters \"([^\"]*)\" as payee name")
	public void userEntersPayeeName(String payeeName) {
		driver.findElement(By.id("payee")).sendKeys(payeeName);
	}
	
	@And("he enters \"([^\"]*)\" as amount")
	public void userEntersAmount(String amount) {
		driver.findElement(By.id("amount")).sendKeys(amount);
	}
	
	@And("he submits request for Fund Transfer")
	public void userSubmitRequest() {
		driver.findElement(By.id("transfer")).click();
		System.out.println("transfer submitted");
	}
	
	@Then("ensure the fund transfer is complete with \"([^\"]*)\" message")
	public void ensureTransferisComplete(String msg) {
		String message = driver.findElement(By.id("message")).getText();
		System.out.println("msg: "+msg);
		System.out.println("message: "+message);
		assertEquals(msg, message);
	}
	
	@Then("ensure a transaction failure \"([^\"]*)\" is displayed")
	public void ensureTransactionFailureMessage(String msg) {
		String message = driver.findElement(By.id("message")).getText();
		System.out.println("msg: "+msg);
		System.out.println("message: "+message);
		assertEquals(msg, message);
	}
	
	@After
	public void cleanUp() {
		driver.close();
	}
}
