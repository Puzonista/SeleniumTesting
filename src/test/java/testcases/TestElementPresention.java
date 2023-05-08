package testcases;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	
	

public class TestElementPresention {
		
	public static WebDriver driver;
	public static boolean isElementPresent(By by) {
	/*
		
	try {
	driver.findElement(By.xpath(xpath));
	return true;
	}
	catch(Throwable t) {
			
			return false;
			
		} */
		int size = driver.findElements(by).size();
		
		if(size == 0) {
			
			return false;
		}else {
			return true;
		}
	}
	
	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); 
		driver.get("http://www.echoecho.com/htmlforms11.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		
		System.out.println(isElementPresent(By.name("dropdownmenu")));
	}

}
