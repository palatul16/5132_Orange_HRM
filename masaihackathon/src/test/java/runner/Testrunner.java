package runner;


	import org.testng.annotations.DataProvider;
	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;
	
	
	@CucumberOptions(
			
			features = {"/Users/paraskumarzumbaralalsanghavi/Documents/workspace-spring-tool-suite-4-4.27.0.RELEASE/masaihackathon/features/Loginpage.feature"},
			glue = {"stepdefination"},
			plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
			monochrome=true,
			publish=true
			)
	
	public class Testrunner extends AbstractTestNGCucumberTests {
		@DataProvider(parallel=true)
		public Object [][] scenario()
		{
			return super.scenarios();
		}
	}
