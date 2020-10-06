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
import br.com.base2.entidades.Categoria;
import br.com.base2.entidades.Perfil;
import br.com.base2.entidades.Projeto;


public class TST_002_01_RelatarCasoCamposObgPreenchidos {
  
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private LogDebug loggerDebug;
	private LogTestResult loggerTestResult;	
	private Boolean casoEncontrado;
	private Login login;
	private Caso caso;
	private Projeto projeto;
	private Perfil perfil;
	private Categoria categoria;	 
		
	
	@Before
	public void setUp() throws Exception {		
		
		this.login = new Login();
		this.loggerDebug = new LogDebug(this.getClass());
		this.loggerTestResult = new LogTestResult(this.getClass());
		this.casoEncontrado = false;
		this.caso = new Caso();
		this.projeto = new Projeto();
		this.perfil = new Perfil();
		this.categoria = new Categoria();		
    
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
			new Select(driver.findElement(By.cssSelector("select[name='project_id']:not([class='small']"))).selectByVisibleText(projeto.getNome());
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
			
			new Select(driver.findElement(By.name("category_id"))). selectByVisibleText(categoria.getTipo());
			new Select(driver.findElement(By.name ("severity"))).selectByVisibleText(caso.getGravidade());
			new Select(driver.findElement(By.name("profile_id"))).selectByVisibleText(perfil.getTipo());
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
				 
				 if( linha.getText().equalsIgnoreCase(caso.getResumo())){
					 this.casoEncontrado = true;
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
