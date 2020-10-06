package br.com.base2.entidades;

public class Caso {
	
	private String gravidade;
	private String resumo;
	private String descricao;
	private String msgErroRelatarCasoSemResumo;
	private String Id;
	
	
	public Caso() {
		
		
		this.gravidade = "travamento";		
		this.resumo = "Bot�o Desligar n�o � exibido";
		this.descricao = "Com o sistema operacional em execu��o, ap�s selecionar a op��o Iniciar, "
				+ "o bot�o desligar n�o � exibido";
		
		this.msgErroRelatarCasoSemResumo = "Um campo necess�rio 'Resumo' estava vazio. Por favor, verifique novamente"
				+ " suas entradas.";
		
		this.Id = "0004901";
				
	}


	public String getGravidade() {
		return gravidade;
	}

	public void setGravidade(String gravidade) {
		this.gravidade = gravidade;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMsgErroRelatarCasoSemResumo() {
		return msgErroRelatarCasoSemResumo;
	}

	public void setMsgErroRelatarCasoSemResumo(String msgErroRelatarCasoSemResumo) {
		this.msgErroRelatarCasoSemResumo = msgErroRelatarCasoSemResumo;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	

}
