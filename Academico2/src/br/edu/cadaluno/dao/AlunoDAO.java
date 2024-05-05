package br.edu.cadaluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cadaluno.model.Aluno;
import br.com.cadaluno.model.NotaFalta;
import br.com.cadaluno.util.ConnectionFactory;

public class AlunoDAO {

	private Aluno aluno;
	private Connection con; // conectando com banco de dados
	private PreparedStatement ps; // permite executar querys SQL
	private ResultSet rs; // tabela

	public AlunoDAO() throws Exception {
		try {
			con = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("Erro " + e.getMessage());
		}
	}

	// salvar
	public void salvar(Aluno aluno) throws Exception {
		try {
			String sql = "INSERT INTO tbaluno (rgmAluno, nomeAluno, "
					+ "dataNascAluno, cpfAluno, emailAluno, enderecoAluno, "
					+ "municipioAluno, ufAluno, celularAluno, cursoAluno, " + "campusAluno, periodoAluno) VALUES "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setInt(1, aluno.getRgmAluno());
			ps.setString(2, aluno.getNomeAluno());
			ps.setString(3, aluno.getDataNascAluno());
			ps.setString(4, aluno.getCpfAluno());
			ps.setString(5, aluno.getEmailAluno());
			ps.setString(6, aluno.getEnderecoAluno());
			ps.setString(7, aluno.getMunicipioAluno());
			ps.setString(8, aluno.getUfAluno());
			ps.setString(9, aluno.getCelularAluno());
			ps.setString(10, aluno.getCursoAluno());
			ps.setString(11, aluno.getCampusAluno());
			ps.setString(12, aluno.getPeriodoAluno());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao salvar " + e.getMessage());
		}
	}

	// alterar
	public void alterar(Aluno aluno) throws Exception {
		try {
			String sql = "UPDATE tbaluno SET nomeAluno=?, "
					+ "dataNascAluno=?, cpfAluno=?, emailAluno=?, enderecoAluno=?, "
					+ "municipioAluno=?, ufAluno=?, celularAluno=?, cursoAluno=?, "
					+ "campusAluno=?, periodoAluno=? WHERE rgmAluno=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, aluno.getNomeAluno());
			ps.setString(2, aluno.getDataNascAluno());
			ps.setString(3, aluno.getCpfAluno());
			ps.setString(4, aluno.getEmailAluno());
			ps.setString(5, aluno.getEnderecoAluno());
			ps.setString(6, aluno.getMunicipioAluno());
			ps.setString(7, aluno.getUfAluno());
			ps.setString(8, aluno.getCelularAluno());
			ps.setString(9, aluno.getCursoAluno());
			ps.setString(10, aluno.getCampusAluno());
			ps.setString(11, aluno.getPeriodoAluno());
			ps.setInt(12, aluno.getRgmAluno());
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao alterar " + e.getMessage());
		}
	}

	// excluir
	public void excluir(int rgmAluno) throws Exception {
		try {
			String sql = "DELETE FROM tbaluno " + " WHERE rgmAluno=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, rgmAluno);
			ps.executeUpdate();

		} catch (Exception e) {
			throw new Exception("Erro ao excluir " + e.getMessage());
		}
	}

	// consultar
	public Aluno consultar(int rgmAluno) throws Exception {
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

		} catch (Exception e) {
			throw new Exception("Erro ao consultar: " + e.getMessage());
		}
	}

	// listar tabela Aluno
	public List listarAluno() throws Exception {
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			ps = con.prepareStatement("SELECT * FROM tbaluno");
			rs = ps.executeQuery();
			while (rs.next()) {
				int rgmAluno = rs.getInt("rgmAluno");
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
				lista.add(aluno);
			}
			return lista;
		} catch (Exception e5) {
			throw new Exception("Erro ao listar notas: " + e5.getMessage());
		}
	}
}
