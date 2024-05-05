package br.com.cadaluno.model;

public class Aluno {
	// Variaveis
	private int rgmAluno;
	private String nomeAluno;
	private String dataNascAluno;
	private String cpfAluno;
	private String emailAluno;
	private String enderecoAluno;
	private String municipioAluno;
	private String ufAluno;
	private String celularAluno;
	private String cursoAluno;
	private String campusAluno;
	private String periodoAluno;

	// Construtores
	public Aluno() {

	}

	public Aluno(int rgmAluno, String nomeAluno, String dataNascAluno, String cpfAluno, String emailAluno,
			String enderecoAluno, String municipioAluno, String ufAluno, String celularAluno, String cursoAluno,
			String campusAluno, String periodoAluno) {
		super();
		this.rgmAluno = rgmAluno;
		this.nomeAluno = nomeAluno;
		this.dataNascAluno = dataNascAluno;
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
		this.enderecoAluno = enderecoAluno;
		this.municipioAluno = municipioAluno;
		this.ufAluno = ufAluno;
		this.celularAluno = celularAluno;
		this.cursoAluno = cursoAluno;
		this.campusAluno = campusAluno;
		this.periodoAluno = periodoAluno;
	}

	// Getters e Setters
	public int getRgmAluno() {
		return rgmAluno;
	}

	public void setRgmAluno(int rgmAluno) {
		this.rgmAluno = rgmAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getDataNascAluno() {
		return dataNascAluno;
	}

	public void setDataNascAluno(String dataNascAluno) {
		this.dataNascAluno = dataNascAluno;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public String getEnderecoAluno() {
		return enderecoAluno;
	}

	public void setEnderecoAluno(String enderecoAluno) {
		this.enderecoAluno = enderecoAluno;
	}

	public String getMunicipioAluno() {
		return municipioAluno;
	}

	public void setMunicipioAluno(String municipioAluno) {
		this.municipioAluno = municipioAluno;
	}

	public String getUfAluno() {
		return ufAluno;
	}

	public void setUfAluno(String ufAluno) {
		this.ufAluno = ufAluno;
	}

	public String getCelularAluno() {
		return celularAluno;
	}

	public void setCelularAluno(String celularAluno) {
		this.celularAluno = celularAluno;
	}

	public String getCursoAluno() {
		return cursoAluno;
	}

	public void setCursoAluno(String cursoAluno) {
		this.cursoAluno = cursoAluno;
	}

	public String getCampusAluno() {
		return campusAluno;
	}

	public void setCampusAluno(String campusAluno) {
		this.campusAluno = campusAluno;
	}

	public String getPeriodoAluno() {
		return periodoAluno;
	}

	public void setPeriodoAluno(String periodoAluno) {
		this.periodoAluno = periodoAluno;
	}

}
