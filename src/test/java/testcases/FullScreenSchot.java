package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FullScreenSchot {

	
	
	public static void main(String[] args) throws IOException {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("headless");
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("http://qa.way2automation.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		
		
		if(driver instanceof FirefoxDriver) {
		File screenshot =((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshot/ffzdjecie1.jpg"));
		}else if(driver instanceof ChromeDriver) {
		
		
		File screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshot/zdjeciefail.jpg"));
		
		System.out.println(driver.getTitle());
	}

	}
	
	}
	
	
