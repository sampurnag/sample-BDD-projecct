package stepDefinations;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginDefination {

	
	WebDriver driver;
	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sampurna_Gadipudi\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() {
	    String title=driver.getTitle();
	    Assert.assertEquals("CRMPRO   - CRM software for customer relationship management, sales, and support ", title);
	    //Assert.assertEquals(expected, actual);
	    
	}

	@Then("^user enters \"(.*?)\" and \"(.*?)\"$")
	public void user_enters_and(String username, String password) {
	    driver.findElement(By.name("username")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
   WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']")); 
	   JavascriptExecutor js=(JavascriptExecutor)driver;
  js.executeScript("arugments[0].click();",loginBtn);
		
		//driver.findElement(By.xpath("//input[@type='submit']")).click(); 
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page() {
		
		String title=driver.getTitle();
		System.out.println("Home page titke is:"+title);
		Assert.assertEquals("CRMPRO", title);
		
	    
	}

	@Then("^user moves to new contact page$")
	public void user_moves_to_new_contact_page() {
	   driver.switchTo().frame("mainpanel");
	   Actions action=new Actions(driver);
	   action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
	   driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	   
	}

	@Then("^user enters  contact\"(.*?)\" and \"(.*?)\" and  \"(.*?)\"$")
	public void user_enters_the_and(String firstname, String lastname,String position) {
	    driver.findElement(By.id("first_name")).sendKeys(firstname);
	    driver.findElement(By.id("surname")).sendKeys(lastname);
	    driver.findElement(By.id("company_position")).sendKeys(position);
	    driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	}
	@Then("^close the browser$")
	public void close_the_browser()
	{
		driver.quit();
	}


}
