package br.edu.cadaluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cadaluno.model.Aluno;
import br.com.cadaluno.model.NotaFalta;
import br.com.cadaluno.util.ConnectionFactory;

public class BoletimDAO {
	private Aluno aluno;
	private NotaFalta notafalta;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public BoletimDAO() throws Exception {
		try {
			con = ConnectionFactory.getConnection();
		} catch (Exception e1) {
			throw new Exception("Erro " + e1.getMessage());
		}
	}

	//consultar Aluno
	public Aluno consultarAluno(int rgmAluno) throws Exception {
		try {
			ps = con.prepareStatement("SELECT * FROM tbaluno WHERE rgmAluno=?");
			ps.setInt(1, rgmAluno);
			rs = ps.executeQuery();

			if (rs.next()) {
				String nomeAluno = rs.getString("nomeAluno");
				String dataNascAluno = rs.getString("dataNascAluno");
				String cpfAluno = rs.getString("cpfAluno");
				String emailAluno = rs.getString("emailAluno");
				String enderecoAluno = rs.getString("enderecoAluno");
				String municipioAluno = rs.getString("municipioAluno");
				String ufAluno = rs.getString("ufAluno");
				String celularAluno = rs.getString("celularAluno");
				String cursoAluno = rs.getString("cursoAluno");
				String campusAluno = rs.getString("campusAluno");
				String periodoAluno = rs.getString("periodoAluno");
				aluno = new Aluno(rgmAluno, nomeAluno, dataNascAluno, cpfAluno, emailAluno, enderecoAluno,
						municipioAluno, ufAluno, celularAluno, cursoAluno, campusAluno, periodoAluno);
			}
			return aluno;

		} catch (Exception e2) {
			throw new Exception("Erro ao consultar " + e2.getMessage());
		}
	}

	// consultar NotaFalta
	public NotaFalta consultarNota(int rgmAluno) throws Exception {
		try {
			ps = con.prepareStatement("SELECT * FROM tbnotafalta WHERE rgmAluno=?");
			ps.setInt(1, rgmAluno);
			rs = ps.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String disciplina = rs.getString("disciplina");
				String semestre = rs.getString("semestre");
				String nota = rs.getString("nota");
				String falta = rs.getString("falta");
				notafalta = new NotaFalta(id, rgmAluno, disciplina, semestre, nota, falta);
			}
			return notafalta;

		} catch (Exception e3) {
			throw new Exception("Erro ao consultar " + e3.getMessage());
		}
	}

	// listar Boletim
	public List listarDados(int rgmAluno) throws Exception {
		List<NotaFalta> lista = new ArrayList<NotaFalta>();
		try {
			ps = con.prepareStatement("SELECT * FROM tbnotafalta WHERE rgmAluno=?");
			ps.setInt(1, rgmAluno);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String disciplina = rs.getString("disciplina");
				String semestre = rs.getString("semestre");
				String nota = rs.getString("nota");
				String falta = rs.getString("falta");
				notafalta = new NotaFalta(id, rgmAluno, disciplina, semestre, nota, falta);
				lista.add(notafalta);
			}
			return lista;
		} catch (Exception e4) {
			throw new Exception("Erro ao listar " + e4.getMessage());
		}
	}
}
