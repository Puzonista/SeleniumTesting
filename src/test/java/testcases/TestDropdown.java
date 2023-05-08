package testcases;

import java.awt.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); 
		driver.get("http://www.wikipedia.org");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	
		//driver.findElement(By.id("serchLanguage")).sendKeys("Eesti");
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select select = new Select(dropdown);
		//select.selectByVisibleText("Eesti");
		//select.selectByValue("hi");
		select.selectByIndex(0);
		
		
		driver.findElements(By.id("abc")).get(1).click();
		java.util.List<WebElement> values = driver.findElements(By.tagName("option"));
		
		System.out.println("Total values in dropdown are:" +values.size());
		
		System.out.println(values.get(0).getText());
		System.out.println(values.get(0).getAttribute("lang"));
		
		for(int i=0; i<values.size(); i++) {
			System.out.println(values.get(i).getText());
			
		}
		
		System.out.println("---Print all links---");
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));
		
		
		java.util.List<WebElement> links = block.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		for(WebElement link: links) {
			System.out.println(link.getText() + "URL:  "+link.getAttribute("href"));
		}
		
		}
		
	}
	


