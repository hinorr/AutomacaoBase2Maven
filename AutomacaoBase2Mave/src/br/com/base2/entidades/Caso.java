package br.com.base2.entidades;

public class Caso {
	
	private String nomeProjeto;	
	private String categoria;
	private String gravidade;
	private String perfil;
	private String resumo;
	private String descricao;
	private String msgErroRelatarCasoSemResumo;
	private String Id;
	private String marcador;
	
	public Caso() {
		
		this.nomeProjeto = "Luciano Silva's Project";
		this.categoria = "[Todos os Projetos] ZF0874XN";
		this.gravidade = "travamento";
		this.perfil = "PC Windows 8";
		this.resumo = "Botão Desligar não é exibido";
		this.descricao = "Com o sistema operacional em execução, após selecionar a opção Iniciar, "
				+ "o botão desligar não é exibido";
		
		this.msgErroRelatarCasoSemResumo = "Um campo necessário 'Resumo' estava vazio. Por favor, verifique novamente"
				+ " suas entradas.";
		
		this.Id = "0004901";
		marcador = "testeBase2";
		
		
		
	}

	public String getNomeProjeto() {
		return nomeProjeto;
	}

	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getGravidade() {
		return gravidade;
	}

	public void setGravidade(String gravidade) {
		this.gravidade = gravidade;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
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

	public String getMarcador() {
		return marcador;
	}

	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}
	
	
	
	

}
