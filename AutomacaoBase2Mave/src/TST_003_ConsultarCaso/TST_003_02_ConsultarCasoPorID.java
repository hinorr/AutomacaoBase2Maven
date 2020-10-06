package TST_003_ConsultarCaso;


import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import br.com.base.arquivo.test.result.LogTestResult;
import br.com.base2.arquivo.debug.LogDebug;
import br.com.base2.auxiliar.Login;
import br.com.base2.entidades.Caso;


public class TST_003_02_ConsultarCasoPorID {
  
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private Login login;
	private LogDebug loggerDebug;
	private LogTestResult loggerTestResult;
	private Caso caso;
	private boolean casoEncontrado;
		
	
	@Before
	public void setUp() throws Exception {		
		
		this.login = new Login();
		this.loggerDebug = new LogDebug(this.getClass());
		this.loggerTestResult = new LogTestResult(this.getClass());
		this.caso = new Caso();
		casoEncontrado = false;
    
	}

	
	@Test
	public void cadastrarAvaliado() throws Exception {
		
		loggerDebug.debug("Teste Iniciado");
		    
		try{
			
			driver = login.executaLogin();
				
			/*
			 * Consultar Caso por ID
			 * @param "0004901"
			 */
			driver.findElement(By.name("bug_id")).sendKeys(caso.getId());
			driver.findElement(By.cssSelector("input[value='Ir para']")).click();
						
			Thread.sleep(2000);
				
			
			//WebElement tabela = driver.findElement(By.id("buglist"));
			WebElement tabela = driver.findElement(By.cssSelector("table.width100:nth-child(6)"));
			
			List<WebElement> tr = tabela.findElements(By.cssSelector("tr"));
			List<WebElement> td = tabela.findElements(By.cssSelector("td"));
			
			 for (WebElement linha : td) {
				 //System.out.println(linha.getText());
				 
				if( linha.getText().equalsIgnoreCase(caso.getId())){
					 casoEncontrado = true;
					 System.out.println(linha.getText());
					 break;
				 }
				 			 
			 }
			
															
			Thread.sleep(2000);

			
			try{			
				
				assertTrue(casoEncontrado);
				loggerTestResult.testResult("Aprovado");
				
			}catch (AssertionError erroValidaMensagemConsultarCasoPorID){
    		
				loggerDebug.debug("Erro ao Executar o caso de Teste: " + erroValidaMensagemConsultarCasoPorID);
    			loggerTestResult.testResult("Reprovado");
    			
    			//Avisa a api junit sobre o erro no caso de teste
    			throw erroValidaMensagemConsultarCasoPorID;
			
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
