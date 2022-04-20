package stepDefination;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Assignment01StepDefinations {
	WebDriver driver;
	
	@Given("user is on saucedemo homepage")
	public void user_is_on_saucedemo_homepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0032QT744\\eclipse-workspace\\Practice\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://www.saucedemo.com/");
	}

	@Given("user logged in using correct credential")
	public void user_logged_in_using_correct_credential(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
	    driver.findElement(By.name("user-name")).sendKeys(data.get("username"));
	    driver.findElement(By.name("password")).sendKeys(data.get("password"));
	    driver.findElement(By.name("login-button")).click();
	}

	@Given("user adds required item to cart")
	public void user_adds_required_item_to_cart() {
	    driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")).click();
	    driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-fleece-jacket']")).click();

	}

	@Given("user proceeds to checkout")
	public void user_proceeds_to_checkout() {
	    driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	    driver.findElement(By.name("checkout")).click();

	}

	@Given("user enters the following details for checkout")
	public void user_enters_the_following_details_for_checkout(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
	    driver.findElement(By.name("firstName")).sendKeys(data.get("FirstName"));
	    driver.findElement(By.name("lastName")).sendKeys(data.get("LastName"));
	    driver.findElement(By.name("postalCode")).sendKeys(data.get("PostalCode"));
	    driver.findElement(By.name("continue")).click();

	}

	@When("user confirm checkout")
	public void user_confirm_checkout() {
	    driver.findElement(By.name("finish")).click();
	}

	@Then("user verify final confirmation messagge")
	public void user_verify_final_confirmation_messagge() {
		String x = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']")).getText();
	   Assert.assertEquals(x, "THANK YOU FOR YOUR ORDER");
	   driver.close();
	}
	@Given("user adds one item and then remove that item to go back")
	public void user_adds_one_item_and_then_remove_that_item_to_go_back() {
	    driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-backpack']")).click();
	    driver.findElement(By.xpath("//button[@name='remove-sauce-labs-backpack']")).click();
	}

	@Given("user sorts item low to high")
	public void user_sorts_item_low_to_high() {
	    WebElement ele = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
	    Select s= new Select(ele);
	    s.selectByIndex(2);
	}



}