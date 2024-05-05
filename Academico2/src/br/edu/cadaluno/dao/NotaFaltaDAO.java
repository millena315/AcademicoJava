package br.edu.cadaluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cadaluno.model.NotaFalta;
import br.com.cadaluno.util.ConnectionFactory;

public class NotaFaltaDAO {

	private NotaFalta notafalta;
	private Connection con; 
	private PreparedStatement ps; 
	private ResultSet rs; 

	public NotaFaltaDAO() throws Exception {
		try {
			con = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("Erro: " + e.getMessage());
		}
	}

	// salvar
	public void salvar(NotaFalta notafalta) throws Exception {
		try {
			String sql = "INSERT INTO tbnotafalta (rgmAluno, disciplina, " + "semestre, nota, falta) VALUES "
					+ "(?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setInt(1, notafalta.getRgmAluno());
			ps.setString(2, notafalta.getDisciplina());
			ps.setString(3, notafalta.getSemestre());
			ps.setString(4, notafalta.getNota());
			ps.setString(5, notafalta.getFalta());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao salvar: " + e.getMessage());
		}
	}

	// alterar
	public void alterar(NotaFalta notafalta) throws Exception {
		try {
			String sql = "UPDATE tbnotafalta SET rgmAluno=?, disciplina=?, "
					+ "semestre=?, nota=?, falta=? WHERE id=? ";

			ps = con.prepareStatement(sql);
			ps.setInt(1, notafalta.getRgmAluno());
			ps.setString(2, notafalta.getDisciplina());
			ps.setString(3, notafalta.getSemestre());
			ps.setString(4, notafalta.getNota());
			ps.setString(5, notafalta.getFalta());
			ps.setInt(6, notafalta.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao alterar: " + e.getMessage());
		}
	}

	// excluir
	public void excluir(int id) throws Exception {
		try {
			String sql = "DELETE FROM tbnotafalta " + " WHERE id=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao excluir: " + e.getMessage());
		}
	}

	// excluirTudo
	public void excluirTudo(int rgmAluno) throws Exception {
		try {
			String sql = "DELETE FROM tbnotafalta " + " WHERE rgmAluno=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, rgmAluno);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao excluir: " + e.getMessage());
		}
	}

	// consultar
	public NotaFalta consultar(int id) throws Exception {
		try {
			ps = con.prepareStatement("SELECT * FROM tbnotafalta WHERE id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				int rgmAluno = rs.getInt("rgmAluno");
				String disciplina = rs.getString("disciplina");
				String semestre = rs.getString("semestre");
				String nota = rs.getString("nota");
				String falta = rs.getString("falta");
				notafalta = new NotaFalta(id, rgmAluno, disciplina, semestre, nota, falta);
			}
			return notafalta;

		} catch (Exception e) {
			throw new Exception("Erro ao consultar: " + e.getMessage());
		}
	}

	// listar tabela NotaFalta
	public List listarNota() throws Exception {
		List<NotaFalta> lista = new ArrayList<NotaFalta>();
		try {
			ps = con.prepareStatement("SELECT * FROM tbnotafalta");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int rgmAluno = rs.getInt("rgmAluno");
				String disciplina = rs.getString("disciplina");
				String semestre = rs.getString("semestre");
				String nota = rs.getString("nota");
				String falta = rs.getString("falta");
				notafalta = new NotaFalta(id, rgmAluno, disciplina, semestre, nota, falta);
				lista.add(notafalta);
			}
			return lista;
		} catch (Exception e5) {
			throw new Exception("Erro ao listar notas: " + e5.getMessage());
		}
	}

}
