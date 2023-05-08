package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJavaScript {

	public static void main(String[] args) {
		
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); 
		driver.get("https://w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("accept-choices")).click();
		
		driver.switchTo().frame("iframeResult");
		
		System.out.println(driver.findElement(By.id("mySubmit")));
		//JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		
		driver.executeScript("arguments[0]. setAttribute('style', 'border:2px solid red; background:yellow')", driver.findElement(By.xpath("/html/body/button")));
	}

}
