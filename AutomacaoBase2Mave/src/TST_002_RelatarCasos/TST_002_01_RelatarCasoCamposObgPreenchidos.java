package TST_002_RelatarCasos;


import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import br.com.base2.arquivo.debug.LogDebug;
import br.com.base2.arquivo.test.result.LogTestResult;
import br.com.base2.auxiliar.Login;
import br.com.base2.entidades.Caso;


public class TST_002_01_RelatarCasoCamposObgPreenchidos {
  
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private Login login;
	private LogDebug loggerDebug;
	private LogTestResult loggerTestResult;	
	private Caso caso;
	private Boolean casoEncontrado;
		
	
	@Before
	public void setUp() throws Exception {		
		
		this.login = new Login();
		this.loggerDebug = new LogDebug(this.getClass());
		this.loggerTestResult = new LogTestResult(this.getClass());
		this.caso = new Caso();
		this.casoEncontrado = false;
    
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
			new Select(driver.findElement(By.cssSelector("select[name='project_id']:not([class='small']"))).selectByVisibleText("Luciano Silva´s Project");
			driver.findElement(By.cssSelector("input[value='Selecionar Projeto']")).click();
			
			Thread.sleep(2000);
			
			/*
			 * Relatar Caso
			 * 	@param categoria;
			 *	@param gravidade;
			 *	@param perfil;
			 *	@param resumo;
			 *	@param descricao;
			 *	
			 */
			
			new Select(driver.findElement(By.name("category_id"))). selectByVisibleText(caso.getCategoria());
			new Select(driver.findElement(By.name ("severity"))).selectByVisibleText(caso.getGravidade());
			new Select(driver.findElement(By.name("profile_id"))).selectByVisibleText(caso.getPerfil());
			driver.findElement(By.name("summary")).sendKeys(caso.getResumo());
			driver.findElement(By.name("description")).sendKeys(caso.getDescricao());
			
			
			//Botao Enviar Relatorio
			driver.findElement(By.cssSelector("input[value='Enviar Relatório']")).click();
			Thread.sleep(4000);
			
			
			/*
			 * Fazendo a validação do cadastro
			 * O correto seria com a validação da mensagem, porem o time é bem rapido, refatorar
			 */
			
			WebElement tabela = driver.findElement(By.id("buglist"));				
			//List<WebElement> tr = tabela.findElements(By.cssSelector("tr"));
			List<WebElement> td = tabela.findElements(By.cssSelector("td"));
			
			 for (WebElement linha : td) {
				// System.out.println(linha.getText());
				 
				 if( linha.getText().equalsIgnoreCase(caso.getResumo())){
					 casoEncontrado = true;
					 System.out.println(linha.getText());
					 break;
				 }
			 }

			 	
					
			
			try{
				
				//Validação da mensagem
				assertTrue(casoEncontrado);    
				loggerTestResult.testResult("Aprovado");
				
			}catch (AssertionError erroValidaRelatarCasoCamposObgPreenchidos){
    		
				loggerDebug.debug("Erro ao Executar o caso de Teste: " + erroValidaRelatarCasoCamposObgPreenchidos);
    			loggerTestResult.testResult("Reprovado");
    			
    			//Avisa a api junit sobre o erro no caso de teste
    			throw erroValidaRelatarCasoCamposObgPreenchidos;
			
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
