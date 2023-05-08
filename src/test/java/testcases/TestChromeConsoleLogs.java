package testcases;

import java.time.Duration;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.console.Console;
import org.openqa.selenium.devtools.v109.log.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestChromeConsoleLogs {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();

		devTools.send(Log.enable());
		devTools.send(Console.enable());

		devTools.addListener(Log.entryAdded(), entry -> {

			System.out.println("text is : " + entry.getText());
			System.out.println("timestamp is : " + entry.getTimestamp());
			System.out.println("level is : " + entry.getLevel());
			System.out.println("source  is : " + entry.getSource());

		});

		devTools.addListener(Console.messageAdded(), message -> {

			System.out.println("message is : " + message.getText());

		});
		driver.get("https://google.com");

		// driver.findElement(By.xpath("//div/div[2]/div/div[2]/button[1]")).click();

		driver.executeScript("console.log('Hi how are you?')");
	}

}
