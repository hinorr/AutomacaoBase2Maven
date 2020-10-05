package br.com.base2.arquivo.debug;

import org.apache.log4j.Logger;

public class LogDebug {
	
	private Class<?> classe;
	
	public LogDebug(Class<?> classe){
		this.classe = classe;
	}
	
	public void debug(String mensagem){
		new ArquivoDebug().escreveLog(this.classe, mensagem);
	}
	
}


class ArquivoDebug {
	protected Logger logger;
	
	public void escreveLog(Class<?> classe, String mensagem){
		logger = Logger.getLogger(ArquivoDebug.class);
		logger.debug("[" + classe.getName() + "] - " + mensagem);
	}
}


