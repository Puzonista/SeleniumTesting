package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebElements {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		
		driver.manage().window().maximize();
		String title = driver.getTitle();
		title.length();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		/*WebElement username = driver.findElement(By.id("identifierId"));
		username.sendKeys("krzysztof.wodkowski1@gmail.com");
		
		WebElement button = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")); 
	
		button.click();
		*/
		
		driver.findElement(By.id("identifierId")).sendKeys("dfghjfgj");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
	
		
		Thread.sleep(20000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"password\\\"]/div[1]/div/div[1]/input)"))).sendKeys("adfhafh");
		//driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input)")).sendKeys("adfgha");
	}

}
