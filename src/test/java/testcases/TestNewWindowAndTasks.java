package testcases;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNewWindowAndTasks {

	public static void main(String[] args) {

		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); 
		driver.get("https://www.youtube.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		
		

		Set<String> winid = driver.getWindowHandles();
		java.util.Iterator<String> iterator = winid.iterator();
		String firstWindow = iterator.next();
		System.out.println(firstWindow);
		/*
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[1]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]")).click();
		driver.findElement(By.xpath("//div[2]/input")).sendKeys("can't stop rhcp");
		driver.findElement(By.id("search-icon-legacy")).click();
		driver.findElement(By.partialLinkText("[Official Music Video]")).click();
		*/
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Hello Selenium");
		
		winid = driver.getWindowHandles();
		iterator = winid.iterator();
		iterator.next();
		String secondWindow = iterator.next();
		System.out.println(secondWindow);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("asdfgadg");
		
		winid = driver.getWindowHandles();
		iterator = winid.iterator();
		iterator.next();
		iterator.next();
		String thirdWindow = iterator.next();
		System.out.println(thirdWindow);
		
	
		
		
		System.out.println(driver.getWindowHandles().size());
		

		driver.close();
		driver.switchTo().window(firstWindow);
		driver.close();
		driver.switchTo().window(secondWindow);
		driver.close();

	}

}
