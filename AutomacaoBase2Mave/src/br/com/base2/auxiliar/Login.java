package br.com.base2.auxiliar;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Login {
		
	private WebDriver driver;
	private String baseUrl;	


	public Login(){
		
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://mantis-prova.base2.com.br";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.get(baseUrl);
		
	}
	 
		
	public WebDriver executaLogin() throws Exception {
		
		try{
			//Inserção dos valores para Usuário e Senha
			driver.findElement(By.name("username")).sendKeys("luciano.silva");
			driver.findElement(By.name("password")).sendKeys("132313");
			
			//Seleção do botão Entrar
			driver.findElement(By.className("button")).click();		
			
			
			
		}
		catch (Exception erro){
			
			System.out.println("Erro ao executar o Login: " + erro);
		
		}
		return driver;
		
	}
	
}

	
	
	

