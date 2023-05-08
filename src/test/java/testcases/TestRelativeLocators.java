package testcases;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRelativeLocators {

	public static void main(String[] args) throws IOException {

		/*
		 * above
		 * below
		 * rightOf
		 * leftOf
		 * near 
		 * 
		 */
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://qa.way2automation.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		
		
		
		WebElement username = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.tagName("select")));
		username.sendKeys("asfbgaabaab");
		
		
		File usernameScreenshot = username.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(usernameScreenshot,  new File(".//screenshot//element.jpg"));
		
		
		System.out.println(username.getSize().height);
		System.out.println(username.getSize().width);
		System.out.println(username.getLocation());
		
		WebElement city = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.tagName("select")));
		city.sendKeys("Kielce");
		
		
		File cityScreenshot = city.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(cityScreenshot,  new File(".//screenshot//city.jpg"));
		
		
		
		WebElement password = driver.findElement(RelativeLocator.with(By.name("password")).toRightOf(By.tagName("label")));
		
		password.sendKeys("dfafdbadfg");
		
		
		/*WebElement leftOf = driver.findElement(RelativeLocator.with(By.linkText("Signin")).toLeftOf(By.xpath("(//input[@value='Submit'])[2]")));
		 * 
		 * 
		 */
		
		//leftOf.click();
		
		WebElement near = driver.findElement(RelativeLocator.with(By.linkText("ENTER TO THE TESTING WEBSITE")).near(By.linkText("Signin")));
		
		near.click();
	
		
	}

}
