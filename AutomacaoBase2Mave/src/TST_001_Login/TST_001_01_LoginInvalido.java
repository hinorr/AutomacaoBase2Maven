package TST_001_Login;


import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;

import br.com.base2.arquivo.debug.LogDebug;
import br.com.base2.arquivo.test.result.LogTestResult;
import br.com.base2.auxiliar.Driver;
import br.com.base2.entidades.Login;


public class TST_001_01_LoginInvalido {
  
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private Login login;
	private LogDebug loggerDebug;
	private LogTestResult loggerTestResult;
	private Driver _driver;
	
	
	@Before
	public void setUp() throws Exception {		
		
		this.login = new Login();
		this.loggerDebug = new LogDebug(this.getClass());
		this.loggerTestResult = new LogTestResult(this.getClass());		
		this._driver = new Driver();		
	   
	}

	
	@Test
	public void loginInvalido() throws Exception {
		
		loggerDebug.debug("Teste Iniciado");
		    
		try{
			
			driver = _driver.getDriver();			
			
			//Inserção dos valores para Usuário e Senha
			driver.findElement(By.name("username")).sendKeys(login.getLoginInvalido());
			driver.findElement(By.name("password")).sendKeys(login.getSenhaInvalida());
							
			//Seleção do botão Entrar
			driver.findElement(By.className("button")).click();		
			
			Thread.sleep(2000);		
							
			//Buscando a  mensagem de usuário inválido 
			String userNameInvalido = driver.findElement(By.xpath("/html/body/div[2]/font")).getText();
 						
 			
			try{
			
				assertEquals(userNameInvalido, login.getMsgUserInvalido());
				loggerTestResult.testResult("Aprovado");
								
				
			}catch (AssertionError erroValidaMensagemLoginInvalido){
				
				loggerDebug.debug("Erro ao Executar o caso de Teste: " + erroValidaMensagemLoginInvalido);
    			loggerTestResult.testResult("Reprovado");
    						
    			
    			throw erroValidaMensagemLoginInvalido;
				    	
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
