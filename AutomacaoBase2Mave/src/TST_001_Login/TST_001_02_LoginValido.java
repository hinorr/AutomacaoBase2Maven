package TST_001_Login;


import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

import br.com.base2.arquivo.debug.LogDebug;
import br.com.base2.arquivo.test.result.LogTestResult;
import br.com.base2.auxiliar.Driver;
import br.com.base2.entidades.Login;


public class TST_001_02_LoginValido{
  
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private LogDebug loggerDebug;
	private LogTestResult loggerTestResult;
	private Driver _driver;
	private Login login;
	
	
	@Before
	public void setUp() throws Exception {
		
		this.login = new Login();
		this.loggerDebug = new LogDebug(this.getClass());
		this.loggerTestResult = new LogTestResult(this.getClass());		
		this._driver = new Driver();		
	   
	}

	
	@Test
	public void LoginValido() throws Exception {
		
		loggerDebug.debug("Teste Iniciado");
		    
		try{
			
			driver = _driver.getDriver();			
			
			//Inserção dos valores para Usuário e Senha
			driver.findElement(By.name("username")).sendKeys(login.getLoginValido());
			driver.findElement(By.name("password")).sendKeys(login.getSenhaValida());
			
			//Seleção do botão Entrar
			driver.findElement(By.className("button")).click();		
						
			Thread.sleep(2000);			
			
			//Buscando o usuário logado 
			String userNameLogado = driver.findElement(By.className("italic")).getText();
																		
			try{
				
				assertEquals(userNameLogado, login.getLoginValido());
				//assertEquals("coisa louc", login.getLoginValido());
				
				loggerTestResult.testResult("Aprovado");
				
			}catch (AssertionError erroValidaMensagemLoginValido){
				
				loggerDebug.debug("Erro ao Executar o caso de Teste: " + erroValidaMensagemLoginValido);
    			loggerTestResult.testResult("Reprovado");
    			
    			throw erroValidaMensagemLoginValido;
				    	
    		}finally{
    
				loggerDebug.debug("Teste Finalizado");
			
			}
			
		}catch(Exception erro){
	
			loggerDebug.debug("Erro ao Executar o caso de Teste: " + erro);
			loggerTestResult.testResult("Reprovado");
			loggerDebug.debug("Teste Finalizado");			

		}
	}
	

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		
		if (!"".equals(verificationErrorString)) {
			
			fail(verificationErrorString);
		}
	}
	
}
