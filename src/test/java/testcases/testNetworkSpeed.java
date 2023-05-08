package testcases;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.ConnectionType;
import org.openqa.selenium.devtools.v112.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testNetworkSpeed {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); 
		
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		
		
		
		devTools.send(Network.enable(Optional.empty(),Optional.empty() , Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 100, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
	
		
		
		
		driver.get("https://youtube.com");
	}

}
