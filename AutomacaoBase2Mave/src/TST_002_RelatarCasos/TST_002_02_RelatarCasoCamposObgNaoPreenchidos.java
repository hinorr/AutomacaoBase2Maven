package TST_002_RelatarCasos;


import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import br.com.base2.arquivo.debug.LogDebug;
import br.com.base2.arquivo.test.result.LogTestResult;
import br.com.base2.auxiliar.Login;
import br.com.base2.entidades.Caso;


public class TST_002_02_RelatarCasoCamposObgNaoPreenchidos {
  
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private Login login;
	private LogDebug loggerDebug;
	private LogTestResult loggerTestResult;
	private Caso caso;
		
	
	@Before
	public void setUp() throws Exception {		
		
		this.login = new Login();
		this.loggerDebug = new LogDebug(this.getClass());
		this.loggerTestResult = new LogTestResult(this.getClass());
		this.caso = new Caso();
    
	}

	
	@Test
	public void cadastrarAvaliado() throws Exception {
		
		loggerDebug.debug("Teste Iniciado");
		    
		try{
			
			driver = login.executaLogin();
				
			/*
			 * Selecionar o menu Relatar Caso
			 * @param Luciano Silva's Project
			 */
			driver.findElement(By.cssSelector("a[href='/bug_report_page.php']")).click();
						
			//Selecionar Projeto
			new Select(driver.findElement(By.cssSelector("select[name='project_id']:not([class='small']"))).selectByVisibleText("Luciano Silva�s Project");
			driver.findElement(By.cssSelector("input[value='Selecionar Projeto']")).click();
			
			Thread.sleep(2000);
			
			/*
			 * Relatar Caso
			 * 	@param categoria;
			 *	@param gravidade;
			 *	@param perfil;
			 *	
			 *	@param descricao;
			 *	
			 */
			
			new Select(driver.findElement(By.name("category_id"))). selectByVisibleText(caso.getCategoria());
			new Select(driver.findElement(By.name ("severity"))).selectByVisibleText(caso.getGravidade());
			new Select(driver.findElement(By.name("profile_id"))).selectByVisibleText(caso.getPerfil());
			driver.findElement(By.name("description")).sendKeys(caso.getDescricao());
						
			//Botao Enviar Relatorio
			driver.findElement(By.cssSelector("input[value='Enviar Relat�rio']")).click();
			Thread.sleep(2000);
					
			//Capturando a mensagem de valida��o ap�s o submit
			String msgRetornadaInterface = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td/p")).getText();
			
			try{				
				//Valida��o da mensagem
				assertEquals(caso.getMsgErroRelatarCasoSemResumo(), msgRetornadaInterface);	    
				loggerTestResult.testResult("Aprovado");
				
			}catch (AssertionError erroValidaMensagemNovoCasoSemResumo){
    		
				loggerDebug.debug("Erro ao Executar o caso de Teste: " + erroValidaMensagemNovoCasoSemResumo);
    			loggerTestResult.testResult("Reprovado");
    			
    			//Avisa a api junit sobre o erro no caso de teste
    			throw erroValidaMensagemNovoCasoSemResumo;
			
    		}finally{
    
    			loggerDebug.debug("Teste Finalizado");
			
			}
			
		}catch(Exception erro){
			
			loggerDebug.debug("Erro ao Executar o cado de Teste: " + erro);
			loggerTestResult.testResult("Reprovado");
			loggerDebug.debug("Teste Finalizado");
			
			//Avisa a api junit sobre o erro no caso de teste
			throw erro;
			
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
