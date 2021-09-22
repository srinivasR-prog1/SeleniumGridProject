package practicePrograms;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestonWindowsUsingChrome {

	
		public static WebDriver driver;
		public static final String URL = "https://srinivas_7rBXhl:z7TrNH2TbxdskjrbaLgd@hub-cloud.browserstack.com/wd/hub";
		String UserName = "sri1.as400";

		@Test(priority = 1)
		public void setUp() throws MalformedURLException {

		
			DesiredCapabilities cap = DesiredCapabilities.firefox();		
			cap.setPlatform(Platform.WINDOWS);
			cap.setCapability("acceptInsecureCerts", true);
		
		//	WebDriverManager.chromedriver().setup();
			WebDriverManager.firefoxdriver().setup();
			driver = new RemoteWebDriver(new URL(URL), cap);
			driver.get("http://practice.automationtesting.in/my-account/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		}

		@Test(priority = 2)
		public void login() {

			driver.findElement(By.name("username")).sendKeys(UserName);
			driver.findElement(By.name("password")).sendKeys("Howru? $ % ^ &");
			driver.findElement(By.name("login")).click();
			String capText = driver.findElement(By.xpath("//strong[text()='sri1.as400']")).getText();

			if (capText.contains(UserName)) {

				System.out.println("Test is Passed");
				driver.findElement(By.xpath("//a[text()='Logout']")).click();

			} else {
				System.out.println("Test is Failed");

			}

		}

		@Test(priority = 3)
		public void tearDown() {

			driver.quit();

		}


	}


