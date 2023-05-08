package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckboxes {
	

	
	
	
	public static WebDriver driver;
	public static boolean isElementPresent(By by) {
	/*
		
	try {
	driver.findElement(By.xpath(xpath));
	return true;
	}
	catch(Throwable t) {
			
			return false;
			
		} */
		int size = driver.findElements(by).size();
		
		if(size == 0) {
			
			return false;
		}else {
			return true;
		}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); 
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		
		/*
		int i=1;
		int count=0;
		while(isElementPresent(By.xpath("//div[4]/input["+i+"]"))) {
			
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
			i++;
			count++;
			
		}
		
		System.out.println("total checkboxes: -- "+count);
		
		
		*/
		/*
		for(int i=1; i<=4; i++) {
		driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
		
		}
		
*/
		WebElement block = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> checkboxes = block.findElements(By.name("sports"));
		System.out.println(checkboxes.size());
		
		for(WebElement checkbox: checkboxes) {
			
			checkbox.click();
		}
		/*
		WebElement block1 = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> checkboxes1 = block1.findElements(By.xpath("//input[@checked='yes']"));
		System.out.println(checkboxes.size());
		
		for(WebElement checkbox: checkboxes1) {
			
			checkbox.click();
		}*/


	}

}
