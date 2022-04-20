package stepDefination;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Test1StepDefination {
	WebDriver driver;

@Given("Launch the website http:\\/\\/elearningm{int}.upskills.in\\/index.php")
public void launch_the_website_http_elearningm_upskills_in_index_php(Integer int1) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\0032QT744\\eclipse-workspace\\Practice\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://elearningm1.upskills.in/index.php");
}

@When("I click on signUp")
public void i_click_on_signUp() {
    driver.findElement(By.xpath("//a[text()=' Sign up! ']")).click();
}

@Then("I fill up the registeration Form for all mandatory fields")
public void i_fill_up_the_registeration_Form_for_all_mandatory_fields(DataTable dataTable) {
	Map<String, String> data = dataTable.asMap(String.class, String.class);
    driver.findElement(By.name("firstname")).sendKeys(data.get("Firstname"));
    driver.findElement(By.name("lastname")).sendKeys(data.get("Lastname"));
    driver.findElement(By.name("email")).sendKeys(data.get("Email"));
    driver.findElement(By.name("username")).sendKeys(data.get("Username")); 
    driver.findElement(By.name("pass1")).sendKeys(data.get("Password"));
    driver.findElement(By.name("pass2")).sendKeys(data.get("ConfirmPassword"));
    
}

@Then("Submit the details")
public void submit_the_details() {
  driver.findElement(By.name("submit")).click();
}

@Then("Verify the Message {string}")
public void verify_the_Message(String string) {
    String message = driver.findElement(By.xpath("//p[text()='Your personal settings have been registered.']")).getText();
Assert.assertEquals("Dear Deepshikha Sharma,"+ "\n"
	+"\n"+ "Your personal settings have been registered.", message);
}

@Then("Click on Next")
public void click_on_Next() {
	  driver.findElement(By.name("next")).click();
}

@When("I am on HomePage, click on username")
public void i_am_on_HomePage_click_on_username() {
	driver.findElement(By.xpath("//a[@role='button']")).click();
}

@When("Choose profile from Dropdown")
public void choose_profile_from_Dropdown() {
//	 Select s = new Select(driver.findElement(By.xpath("//a[@role='button']")));
//	    s.selectByIndex(0);
	driver.findElement(By.xpath("//a[text() = ' Profile']")).click();
}

@When("Click on Messages")
public void click_on_Messages() {
	driver.findElement(By.xpath("//img[@title='Messages']")).click();

}

@When("Click on Compose message")
public void click_on_Compose_message() {
	driver.findElement(By.xpath("//img[@alt='Compose message']")).click();
}

@When("Enter the details shown on the page")
public void enter_the_details_shown_on_the_page(DataTable dataTable) throws InterruptedException {
	Map<String, String> data = dataTable.asMap(String.class, String.class);
    driver.findElement(By.xpath("//input[@name='title']")).sendKeys(data.get("Subject"));
    WebElement src = driver.findElement(By.xpath("//input[@role = 'textbox']"));
    src.clear();
    src.sendKeys("Ans");
    Thread.sleep(2000);
    src.sendKeys(Keys.ENTER);
}

@Then("Click on Send message")
public void click_on_Send_message() {
//	driver.switchTo().frame(0);
    driver.findElement(By.xpath("//button[@name='compose']")).click();
}
}
