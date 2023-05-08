package testcases;

import java.awt.Window;
import java.time.Duration;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsAndPopups {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); 
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		
		Set<String> winid = driver.getWindowHandles();
		
		java.util.Iterator<String> iterator = winid.iterator();
		String firstWindow = iterator.next();
		System.out.println("first"+firstWindow);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
		winid = driver.getWindowHandles();
		iterator = winid.iterator();
		
		
		iterator.next();
		String secondWindow = iterator.next();
		
		System.out.println(secondWindow);
		driver.switchTo().window(secondWindow);
		
		System.out.println(driver.findElement(By.xpath("/html/body/div/h3")).getText());
		
		driver.close();//2nd
		driver.switchTo().window(firstWindow)
		;
		driver.close();
	
	}

}
