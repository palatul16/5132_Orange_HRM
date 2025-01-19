package stepdefination;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeTest;
	import io.cucumber.java.After;
	import io.cucumber.java.Before;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import pompages.Loginpage;
	
	public class Steps {
		
		private WebDriver driver;
		private Loginpage Loginpage;
		
		@Before
		public void setup()
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		@After
		public void teardown()
		{
			if(driver!=null)
			{
				driver.quit();
			}
		}
		
		//@Before & @After are called as Hooks
		@Given("I am on the Opencart login page")
		public void i_am_on_the_opencart_login_page() {
		   
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			Loginpage = new Loginpage(driver);
		}
		@Given("I have entered a valid username and password")
		public void i_have_entered_a_valid_username_and_password() {
			Loginpage.enterEmail("ksg.vision23@gmail.com");
			Loginpage.enterPassword("abc123");
		}
		
		@Given("I have entered invalid {string} and {string}")
		public void i_have_entered_invalid_and_password(String username, String password) {
			Loginpage.enterEmail("abc@gmail.com");
			Loginpage.enterPassword("abc123");
		}
		@When("I click on the login button")
		public void i_click_on_the_login_button() {
		    Loginpage.clickLoginButton();
		}
		@Then("I should be logged in successfully")
		public void i_should_be_logged_in_successfully() {
		//    Assert.assertEquals(loginpage.checkLogoutLink(), true);
		}
		@Then("I should see a error message indicating {string}")
		public void i_should_see_a_error_message_indicating(String errormessage) {
		   Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
		}
		@When("I click on the \"Forgotten Password\" link")
		public void i_click_on_the_forgotten_password_link() {
		    Loginpage.clickForgottenPasswordLink();
		}
		@Then("I should be redirected to the password reset page")
		public void i_should_be_redirected_to_the_password_reset_page() {
		  
		}
	}

