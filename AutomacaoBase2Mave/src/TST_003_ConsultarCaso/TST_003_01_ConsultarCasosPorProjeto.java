package TST_003_ConsultarCaso;


import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import br.com.base2.arquivo.debug.LogDebug;
import br.com.base2.arquivo.test.result.LogTestResult;
import br.com.base2.auxiliar.Login;
import br.com.base2.entidades.Caso;
import br.com.base2.entidades.Projeto;


public class TST_003_01_ConsultarCasosPorProjeto {
  
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private LogDebug loggerDebug;
	private LogTestResult loggerTestResult;	
	private boolean casoEncontrado;
	private Login login;
	private Caso caso;
	private Projeto projeto;
		
	
	@Before
	public void setUp() throws Exception {		
		
		this.login = new Login();
		this.loggerDebug = new LogDebug(this.getClass());
		this.loggerTestResult = new LogTestResult(this.getClass());
		this.casoEncontrado = false;
		this.caso = new Caso();
		this.projeto = new Projeto();
    
	}

	
	@Test
	public void cadastrarAvaliado() throws Exception {
		
		loggerDebug.debug("Teste Iniciado");
		    
		try{
			
			driver = login.executaLogin();
				
			
			/*
			 * Selecionar Projeto Especifico
			 * @param "Luciano Silva's Project"
			 */
			new Select(driver.findElement(By.cssSelector("select[name='project_id']"))).selectByVisibleText(projeto.getNome());
					
			//Consultar todos os Casos cadastrados para o devido Projeto		
			driver.findElement(By.cssSelector("a[href='/view_all_bug_page.php']")).click();
		
			
			/*
			 * Validar o Caso espec�fico pelo seu Resumo
			 * @param  "Bot�o Desligar n�o � exibido"
			 */
			
			WebElement tabela = driver.findElement(By.id("buglist"));				
			List<WebElement> td = tabela.findElements(By.cssSelector("td"));
			
			 for (WebElement linha : td) {
				 if( linha.getText().equalsIgnoreCase(caso.getResumo())){
					 this.casoEncontrado = true;
					 break;
				 }
			 }
			
															
			Thread.sleep(2000);

			
			try{
			
				
				assertTrue(this.casoEncontrado);
				loggerTestResult.testResult("Aprovado");
				
			}catch (AssertionError erroValidaConsultarCasoDeProjetoPorResumo){
    		
				loggerDebug.debug("Erro ao Executar o caso de Teste: " + erroValidaConsultarCasoDeProjetoPorResumo);
    			loggerTestResult.testResult("Reprovado");
    			
    			//Avisa a api junit sobre o erro no caso de teste
    			throw erroValidaConsultarCasoDeProjetoPorResumo;
			
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
