package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMauseMovement {

	public static void main(String[] args) {
	
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); 
		driver.get("https://www.way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 

		
		
		
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"menu-item-27597\"]/a/span[2]"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(menu).perform();  
		driver.findElement(By.linkText("Lifetime Membership")).click();
	}

}
