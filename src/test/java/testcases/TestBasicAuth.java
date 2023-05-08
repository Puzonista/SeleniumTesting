package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBasicAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); 
		
		
		//driver.register(UsernameAndPassword.of("admin", "admin")); ->for ChromeDriver
		
			
		((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));
		driver.get("https://the-internet.herokuapp.com/basic_auth");  //----->"https://admin:admin@the-internet.herokuapp.com/basic_auth"
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 

		
		
		
		//System.out.println(driver.switchTo().alert().getText());
		
		/*
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("admin");
		*/
	}
	

}
