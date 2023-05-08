package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRightClick {

	public static void main(String[] args) {
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); 
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 

		
		
		WebElement img = driver.findElement(By.xpath("//p[2]/img"));
		Actions action = new Actions(driver);
		action.contextClick(img).perform();
		
		WebElement first = driver.findElement(By.id("dm2m1i1tdT"));
		
		action.moveToElement(first).perform();
		
		WebElement second = driver.findElement(By.xpath("//*[@id=\"dm2m2i1tdT\"]"));
		
		action.moveToElement(second).perform();
		
		WebElement third = driver.findElement(By.xpath("//*[@id=\"dm2m3i1tdT\"]"));
		
		third.click();
		
		

	}

}
