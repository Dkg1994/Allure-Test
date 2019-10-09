package Testprojectmaven.goibibo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import junit.framework.TestListener;


@Epic("Regression Tests")
@Feature("Login Tests")
public class Test1 {
	
	public WebDriver driver;
	
	
	@BeforeTest
	public void beforeTest(){
		
System.setProperty("webdriver.chrome.driver","D:\\Eclips backup\\Jar Files for use in selenium\\chromedriver.exe");
		
         driver = new ChromeDriver();
         
         driver.manage().window().maximize();
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
	}
	@Test(priority=0,description="Sign_In Test Case")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify Sign In functionality")
	@Story("Test verify sign in")
  
	
	@Step("Navigate to Goibibo")
  public void test() throws InterruptedException {
		
        driver.get("https://www.goibibo.com");
    	Thread.sleep(3000);

  
	
    driver.findElement(By.id("get_sign_in")).click();
    
    Thread.sleep(2000);
    
    driver.switchTo().frame("authiframe");
    
    
   Thread.sleep(1000);
    
   driver.findElement(By.id("authMobile")).sendKeys("8858558819");
   
   Thread.sleep(1000);
   
   driver.findElement(By.xpath("//*[@id=\"mobileSubmitBtn\"]")).click();
   
   Thread.sleep(2000);
   
   driver.findElement(By.id("authCredentialPassword")).sendKeys("8858558819");
   
   Thread.sleep(3000);
   
   driver.findElement(By.xpath("//*[@id=\"passwordEyeMobilePassword\"]")).click();
   
   Thread.sleep(2000);
   
   driver.findElement(By.id("authCredentialPasswordSignInBtn")).click();
   
   Thread.sleep(5000);
         
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		System.out.println(result.getMethod().getMethodName() + " failed!");

		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");

		// attach screenshots to report
		saveFailureScreenShot(driver);
	}
	

	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	

	
	
	@AfterTest
	
	public void afterTest() {
		driver.quit();
	}

	

	
	
	
	
}
