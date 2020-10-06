package TST_004_AplicarMarcador;


import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import br.com.base.arquivo.test.result.LogTestResult;
import br.com.base2.arquivo.debug.LogDebug;
import br.com.base2.auxiliar.Login;
import br.com.base2.entidades.Caso;


public class TST_004_01_AplicarMarcador {
  
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private Login login;
	private LogDebug loggerDebug;
	private LogTestResult loggerTestResult;
	private Caso caso;
	private Boolean marcadorAplicado;
			
	
	@Before
	public void setUp() throws Exception {		
		
		this.login = new Login();
		this.loggerDebug = new LogDebug(this.getClass());
		this.loggerTestResult = new LogTestResult(this.getClass());
		this.caso = new Caso();
		this.marcadorAplicado = false;
		    
	}

	
	@Test
	public void cadastrarAvaliado() throws Exception {
		
		loggerDebug.debug("Teste Iniciado");
		    
		try{
			
			driver = login.executaLogin();				
			
			/*
			 * Selecionar Projeto Especifico
			 * @param Luciano Silva's Project
			 */
			new Select(driver.findElement(By.cssSelector("select[name='project_id']"))).selectByVisibleText("Luciano Silva´s Project");
		
			//Menu Ver Casos
			driver.findElement(By.cssSelector("a[href='/view_all_bug_page.php']")).click();
		
			/*
			 * Selecionar o caso especifico
			 * @param  "0004901
			 */
			WebElement tabela = driver.findElement(By.id("buglist"));				
			List<WebElement> tr = tabela.findElements(By.cssSelector("tr"));
			List<WebElement> td = tabela.findElements(By.cssSelector("td"));
			
			 for (WebElement linha : td) {
				// System.out.println(linha.getText());
				 
				 if( linha.getText().equalsIgnoreCase(caso.getId())){
					 
					 System.out.println(linha.getText());
					 linha.click();
					 break;
				 }
			 }
			
			 
			 
			 /*
			  * Aplicar marcador
			  * @param  "testeBase2"
			  */
			 new Select(driver.findElement(By.id("tag_select"))).selectByVisibleText(caso.getMarcador());
			 driver.findElement(By.cssSelector("input[value='Aplicar']")).click();
			  
			//Consultar Caso com marcador 	
			WebElement tabelaValidador = driver.findElement(By.cssSelector("table.width100:nth-child(6)"));
			
			List<WebElement> trValidador = tabelaValidador.findElements(By.cssSelector("tr"));
			List<WebElement> tdValidador = tabelaValidador.findElements(By.cssSelector("td"));
			
			 for (WebElement linha : tdValidador) {
				 //System.out.println(linha.getText());
				 
				if( linha.getText().equalsIgnoreCase(caso.getMarcador())){
					 this.marcadorAplicado = true;
					 System.out.println(linha.getText());
					 break;
				 }
				 			 
			 }
			 
			 
			 
			Thread.sleep(2000);

			
			try{
				assertTrue(marcadorAplicado);
				loggerTestResult.testResult("Aprovado");
				
			}catch (AssertionError erroValidaAplicarMarcador){
    		
				loggerDebug.debug("Erro ao Executar o caso de Teste: " + erroValidaAplicarMarcador);
    			loggerTestResult.testResult("Reprovado");
    			
    			//Avisa a api junit sobre o erro no caso de teste
    			throw erroValidaAplicarMarcador;
			
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
