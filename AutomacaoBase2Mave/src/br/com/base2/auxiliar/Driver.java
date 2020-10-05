package br.com.base2.auxiliar;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Driver {
		
	private WebDriver driver;
	private String baseUrl;	


	public Driver(){
		
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		baseUrl = "http://mantis-prova.base2.com.br";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}
	 
	
	public WebDriver retornadrive() throws Exception {
		
		return driver;
	}
		
	
}

	
	
	

