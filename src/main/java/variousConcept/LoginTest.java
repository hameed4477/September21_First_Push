package variousConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	static WebDriver driver ;// needs to be global to work with all methods inside the class


	public static void main(String[] args) throws InterruptedException  {
		launchBrowser();
		loginTest();
		tearDown();
		

	}
	public static void launchBrowser() {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\HAMID\\Selenium\\session1\\driver\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe"); ==> they all do the same
			//System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");==> they all do the same
			//System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");==> they all do the same
			driver = new ChromeDriver();
			driver.get("https://techfios.com/billing/?ng=admin/ ");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
	}
	public static void loginTest() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");// to put the user name
		driver.findElement(By.id("password")).sendKeys("abc123");// to put the password
		driver.findElement(By.name("login")).click();// to click
		Thread.sleep(3000);// to add 3 second delay before closing and also add throws
	}
	public static void tearDown() {
		driver.close();// close the page 
	}
}
