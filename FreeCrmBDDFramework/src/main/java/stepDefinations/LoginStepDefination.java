package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
//import junit.framework.Assert;
import cucumber.api.java.en.Then;

public class LoginStepDefination {

	WebDriver driver;
	
	
	@Given("^User is already on login page$")
	public void User_is_already_on_login_page()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sampurna_Gadipudi\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.freecrm.com");
	}
	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_free_CRM()
	{
		String title=driver.getTitle();
		System.out.println(title);
	//	Assert.assertEquals("#1 Free CRM for Any Business:Online Customer Relationship Software", title);
	}
	@Then("^user enters username and  pasword$")
	public void user_enters_username_and_pasword()
	{
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
	}
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button()
	{
		WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arugments[0].click();",loginBtn);
	}
	@Then("^user is on Homepage$")
	public void user_is_on_Homepage()
	{
		String title=driver.getTitle();
		System.out.println("Home page title:"+title);
		//Assert.assertEquals("CRMPRO", title);
	}
}
