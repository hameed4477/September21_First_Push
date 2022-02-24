package variousConcept;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_Junit {
	static WebDriver driver ;// needs to be global to work with all methods inside the class
	
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}
	@Before
	public  void launchBrowser() {
		System.out.println("launch Browser");
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\HAMID\\Selenium\\session1\\driver\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe"); ==> they all do the same
			//System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");==> they all do the same
			//System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");==> they all do the same
			driver = new ChromeDriver();
			//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);// the sys is gonna wait 60seconds before ending.
			driver.get("https://techfios.com/billing/?ng=admin/ ");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
	}
	@Test
	public  void loginTest() throws InterruptedException {
		System.out.println("Positive Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");// to put the user name
		driver.findElement(By.id("password")).sendKeys("abc123");// to put the password
		driver.findElement(By.name("login")).click();// to click
		Thread.sleep(3000);// to add 3 second delay before closing and also add throws
	}
	@Test
	public  void negloginTest() throws InterruptedException {
		System.out.println("Negative Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");// to put the user name
		driver.findElement(By.id("password")).sendKeys("abc1235");// to put the password
		driver.findElement(By.name("login")).click();// to click
		Thread.sleep(3000);// to add 3 second delay before closing and also add throws
	}
	@After
	public  void tearDown() {
		System.out.println("Tear down");
		driver.close();// close the page 
		driver.quit();// close all WebDriver instances and browsers that are open
	}
}
