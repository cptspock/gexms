package webdriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CrossBrowserTest {
	//private Selenium selenium;
	private WebDriver driver;

	@Parameters({ "browser", "port" })
	@BeforeClass
	public void beforeClass(String browser, String port) {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName(browser);
		try {
		    driver = new RemoteWebDriver(new URL("http://localhost:"
					.concat(port).concat("/wd/hub")), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void search() throws InterruptedException {
		driver.get("http://maps.google.com");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		WebElement map = driver.findElement(By.id("map"));
		action.moveToElement(map);
		action.contextClick(map).build().perform();
		Thread.sleep(5000L);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
