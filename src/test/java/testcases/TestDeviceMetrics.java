package testcases;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDeviceMetrics {

	public static void main(String[] args) {

				
			
			
			ChromeDriver driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); 
			
			DevTools devTools = ((ChromeDriver) driver).getDevTools();
			devTools.createSession();
			Map<String,Object> deviceMetrics = new HashMap<String,Object>()
					{{
						put("width",600);
						put("height",1000);
						put("mobile",true);
						put("deviceScaleFactor",600);
					}};
			
			((ChromeDriver) driver).executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMetrics);
			
			
			
			//devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
			
			driver.get("https://selenium.dev");
			driver.manage().window().maximize();
	}

}
