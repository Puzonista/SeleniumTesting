package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {
	
	public static String browser = "chrome";
	

	public static void main(String[] args) {
	
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			
		}else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			FirefoxDriver driver = new FirefoxDriver();
			
		}else if(browser.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			EdgeDriver driver = new EdgeDriver();
			
		}else
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://way2automation.com");
		String title = driver.getTitle();
		
		System.out.println(title);
		
		System.out.println(title.length());
		
		String expectedTitle = "Google.com";
		
		if(title.equals(expectedTitle)) {
			
			System.out.println("test case pass");
		}else {
			
			System.out.println("another title");
		}
		
		driver.quit();
	}

}
