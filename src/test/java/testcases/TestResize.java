package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestResize {
	
	
	
		public static void main(String[] args) {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); 
			driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 

			
			
			WebElement corner = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
			
			new Actions(driver).dragAndDropBy(corner, 1000, 500).perform();
			
		
}
}
