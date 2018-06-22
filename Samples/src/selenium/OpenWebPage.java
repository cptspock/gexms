package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenWebPage {

	public static void getPage() {
		System.setProperty("webdriver.chrome.driver", "c:/code/selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		driver.quit();
		try {
			HttpURLConnection huc = (HttpURLConnection) new URL("http://www.google.com").openConnection();
			huc.setRequestMethod("HEAD");
			huc.connect();
			System.out.println(huc.getResponseCode());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		OpenWebPage.getPage();
	}

}
