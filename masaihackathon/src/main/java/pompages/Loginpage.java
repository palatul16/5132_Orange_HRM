package pompages;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	
	public class Loginpage {
		
		private WebDriver driver;
		
		//Locators
		
		private By emailInputLocator = By.name("email");
		private By passwordInputLocator = By.name("password");
		private By loginButtonLocator =By.xpath("//input[@type='submit']");
		private By forgottenPasswordlinklocator =By.linkText("Forgotten Password");
		private By logoutlinklocator =By.linkText("Logout");
		
		//Constructor
		
		public Loginpage(WebDriver driver)
		{
			this.driver=driver;
		}
		
		//Methods -->Page methods are public in nature (we are following encapsulation)
		
		public void enterEmail(String email)
		{
			WebElement emailInput = driver.findElement(emailInputLocator);
			emailInput.sendKeys(email);
		}
		
		public void enterPassword(String password)
		{
			WebElement passwordInput = driver.findElement(passwordInputLocator);
			passwordInput.sendKeys(password);
		}
		
		public void clickLoginButton()
		{
			WebElement loginbutton = driver.findElement(loginButtonLocator);
			loginbutton.click();
		}
		public void clickForgottenPasswordLink()
		{
			WebElement forgottenPasswordLink = driver.findElement(forgottenPasswordlinklocator);
			forgottenPasswordLink.click();
		}
		
		public boolean checkForgotPwdLink()
		{
		  return driver.findElement(forgottenPasswordlinklocator).isDisplayed();
		}
//		public boolean checkLogoutLink()
//		{
//		//  return driver.findElement(logoutlinklocator).isDisplayed();
//		}
	//	
		public void login(String email, String password)
		{
			enterEmail(email);
			enterPassword(password);
			clickLoginButton();
		}
		
		public String getForgotPwdPageUrl ()
		{
			String forgotPwdPageUrl = driver.getCurrentUrl();
			return forgotPwdPageUrl;
		}
	}

