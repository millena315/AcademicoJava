package br.com.cadaluno.model;

public class NotaFalta {

	// Variaveis

	private int id;
	private int rgmAluno;
	private String disciplina;
	private String semestre;
	private String nota;
	private String falta;

	// Construtores
	public NotaFalta() {

	}

	public NotaFalta(int id, int rgmAluno, String disciplina, String semestre, String nota, String falta) {
		super();
		this.id = id;
		this.rgmAluno = rgmAluno;
		this.disciplina = disciplina;
		this.semestre = semestre;
		this.nota = nota;
		this.falta = falta;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRgmAluno() {
		return rgmAluno;
	}

	public void setRgmAluno(int rgmAluno) {
		this.rgmAluno = rgmAluno;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getFalta() {
		return falta;
	}

	public void setFalta(String falta) {
		this.falta = falta;
	}

}
