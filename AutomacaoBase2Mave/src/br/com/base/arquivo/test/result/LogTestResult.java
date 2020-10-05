package br.com.base.arquivo.test.result;

import org.apache.log4j.Logger;

public class LogTestResult {
	
	private Class<?> classe;
	
	public LogTestResult(Class<?> classe){
		this.classe = classe;
	}
		
	public void testResult(String mensagem){
		new ArquivoTestResult().escreveLog(this.classe, mensagem); 
	}
	
}


class ArquivoTestResult {
	protected Logger logger;
	
	public void escreveLog(Class<?> classe, String mensagem){
		logger = Logger.getLogger(ArquivoTestResult.class);
		logger.debug("[" + classe.getName() + "] - " + mensagem);
	}
}




