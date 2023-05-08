package testcases;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v112.network.Network;
import org.openqa.selenium.devtools.v112.network.model.Request;
import org.openqa.selenium.devtools.v112.network.model.Response;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestGetURLRequestAndResponseStatus {

	public static void main(String[] args) {
	
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); 
		
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(),Optional.empty() , Optional.empty()));
		
		devTools.addListener(Network.requestWillBeSent(), request->{
			
			Request req = request.getRequest();
			
			System.out.println("Request URL is : "+req.getUrl()+" Reqest status is : "+req.getHeaders());
			
			
		});
		devTools.send(Network.enable(Optional.empty(),Optional.empty() , Optional.empty()));
		
		devTools.addListener(Network.responseReceived(), response->{
			
			Response res = response.getResponse();
			
			System.out.println("Response URL is : "+res.getUrl()+" Response status is : "+res.getHeaders());
			
			
		});
		
		driver.get("https://reqres.in/api/users?page=2");
	}

}
