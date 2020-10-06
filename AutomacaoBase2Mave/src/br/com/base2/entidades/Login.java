package br.com.base2.entidades;

public class Login {
	
	private String loginValido;
	private String senhaValida;
	
	private String loginInvalido;
	private String senhaInvalida;
	
	private String msgUserInvalido;
	
	public Login(){
		
		this.loginValido = "luciano.silva";
		this.senhaValida = "132313";
		
		this.loginInvalido = "Fernando";
		this.senhaInvalida = "111111";
		
		this.msgUserInvalido = "Your account may be disabled or blocked or the username/password you entered is incorrect.";
	}

	public String getLoginValido() {
		return loginValido;
	}

	public void setLoginValido(String loginValido) {
		this.loginValido = loginValido;
	}

	public String getSenhaValida() {
		return senhaValida;
	}

	public void setSenhaValida(String senhaValida) {
		this.senhaValida = senhaValida;
	}

	public String getLoginInvalido() {
		return loginInvalido;
	}

	public void setLoginInvalido(String loginInvalido) {
		this.loginInvalido = loginInvalido;
	}

	public String getSenhaInvalida() {
		return senhaInvalida;
	}

	public void setSenhaInvalida(String senhaInvalida) {
		this.senhaInvalida = senhaInvalida;
	}

	public String getMsgUserInvalido() {
		return msgUserInvalido;
	}

	public void setMsgUserInvalido(String msgUserInvalido) {
		this.msgUserInvalido = msgUserInvalido;
	}
	
		
	
}
