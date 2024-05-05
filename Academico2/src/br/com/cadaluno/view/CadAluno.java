package br.com.cadaluno.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.cadaluno.model.Aluno;
import br.com.cadaluno.model.CaretPosition;
import br.com.cadaluno.model.LimiteJTextField;
import br.com.cadaluno.model.NotaFalta;
import br.com.cadaluno.model.RenderizaJTable;
import br.com.cadaluno.model.SoLetrasJTextField;
import br.com.cadaluno.model.SoNumerosJTextField;
import br.edu.cadaluno.dao.AlunoDAO;
import br.edu.cadaluno.dao.BoletimDAO;
import br.edu.cadaluno.dao.NotaFaltaDAO;

import java.awt.SystemColor;

public class CadAluno extends JFrame {

	//Variaveis
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAluno;
	private JMenu mnNotas;
	private JMenu mnAjuda;
	private JMenuItem mntSalvarAluno;
	private JMenuItem mntAlterarAluno;
	private JMenuItem mntConsultarAluno;
	private JMenuItem mntExcluirAluno;
	private JMenuItem mntSair;
	private JSeparator separator;
	private JMenuItem mntSalvarNota;
	private JMenuItem mntAlterarNota;
	private JMenuItem mntExcluirNota;
	private JMenuItem mntConsultarNota;
	private JMenuItem mntmSobre;
	private JTabbedPane tabbedPane;
	private JPanel pnlDados;
	private JPanel pnlCurso;
	private JPanel pnlNotas;
	private JPanel pnlBoletim;
	private JLabel lblRgmDados;
	private JLabel lblDataDeNascimento;
	private JLabel lblEmail;
	private JLabel lblEnd;
	private JLabel lblMunicpio;
	private JLabel lblNomeDados;
	private JLabel lblCpf;
	private JLabel lblUf;
	private JLabel lblCelular;
	private JFormattedTextField ftfCpf;
	private JFormattedTextField ftfCelular;
	private JFormattedTextField ftfDataNasc;
	private JTextField txtRgm;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEnd;
	private JTextField txtMunicipio;
	private JComboBox cbUf;
	private JLabel lblCurso;
	private JLabel lblCampus;
	private JLabel lblPeriodo;
	private JComboBox cbCurso;
	private JComboBox cbCampus;
	private JRadioButton rdbMatutino;
	private JRadioButton rdbVespertino;
	private JRadioButton rdbNortuno;
	private final ButtonGroup btgPeriodo = new ButtonGroup();
	private JLabel lblRgmNotas;
	private JLabel lblDisciplina;
	private JLabel lblSemestre;
	private JLabel lblNota;
	private JLabel lblFaltas;
	private JTextField txtRgmNotas;
	private JTextField txtNomeNotas;
	private JComboBox cbDisciplina;
	private JComboBox cbSemestre;
	private JComboBox cbNota;
	private JTextField txtFalta;
	private JLabel lblRgmBoletim;
	private JLabel lblNomeBoletim;
	private JLabel lblCursoBoletim;
	private JTextField txtRgmBoletim;
	private JTextField txtNomeBoletim;
	private JTextField txtCursoBoletim;
	private Aluno aluno;
	private AlunoDAO dao;
	private NotaFalta notafalta;
	private NotaFaltaDAO daoNota;
	private BoletimDAO daoBoletim;
	private JButton btnLimpar;
	private JLabel lblNomeNota;
	private JLabel lblRegistro;
	private JTextField txtId;
	private JButton btnLimparNotaFalta;
	private JButton btnConsultarBoletim;
	private JButton btnLimparBoletim;
	private JLabel lblCampusBoletim;
	private JTextField txtCampusBoletim;
	private JLabel lblCursoNota;
	private JTextField txtCursoNotas;
	private JScrollPane scrollPane;
	private JTable tbBoletim;
	private JButton btnConsultaRapida;
	private JScrollPane scrollPane_1;
	private JTable tbConsultaRapida;
	private JPanel pnlListagem;
	private JScrollPane scrollPane_2;
	private JTable tbListagem;
	private JButton btnListarAlunos;
	private JLabel lblListagemDeAlunos;
	private JButton btnLimparListagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadAluno frame = new CadAluno();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public CadAluno() throws ParseException {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadAluno.class.getResource("/img/estudante.png")));
		setTitle("Sistema Acadêmico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 379);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(240, 240, 240));
		menuBar.setBounds(0, 0, 552, 21);
		contentPane.add(menuBar);

		mnAluno = new JMenu("Aluno");
		mnAluno.setIcon(new ImageIcon(CadAluno.class.getResource("/img/student.png")));
		menuBar.add(mnAluno);

		mntSalvarAluno = new JMenuItem("Salvar");
		mntSalvarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Validando campos para salvar

				// RGM
				if (txtRgm.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o RGM do aluno");
					txtRgm.requestFocus();
				} else

				// NOME
				if (txtNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o NOME do aluno");
					txtNome.requestFocus();
				} else if (txtNome.getText().length() < 3) {
					JOptionPane.showMessageDialog(null, "Insira no m�nimo 3 letras para formar um nome");
					txtNome.requestFocus();
				} else

				// DATA NASCIMENTO
				if (ftfDataNasc.getText().trim().length() != 10) {
					JOptionPane.showMessageDialog(null, "Data de Nascimento inv�lida");
					ftfDataNasc.requestFocus();
				} else

				// CPF
				if (ftfCpf.getText().trim().length() < 14) {
					JOptionPane.showMessageDialog(null, "CPF Incompleto ou Vazio");
					ftfCpf.requestFocus();
				} else

				// EMAIL
				if (txtEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe um EMAIL");
					txtEmail.requestFocus();
				} else

				// ENDERECO
				if (txtEnd.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe um endereço");
					txtEnd.requestFocus();
				} else

				// MUNICIPIO
				if (txtMunicipio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o MUNIC�PIO");
					txtMunicipio.requestFocus();
				} else {
					// CELULAR
					if (ftfCelular.getText().trim().length() < 14) {
						JOptionPane.showMessageDialog(null, "CELULAR invalido");
						ftfCelular.requestFocus();
					}
					// Salvando pós validação
					else {
						try {
							aluno = new Aluno();
							aluno.setRgmAluno(Integer.parseInt(txtRgm.getText()));
							aluno.setNomeAluno(txtNome.getText());
							aluno.setDataNascAluno(ftfDataNasc.getText());
							aluno.setCpfAluno(ftfCpf.getText());
							aluno.setEmailAluno(txtEmail.getText());
							aluno.setEnderecoAluno(txtEnd.getText());
							aluno.setMunicipioAluno(txtMunicipio.getText());
							aluno.setUfAluno((String) cbUf.getSelectedItem());
							aluno.setCelularAluno(ftfCelular.getText());
							aluno.setCursoAluno((String) cbCurso.getSelectedItem());
							aluno.setCampusAluno((String) cbCampus.getSelectedItem());
							if (rdbMatutino.isSelected()) {
								aluno.setPeriodoAluno("Matutino");
							} else if (rdbVespertino.isSelected()) {
								aluno.setPeriodoAluno("Vespertino");
							} else if (rdbNortuno.isSelected()) {
								aluno.setPeriodoAluno("Noturno");
							}
							// abrindo conexao
							dao = new AlunoDAO();
							// salvando
							dao.salvar(aluno);
							JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
							// Limpando campos
							txtRgm.setText(null);
							txtNome.setText(null);
							ftfDataNasc.setText(null);
							ftfCpf.setText(null);
							txtEmail.setText(null);
							txtEnd.setText(null);
							txtMunicipio.setText(null);
							cbUf.setSelectedIndex(0);
							ftfCelular.setText(null);
							cbCurso.setSelectedIndex(0);
							cbCampus.setSelectedIndex(0);
							if (rdbMatutino.isSelected()) {
								rdbMatutino.setSelected(true);
							} else if (rdbVespertino.isSelected()) {
								rdbMatutino.setSelected(true);
							} else if (rdbNortuno.isSelected()) {
								rdbMatutino.setSelected(true);
							}

						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
						}
					}
				}
			}
		});
		mntSalvarAluno.setIcon(new ImageIcon(CadAluno.class.getResource("/img/saveSettings.png")));
		//mntSalvarAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,));
		mnAluno.add(mntSalvarAluno);

		mntAlterarAluno = new JMenuItem("Alterar");
		mntAlterarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				if (txtRgm.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo RGM est� vazio!");
					txtRgm.requestFocus();
				} else

				// NOME
				if (txtNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o NOME do aluno!");
					txtNome.requestFocus();
				} else if (txtNome.getText().length() < 3) {
					JOptionPane.showMessageDialog(null, "Insira no m�nimo 3 letras para formar um NOME!");
					txtNome.requestFocus();
				} else

				// DATA NASCIMENTO
				if (ftfDataNasc.getText().trim().length() != 10) {
					JOptionPane.showMessageDialog(null, "Data de Nascimento inv�lida!");
					ftfDataNasc.requestFocus();
				} else

				// CPF
				if (ftfCpf.getText().trim().length() < 14) {
					JOptionPane.showMessageDialog(null, "CPF Incompleto ou Vazio!");
					ftfCpf.requestFocus();
				} else

				// EMAIL
				if (txtEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe um EMAIL!");
					txtEmail.requestFocus();
				} else

				// ENDERE�O
				if (txtEnd.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "� preciso informar um ENDERE�O!");
					txtEnd.requestFocus();
				} else

				// MUNIC�PIO
				if (txtMunicipio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o MUNIC�PIO!");
					txtMunicipio.requestFocus();
				} else {
					// CELULAR
					if (ftfCelular.getText().trim().length() < 14) {
						JOptionPane.showMessageDialog(null, "CELULAR Vazio ou Incompleto!");
						ftfCelular.requestFocus();
					}
					else {
						try {
							aluno = new Aluno();
							aluno.setRgmAluno(Integer.parseInt(txtRgm.getText()));
							aluno.setNomeAluno(txtNome.getText());
							aluno.setDataNascAluno(ftfDataNasc.getText());
							aluno.setCpfAluno(ftfCpf.getText());
							aluno.setEmailAluno(txtEmail.getText());
							aluno.setEnderecoAluno(txtEnd.getText());
							aluno.setMunicipioAluno(txtMunicipio.getText());
							aluno.setUfAluno((String) cbUf.getSelectedItem());
							aluno.setCelularAluno(ftfCelular.getText());
							aluno.setCursoAluno((String) cbCurso.getSelectedItem());
							aluno.setCampusAluno((String) cbCampus.getSelectedItem());
							if (rdbMatutino.isSelected()) {
								aluno.setPeriodoAluno("Matutino");
							} else if (rdbVespertino.isSelected()) {
								aluno.setPeriodoAluno("Vespertino");
							} else if (rdbNortuno.isSelected()) {
								aluno.setPeriodoAluno("Noturno");
							}
							
							dao = new AlunoDAO();

							dao.alterar(aluno);
							JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

							txtRgm.setText(null);
							txtNome.setText(null);
							ftfDataNasc.setText(null);
							ftfCpf.setText(null);
							txtEmail.setText(null);
							txtEnd.setText(null);
							txtMunicipio.setText(null);
							cbUf.setSelectedIndex(0);
							ftfCelular.setText(null);
							cbCurso.setSelectedIndex(0);
							cbCampus.setSelectedIndex(0);
							if (rdbMatutino.isSelected()) {
								rdbMatutino.setSelected(true);
							} else if (rdbVespertino.isSelected()) {
								rdbMatutino.setSelected(true);
							} else if (rdbNortuno.isSelected()) {
								rdbMatutino.setSelected(true);
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e1.getMessage());
						}
					}
				}
			}
		});
		mntAlterarAluno.setIcon(new ImageIcon(CadAluno.class.getResource("/img/alertCaution.png")));
		mnAluno.add(mntAlterarAluno);

		mntConsultarAluno = new JMenuItem("Consultar");
		mntConsultarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtRgm.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe um RGM para consulta!");
					txtRgm.requestFocus();
				} else {
					try {
						dao = new AlunoDAO();
						int codigo = Integer.parseInt(txtRgm.getText());
						aluno = dao.consultar(codigo);
						txtNome.setText(aluno.getNomeAluno());
						ftfDataNasc.setText(aluno.getDataNascAluno());
						ftfCpf.setText(aluno.getCpfAluno());
						txtEmail.setText(aluno.getEmailAluno());
						txtEnd.setText(aluno.getEnderecoAluno());
						txtMunicipio.setText(aluno.getMunicipioAluno());
						String uf = aluno.getUfAluno();
						if (uf.equals("ES")) {
							cbUf.setSelectedIndex(0);
						} else if (uf.equals("MG")) {
							cbUf.setSelectedIndex(1);
						} else if (uf.equals("RJ")) {
							cbUf.setSelectedIndex(2);
						} else {
							cbUf.setSelectedIndex(3);
						}

						ftfCelular.setText(aluno.getCelularAluno());
						String curso = aluno.getCursoAluno();
						if (curso.equals("An�lise e Desenvolvimento de Sistemas")) {
							cbCurso.setSelectedIndex(0);
						} else if (curso.equals("Psicologia")) {
							cbCurso.setSelectedIndex(1);
						} else {
							cbCurso.setSelectedIndex(2);
						}
						// JComboBox Aluno
						String campus = aluno.getCampusAluno();
						if (campus.equals("Bela Vista - ES")) {
							cbCampus.setSelectedIndex(0);
						} else if (campus.equals("São Bernardo do Campo")) {
							cbCampus.setSelectedIndex(1);
						} else if (campus.equals("Guarulhos")) {
							cbCampus.setSelectedIndex(2);
						} else if (campus.equals("Guarujá")) {
							cbCampus.setSelectedIndex(3);
						} else if (campus.equals("São Carlos")) {
							cbCampus.setSelectedIndex(4);
						} else if (campus.equals("Campinas")) {
							cbCampus.setSelectedIndex(5);
						} else if (campus.equals("Tatuape - SP")) {
							cbCampus.setSelectedIndex(6);
						} else if (campus.equals("Pinheiros - SP")) {
							cbCampus.setSelectedIndex(7);
						}
						String periodo = aluno.getPeriodoAluno();
						if (periodo.equals("Matutino")) {
							rdbMatutino.setSelected(true);
						} else if (periodo.equals("Vespertino")) {
							rdbVespertino.setSelected(true);
						} else if (periodo.equals("Noturno")) {
							rdbNortuno.setSelected(true);
						}

					} catch (Exception e4) {
						JOptionPane.showMessageDialog(null, "RGM digitado n�o existe!");
					}
				}
			}
		});
		mntConsultarAluno.setIcon(new ImageIcon(CadAluno.class.getResource("/img/search2.png")));
		mnAluno.add(mntConsultarAluno);

		mntExcluirAluno = new JMenuItem("Excluir");
		mntExcluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtRgm.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira RGM para excluir!");
					txtRgm.requestFocus();
				} else {

					try {
						dao = new AlunoDAO();
						
						int codigo = Integer.parseInt(txtRgm.getText());
						dao.excluir(codigo);
						JOptionPane.showMessageDialog(null, "Exclu�do com sucesso!");
						txtRgm.setText(null);
						txtNome.setText(null);
						ftfDataNasc.setText(null);
						ftfCpf.setText(null);
						txtEmail.setText(null);
						txtEnd.setText(null);
						txtMunicipio.setText(null);
						cbUf.setSelectedIndex(0);
						ftfCelular.setText(null);
						cbCurso.setSelectedIndex(0);
						cbCampus.setSelectedIndex(0);
						if (rdbMatutino.isSelected()) {
							rdbMatutino.setSelected(true);
						} else if (rdbVespertino.isSelected()) {
							rdbMatutino.setSelected(true);
						} else if (rdbNortuno.isSelected()) {
							rdbMatutino.setSelected(true);
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Erro ao Excluir" + e2.getMessage());
					}
					try {
						daoNota = new NotaFaltaDAO();
						int codigoNota = Integer.parseInt(txtRgm.getText());
						daoNota.excluirTudo(codigoNota);
					} catch (Exception e2) {

					}
				}
			}
		});
		mntExcluirAluno.setIcon(new ImageIcon(CadAluno.class.getResource("/img/trash.png")));
		mnAluno.add(mntExcluirAluno);

		separator = new JSeparator();
		mnAluno.add(separator);

		mntSair = new JMenuItem("Sair");
		mntSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Saindo do sistema
				Object[] opcoes = { "Sim", "N�o" };
				Icon figura = new ImageIcon(
						getToolkit().createImage(getClass().getResource("/img/errorNormal.png")));
				int escolha = JOptionPane.showOptionDialog(null, "Deseja sair do sistema?", "Sair",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, figura, opcoes, opcoes[1]);
				if (escolha == 0)
					System.exit(0);

			}
		});
		mntSair.setIcon(new ImageIcon(CadAluno.class.getResource("/img/error.png")));
		//mntSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mnAluno.add(mntSair);

		mnNotas = new JMenu("Notas e Faltas");
		mnNotas.setIcon(new ImageIcon(CadAluno.class.getResource("/img/notes.png")));
		menuBar.add(mnNotas);

		mntSalvarNota = new JMenuItem("Salvar");
		mntSalvarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if (txtRgmNotas.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o RGM do aluno!");
					txtRgmNotas.requestFocus();
				}

				else if (txtFalta.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha as FALTAS do aluno!");
					txtFalta.requestFocus();
				}

			
				else {
					try {
						notafalta = new NotaFalta();
						// notafalta.setId(Integer.parseInt(txtId.getText()));
						notafalta.setRgmAluno(Integer.parseInt(txtRgmNotas.getText()));
						notafalta.setDisciplina((String) cbDisciplina.getSelectedItem());
						notafalta.setSemestre((String) cbSemestre.getSelectedItem());
						notafalta.setNota((String) cbNota.getSelectedItem());
						notafalta.setFalta(txtFalta.getText());
						
						daoNota = new NotaFaltaDAO();
						
						daoNota.salvar(notafalta);
						JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
						
						DefaultTableModel modelLimpar = (DefaultTableModel) tbConsultaRapida.getModel();
						modelLimpar.setRowCount(0);
						txtId.setText(null);
						txtRgmNotas.setText(null);
						txtNomeNotas.setText(null);
						txtCursoNotas.setText(null);
						cbDisciplina.setSelectedIndex(0);
						cbSemestre.setSelectedIndex(0);
						cbNota.setSelectedIndex(0);
						txtFalta.setText(null);
						
					} catch (Exception e) {

					}
				}
				
			}
		});
		mntSalvarNota.setIcon(new ImageIcon(CadAluno.class.getResource("/img/saveSettings.png")));
		mnNotas.add(mntSalvarNota);

		mntAlterarNota = new JMenuItem("Alterar");
		mntAlterarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (txtId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira ID para Alterar!");
					txtId.requestFocus();
				} else
				
				if (txtRgmNotas.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo RGM est� vazio!");
					txtRgmNotas.requestFocus();
				} else
				
				if (txtFalta.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha as FALTAS do aluno!");
					txtFalta.requestFocus();
				}
				
				else {
					try {
						notafalta = new NotaFalta();
						notafalta.setId(Integer.parseInt(txtId.getText()));
						notafalta.setRgmAluno(Integer.parseInt(txtRgmNotas.getText()));
						notafalta.setDisciplina((String) cbDisciplina.getSelectedItem());
						notafalta.setSemestre((String) cbSemestre.getSelectedItem());
						notafalta.setNota((String) cbNota.getSelectedItem());
						notafalta.setFalta(txtFalta.getText());

						daoNota = new NotaFaltaDAO();
						
						daoNota.alterar(notafalta);
						JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
						
						DefaultTableModel modelLimpar = (DefaultTableModel) tbConsultaRapida.getModel();
						modelLimpar.setRowCount(0);
						txtId.setText(null);
						txtRgmNotas.setText(null);
						txtNomeNotas.setText(null);
						txtCursoNotas.setText(null);
						cbDisciplina.setSelectedIndex(0);
						cbSemestre.setSelectedIndex(0);
						cbNota.setSelectedIndex(0);
						txtFalta.setText(null);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e1.getMessage());
					}
				}
				
			}
		});
		mntAlterarNota.setIcon(new ImageIcon(CadAluno.class.getResource("/img/alertCaution.png")));
		//mntAlterarNota.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNotas.add(mntAlterarNota);

		mntExcluirNota = new JMenuItem("Excluir");
		mntExcluirNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (txtId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira ID para Excluir!");
					txtId.requestFocus();
				} else {
					try {
						
						daoNota = new NotaFaltaDAO();
						
						int codigo = Integer.parseInt(txtId.getText());
						daoNota.excluir(codigo);
						JOptionPane.showMessageDialog(null, "Exclu�do com sucesso!");
						
						DefaultTableModel modelLimpar = (DefaultTableModel) tbConsultaRapida.getModel();
						modelLimpar.setRowCount(0);
						txtId.setText(null);
						txtRgmNotas.setText(null);
						txtNomeNotas.setText(null);
						txtCursoNotas.setText(null);
						cbDisciplina.setSelectedIndex(0);
						cbSemestre.setSelectedIndex(0);
						cbNota.setSelectedIndex(0);
						txtFalta.setText(null);
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Erro ao Excluir" + e2.getMessage());
					}
				}
				
			}
		});
		mntExcluirNota.setIcon(new ImageIcon(CadAluno.class.getResource("/img/trash.png")));
		mnNotas.add(mntExcluirNota);

		mntConsultarNota = new JMenuItem("Consultar");
		mntConsultarNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (txtId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira ID e RGM para Consultar!");
					txtId.requestFocus();
				} else
				
				if (txtRgmNotas.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira ID e RGM para Consultar!");
					txtRgmNotas.requestFocus();
				} else {

					try {
						
						daoNota = new NotaFaltaDAO();
						int codigo = Integer.parseInt(txtId.getText());
						notafalta = daoNota.consultar(codigo);

						
						dao = new AlunoDAO();
						int codNome = Integer.parseInt(txtRgmNotas.getText());
						aluno = dao.consultar(codNome);
						txtNomeNotas.setText(aluno.getNomeAluno());
						txtCursoNotas.setText(aluno.getCursoAluno());

						String disc = notafalta.getDisciplina();
						if (disc.equals("Algoritmos")) {
							cbDisciplina.setSelectedIndex(0);
						} else if (disc.equals("POO")) {
							cbDisciplina.setSelectedIndex(1);
						} else if (disc.equals("Engenharia de Software I")) {
							cbDisciplina.setSelectedIndex(2);
						} else if (disc.equals("Redes")) {
							cbDisciplina.setSelectedIndex(3);
						} else if (disc.equals("Cálculo I")) {
							cbDisciplina.setSelectedIndex(4);
						} else if (disc.equals("Matemática Discreta")) {
							cbDisciplina.setSelectedIndex(5);
						} else if (disc.equals("Sistemas Operacionais")) {
							cbDisciplina.setSelectedIndex(6);
						} else if (disc.equals("Segurança da informação")) {
							cbDisciplina.setSelectedIndex(7);
						} else if (disc.equals("")) {
							cbDisciplina.setSelectedIndex(8);
						}
						
						String sem = notafalta.getSemestre();
						if (sem.equals("1")) {
							cbSemestre.setSelectedIndex(0);
						} else if (sem.equals("2")) {
							cbSemestre.setSelectedIndex(1);
						} else if (sem.equals("3")) {
							cbSemestre.setSelectedIndex(2);
						} else if (sem.equals("4")) {
							cbSemestre.setSelectedIndex(3);
						} else if (sem.equals("5")) {
							cbSemestre.setSelectedIndex(4);
						} else if (sem.equals("6")) {
							cbSemestre.setSelectedIndex(5);
						} else if (sem.equals("7")) {
							cbSemestre.setSelectedIndex(6);
						} else if (sem.equals("8")) {
							cbSemestre.setSelectedIndex(7);
						} else if (sem.equals("9")) {
							cbSemestre.setSelectedIndex(8);
						} else if (sem.equals("10")) {
							cbSemestre.setSelectedIndex(9);
						} else if (sem.equals("11")) {
							cbSemestre.setSelectedIndex(10);
						} else if (sem.equals("12")) {
							cbSemestre.setSelectedIndex(11);
						}
						
						String nota = notafalta.getNota();
						if (nota.equals("1.0")) {
							cbSemestre.setSelectedIndex(0);
						} else if (nota.equals("2.0")) {
							cbNota.setSelectedIndex(1);
						} else if (nota.equals("3.0")) {
							cbNota.setSelectedIndex(2);
						} else if (nota.equals("4.0")) {
							cbNota.setSelectedIndex(3);
						} else if (nota.equals("5.0")) {
							cbNota.setSelectedIndex(4);
						} else if (nota.equals("6.0")) {
							cbNota.setSelectedIndex(5);
						} else if (nota.equals("7.0")) {
							cbNota.setSelectedIndex(6);
						} else if (nota.equals("8.0")) {
							cbNota.setSelectedIndex(7);
						} else if (nota.equals("9.0")) {
							cbNota.setSelectedIndex(8);
						} else if (nota.equals("10.0")) {
							cbNota.setSelectedIndex(9);
						}
						txtFalta.setText(notafalta.getFalta());
					} catch (Exception e4) {
						JOptionPane.showMessageDialog(null, "Registro para CONSULTA n�o encontrado!");
					}
				}
			}
		});
		mntConsultarNota.setIcon(new ImageIcon(CadAluno.class.getResource("/img/search2.png")));
		mnNotas.add(mntConsultarNota);

		mnAjuda = new JMenu("Ajuda");
		mnAjuda.setIcon(new ImageIcon(CadAluno.class.getResource("/img/help.png")));
		menuBar.add(mnAjuda);

		mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				TelaSobre frame = new TelaSobre();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				*/
			}
		});
		mntmSobre.setIcon(new ImageIcon(CadAluno.class.getResource("/img/informa.png")));
		mnAjuda.add(mntmSobre);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		tabbedPane.setFocusable(false);
	
		tabbedPane.setBounds(10, 42, 522, 289);
		contentPane.add(tabbedPane);

		pnlDados = new JPanel();
		pnlDados.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Dados Pessoais", null, pnlDados, null);
		//tabbedPane.setBackgroundAt(0, new Color(245, 245, 220));
		pnlDados.setLayout(null);

		lblRgmDados = new JLabel("RGM");
		lblRgmDados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRgmDados.setBounds(27, 33, 33, 20);
		pnlDados.add(lblRgmDados);

		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDeNascimento.setBounds(27, 67, 141, 20);
		pnlDados.add(lblDataDeNascimento);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(27, 103, 39, 20);
		pnlDados.add(lblEmail);

		lblEnd = new JLabel("End.");
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnd.setBounds(27, 141, 32, 20);
		pnlDados.add(lblEnd);

		lblMunicpio = new JLabel("Munic.");
		lblMunicpio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMunicpio.setBounds(27, 178, 67, 20);
		pnlDados.add(lblMunicpio);

		lblNomeDados = new JLabel("Nome");
		lblNomeDados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeDados.setBounds(195, 33, 42, 20);
		pnlDados.add(lblNomeDados);

		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpf.setBounds(302, 67, 27, 20);
		pnlDados.add(lblCpf);

		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUf.setBounds(230, 178, 19, 20);
		pnlDados.add(lblUf);

		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCelular.setBounds(320, 178, 49, 20);
		pnlDados.add(lblCelular);

		ftfCpf = new JFormattedTextField();
		
		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		maskCpf.install(ftfCpf);
		
		ftfCpf.addFocusListener(new CaretPosition());
		
		ftfCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ftfCpf.setBounds(339, 67, 152, 20);
		pnlDados.add(ftfCpf);

		ftfCelular = new JFormattedTextField();
		
		MaskFormatter maskCelular = new MaskFormatter("(##) #####-####");
		maskCelular.install(ftfCelular);
		
		ftfCelular.addFocusListener(new CaretPosition());
		
		ftfCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ftfCelular.setBounds(372, 178, 119, 20);
		pnlDados.add(ftfCelular);

		ftfDataNasc = new JFormattedTextField();
		
		MaskFormatter maskDataNasc = new MaskFormatter("##/##/####");
		maskDataNasc.install(ftfDataNasc);
		
		ftfDataNasc.addFocusListener(new CaretPosition());
		
		ftfDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ftfDataNasc.setBounds(180, 67, 102, 20);
		pnlDados.add(ftfDataNasc);

		txtRgm = new JTextField();
		
		txtRgm.setDocument(new SoNumerosJTextField(11));
		
		txtRgm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRgm.setBounds(75, 33, 109, 20);
		pnlDados.add(txtRgm);
		txtRgm.setColumns(10);

		txtNome = new JTextField();
		
		txtNome.setDocument(new SoLetrasJTextField(50));
		
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNome.setColumns(10);
		txtNome.setBounds(247, 33, 244, 20);
		pnlDados.add(txtNome);

		txtEmail = new JTextField();
		
		txtEmail.setDocument(new LimiteJTextField(50));
		
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(75, 103, 415, 20);
		pnlDados.add(txtEmail);

		txtEnd = new JTextField();
		
		txtEnd.setDocument(new LimiteJTextField(50));
		
		txtEnd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEnd.setColumns(10);
		txtEnd.setBounds(75, 141, 416, 20);
		pnlDados.add(txtEnd);

		txtMunicipio = new JTextField();
		
		txtMunicipio.setDocument(new SoLetrasJTextField(30));
		
		txtMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(75, 178, 145, 20);
		pnlDados.add(txtMunicipio);

		cbUf = new JComboBox();
		cbUf.setModel(new DefaultComboBoxModel(new String[] { "ES", "MG", "RJ", "SP" }));
		cbUf.setBounds(259, 178, 51, 20);
		pnlDados.add(cbUf);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setFocusable(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtRgm.setText(null);
				txtNome.setText(null);
				ftfDataNasc.setText(null);
				ftfCpf.setText(null);
				txtEmail.setText(null);
				txtEnd.setText(null);
				txtMunicipio.setText(null);
				cbUf.setSelectedIndex(0);
				ftfCelular.setText(null);
				cbCurso.setSelectedIndex(0);
				cbCampus.setSelectedIndex(0);
				if (rdbMatutino.isSelected()) {
					rdbMatutino.setSelected(true);
				} else if (rdbVespertino.isSelected()) {
					rdbMatutino.setSelected(true);
				} else if (rdbNortuno.isSelected()) {
					rdbMatutino.setSelected(true);
				}
				
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(396, 225, 95, 25);
		pnlDados.add(btnLimpar);

		pnlCurso = new JPanel();
		pnlCurso.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Curso", null, pnlCurso, null);
		//tabbedPane.setBackgroundAt(1, new Color(240, 255, 240));
		pnlCurso.setLayout(null);

		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurso.setBounds(24, 30, 41, 20);
		pnlCurso.add(lblCurso);

		lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCampus.setBounds(24, 74, 57, 20);
		pnlCurso.add(lblCampus);

		lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPeriodo.setBounds(24, 118, 54, 20);
		pnlCurso.add(lblPeriodo);

		cbCurso = new JComboBox();
		cbCurso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCurso.setModel(new DefaultComboBoxModel(
				new String[] { "Analise e Desenvolvimento de Sistemas", "Logistica", "Comercio Exterior", "Logistica Aeroportuaria" }));
		cbCurso.setBounds(108, 30, 366, 20);
		pnlCurso.add(cbCurso);

		cbCampus = new JComboBox();
		cbCampus.setModel(new DefaultComboBoxModel(
				new String[] { "São Bernardo do Campo", "Guarulhos", "Guarujá", "São Paulo",
						"São Carlos", "Campinas", "Tatuapé", "Pinheiros" }));
		cbCampus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbCampus.setBounds(108, 74, 366, 20);
		pnlCurso.add(cbCampus);

		rdbMatutino = new JRadioButton("Matutino");
		rdbMatutino.setFocusable(false);
		rdbMatutino.setBackground(new Color(248, 248, 255));
		rdbMatutino.setSelected(true);
		btgPeriodo.add(rdbMatutino);
		rdbMatutino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbMatutino.setBounds(108, 118, 109, 23);
		pnlCurso.add(rdbMatutino);

		rdbVespertino = new JRadioButton("Vespertino");
		rdbVespertino.setFocusable(false);
		rdbVespertino.setBackground(new Color(248, 248, 255));
		btgPeriodo.add(rdbVespertino);
		rdbVespertino.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbVespertino.setBounds(215, 118, 109, 23);
		pnlCurso.add(rdbVespertino);

		rdbNortuno = new JRadioButton("Noturno");
		rdbNortuno.setFocusable(false);
		rdbNortuno.setBackground(new Color(248, 248, 255));
		btgPeriodo.add(rdbNortuno);
		rdbNortuno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbNortuno.setBounds(326, 118, 109, 23);
		pnlCurso.add(rdbNortuno);

		pnlNotas = new JPanel();
		pnlNotas.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Notas e Faltas", null, pnlNotas, null);
		//tabbedPane.setBackgroundAt(2, new Color(255, 228, 225));
		pnlNotas.setLayout(null);

		lblRgmNotas = new JLabel("RGM");
		lblRgmNotas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRgmNotas.setBounds(293, 11, 33, 20);
		pnlNotas.add(lblRgmNotas);

		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDisciplina.setBounds(20, 88, 67, 20);
		pnlNotas.add(lblDisciplina);

		lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSemestre.setBounds(20, 119, 65, 20);
		pnlNotas.add(lblSemestre);

		lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNota.setBounds(199, 119, 33, 20);
		pnlNotas.add(lblNota);

		lblFaltas = new JLabel("Faltas");
		lblFaltas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFaltas.setBounds(344, 119, 40, 20);
		pnlNotas.add(lblFaltas);

		txtRgmNotas = new JTextField();
		txtRgmNotas.setDocument(new SoNumerosJTextField(11));
		txtRgmNotas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRgmNotas.setBounds(344, 11, 137, 20);
		pnlNotas.add(txtRgmNotas);
		txtRgmNotas.setColumns(10);

		txtNomeNotas = new JTextField();
		txtNomeNotas.setEditable(false);
		txtNomeNotas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeNotas.setColumns(10);
		txtNomeNotas.setBounds(95, 38, 386, 20);
		pnlNotas.add(txtNomeNotas);

		cbDisciplina = new JComboBox();
		cbDisciplina.setModel(new DefaultComboBoxModel(new String[] { "Algoritmos",
				"Sistemas Operacionais", "Engenharia de Software I", "Cálculo", "POO",
				"Redes", "Segurança da Informação", "Matemática Discreta" }));
		cbDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbDisciplina.setBounds(95, 88, 386, 20);
		pnlNotas.add(cbDisciplina);

		cbSemestre = new JComboBox();
		cbSemestre.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		cbSemestre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbSemestre.setBounds(95, 119, 94, 20);
		pnlNotas.add(cbSemestre);

		cbNota = new JComboBox();
		cbNota.setModel(new DefaultComboBoxModel(
				new String[] { "1.0", "2.0", "3.0", "4.0", "5.0", "6.0", "7.0", "8.0", "9.0", "10.0" }));
		cbNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbNota.setBounds(240, 119, 67, 20);
		pnlNotas.add(cbNota);

		txtFalta = new JTextField();
		txtFalta.setDocument(new SoNumerosJTextField(2));
		txtFalta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFalta.setBounds(394, 119, 86, 25);
		pnlNotas.add(txtFalta);
		txtFalta.setColumns(10);

		lblNomeNota = new JLabel("Nome");
		lblNomeNota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeNota.setBounds(20, 38, 42, 20);
		pnlNotas.add(lblNomeNota);

		lblRegistro = new JLabel("ID Nota");
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegistro.setBounds(20, 11, 58, 20);
		pnlNotas.add(lblRegistro);

		txtId = new JTextField();
		txtId.setDocument(new SoNumerosJTextField(11));
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setBounds(95, 11, 137, 20);
		pnlNotas.add(txtId);

		btnLimparNotaFalta = new JButton("Limpar");
		btnLimparNotaFalta.setFocusable(false);
		btnLimparNotaFalta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modelLimpar = (DefaultTableModel) tbConsultaRapida.getModel();
				modelLimpar.setRowCount(0);
				txtId.setText(null);
				txtRgmNotas.setText(null);
				txtNomeNotas.setText(null);
				txtCursoNotas.setText(null);
				cbDisciplina.setSelectedIndex(0);
				cbSemestre.setSelectedIndex(0);
				cbNota.setSelectedIndex(0);
				txtFalta.setText(null);
			}
		});
		btnLimparNotaFalta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimparNotaFalta.setBounds(394, 225, 86, 25);
		pnlNotas.add(btnLimparNotaFalta);

		lblCursoNota = new JLabel("Curso");
		lblCursoNota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCursoNota.setBounds(20, 63, 41, 20);
		pnlNotas.add(lblCursoNota);

		txtCursoNotas = new JTextField();
		txtCursoNotas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCursoNotas.setEditable(false);
		txtCursoNotas.setColumns(10);
		txtCursoNotas.setBounds(95, 63, 386, 20);
		pnlNotas.add(txtCursoNotas);

		btnConsultaRapida = new JButton("Consulta Rápida");
		btnConsultaRapida.setFocusable(false);
		btnConsultaRapida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DefaultTableModel modelLimpar = (DefaultTableModel) tbConsultaRapida.getModel();
					modelLimpar.setRowCount(0);
					daoNota = new NotaFaltaDAO();
					DefaultTableModel modelRapido = (DefaultTableModel) tbConsultaRapida.getModel();
					List<NotaFalta> lista = new ArrayList<NotaFalta>();
					lista = daoNota.listarNota();
					for (NotaFalta nf : lista) {
						modelRapido
								.addRow(new Object[] { Integer.toString(nf.getId()), Integer.toString(nf.getRgmAluno()),
										nf.getDisciplina(), nf.getSemestre(), nf.getNota(), nf.getFalta() });

					}
					if (modelRapido.getRowCount() == 0)
						JOptionPane.showMessageDialog(null, "N�o h� NOTAS registradas!");

				} catch (Exception e5) {
					JOptionPane.showMessageDialog(null, "Erro em Consulta R�pida:" + e5.getMessage());
				}
			}
		});
		btnConsultaRapida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultaRapida.setBounds(240, 225, 144, 25);
		pnlNotas.add(btnConsultaRapida);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 150, 461, 72);
		pnlNotas.add(scrollPane_1);

		tbConsultaRapida = new JTable();
		tbConsultaRapida.setDefaultRenderer(Object.class, new RenderizaJTable());
		tbConsultaRapida.getTableHeader().setReorderingAllowed(false);
		tbConsultaRapida.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "RGM", "Disciplina", "Semestre", "Notas", "Faltas" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbConsultaRapida.getColumnModel().getColumn(0).setPreferredWidth(24);
		tbConsultaRapida.getColumnModel().getColumn(1).setPreferredWidth(63);
		tbConsultaRapida.getColumnModel().getColumn(2).setPreferredWidth(140);
		tbConsultaRapida.getColumnModel().getColumn(3).setPreferredWidth(57);
		tbConsultaRapida.getColumnModel().getColumn(4).setPreferredWidth(39);
		tbConsultaRapida.getColumnModel().getColumn(5).setPreferredWidth(41);
		scrollPane_1.setViewportView(tbConsultaRapida);

		pnlBoletim = new JPanel();
		pnlBoletim.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Boletim", null, pnlBoletim, null);
		//tabbedPane.setBackgroundAt(3, new Color(240, 248, 255));
		pnlBoletim.setLayout(null);

		lblRgmBoletim = new JLabel("RGM");
		lblRgmBoletim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRgmBoletim.setBounds(10, 11, 33, 20);
		pnlBoletim.add(lblRgmBoletim);

		lblNomeBoletim = new JLabel("Nome");
		lblNomeBoletim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeBoletim.setBounds(163, 11, 42, 20);
		pnlBoletim.add(lblNomeBoletim);

		lblCursoBoletim = new JLabel("Curso");
		lblCursoBoletim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCursoBoletim.setBounds(10, 41, 41, 20);
		pnlBoletim.add(lblCursoBoletim);

		txtRgmBoletim = new JTextField();
		txtRgmBoletim.setDocument(new SoNumerosJTextField(11));
		txtRgmBoletim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRgmBoletim.setBounds(53, 11, 100, 20);
		pnlBoletim.add(txtRgmBoletim);
		txtRgmBoletim.setColumns(10);

		txtNomeBoletim = new JTextField();
		txtNomeBoletim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNomeBoletim.setEditable(false);
		txtNomeBoletim.setColumns(10);
		txtNomeBoletim.setBounds(218, 11, 288, 20);
		pnlBoletim.add(txtNomeBoletim);

		txtCursoBoletim = new JTextField();
		txtCursoBoletim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCursoBoletim.setEditable(false);
		txtCursoBoletim.setColumns(10);
		txtCursoBoletim.setBounds(72, 41, 434, 20);
		pnlBoletim.add(txtCursoBoletim);

		btnConsultarBoletim = new JButton("Consultar Boletim");
		btnConsultarBoletim.setFocusable(false);
		btnConsultarBoletim.setBounds(253, 230, 153, 25);
		pnlBoletim.add(btnConsultarBoletim);
		btnConsultarBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	

				if (txtRgmBoletim.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o RGM do aluno!");
					txtRgmBoletim.requestFocus();
				}


				else {
					try {
						DefaultTableModel modelLimpar = (DefaultTableModel) tbBoletim.getModel();
						modelLimpar.setRowCount(0);
						daoBoletim = new BoletimDAO();
						int codigo = Integer.parseInt(txtRgmBoletim.getText());
						aluno = daoBoletim.consultarAluno(codigo);
						txtNomeBoletim.setText(aluno.getNomeAluno());
						txtCursoBoletim.setText(aluno.getCursoAluno());
						txtCampusBoletim.setText(aluno.getCampusAluno());
						DefaultTableModel model = (DefaultTableModel) tbBoletim.getModel();
						List<NotaFalta> lista = new ArrayList<NotaFalta>();
						lista = daoBoletim.listarDados(codigo);
						for (NotaFalta nf : lista) {
							model.addRow(
									new Object[] { nf.getDisciplina(), nf.getSemestre(), nf.getNota(), nf.getFalta() });

						}

					} catch (Exception e4) {
						JOptionPane.showMessageDialog(null, "Aluno n�o encontrado. Insira um RGM valido!");
					}
				}
			}
		});
		btnConsultarBoletim.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnLimparBoletim = new JButton("Limpar");
		btnLimparBoletim.setFocusable(false);
		btnLimparBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modelLimpar = (DefaultTableModel) tbBoletim.getModel();
				modelLimpar.setRowCount(0);
				txtRgmBoletim.setText(null);
				txtNomeBoletim.setText(null);
				txtCursoBoletim.setText(null);
				txtCampusBoletim.setText(null);
			}
		});
		btnLimparBoletim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimparBoletim.setBounds(417, 230, 90, 25);
		pnlBoletim.add(btnLimparBoletim);

		lblCampusBoletim = new JLabel("Campus");
		lblCampusBoletim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCampusBoletim.setBounds(10, 71, 57, 20);
		pnlBoletim.add(lblCampusBoletim);

		txtCampusBoletim = new JTextField();
		txtCampusBoletim.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCampusBoletim.setEditable(false);
		txtCampusBoletim.setColumns(10);
		txtCampusBoletim.setBounds(72, 71, 434, 20);
		pnlBoletim.add(txtCampusBoletim);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 497, 123);
		pnlBoletim.add(scrollPane);

		tbBoletim = new JTable();
		tbBoletim.setDefaultRenderer(Object.class, new RenderizaJTable());
		tbBoletim.getTableHeader().setReorderingAllowed(false);
		tbBoletim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tbBoletim.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Disciplina", "Semestre", "Notas", "Faltas" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		tbBoletim.getColumnModel().getColumn(0).setResizable(false);
		tbBoletim.getColumnModel().getColumn(0).setPreferredWidth(113);
		tbBoletim.getColumnModel().getColumn(1).setResizable(false);
		tbBoletim.getColumnModel().getColumn(1).setPreferredWidth(56);
		tbBoletim.getColumnModel().getColumn(2).setResizable(false);
		tbBoletim.getColumnModel().getColumn(2).setPreferredWidth(42);
		tbBoletim.getColumnModel().getColumn(3).setResizable(false);
		tbBoletim.getColumnModel().getColumn(3).setPreferredWidth(43);
		scrollPane.setViewportView(tbBoletim);

		pnlListagem = new JPanel();
		pnlListagem.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Listagem", null, pnlListagem, null);
		//tabbedPane.setBackgroundAt(4, new Color(255, 250, 205));
		pnlListagem.setLayout(null);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 33, 497, 192);
		pnlListagem.add(scrollPane_2);

		tbListagem = new JTable();
		tbListagem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tbListagem.getTableHeader().setReorderingAllowed(false);
		tbListagem.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "RGM", "Nome", "Curso" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tbListagem.getColumnModel().getColumn(0).setPreferredWidth(59);
		tbListagem.getColumnModel().getColumn(1).setPreferredWidth(293);
		tbListagem.getColumnModel().getColumn(2).setPreferredWidth(94);
		scrollPane_2.setViewportView(tbListagem);

		btnListarAlunos = new JButton("Listar Alunos");
		btnListarAlunos.setFocusable(false);
		btnListarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DefaultTableModel modelLimpar = (DefaultTableModel) tbListagem.getModel();
					modelLimpar.setRowCount(0);
					dao = new AlunoDAO();
					DefaultTableModel modelRapido = (DefaultTableModel) tbListagem.getModel();
					List<Aluno> lista = new ArrayList<Aluno>();
					lista = dao.listarAluno();
					for (Aluno aluno : lista) {
						modelRapido.addRow(new Object[] { Integer.toString(aluno.getRgmAluno()), aluno.getNomeAluno(),
								aluno.getCursoAluno() });

					}
					if (modelRapido.getRowCount() == 0)
						JOptionPane.showMessageDialog(null, "N�o h� ALUNOS no sistema!");

				} catch (Exception e5) {
					JOptionPane.showMessageDialog(null, "Erro em Consulta R�pida:" + e5.getMessage());
				}
			}
		});
		btnListarAlunos.setBounds(300, 233, 115, 23);
		pnlListagem.add(btnListarAlunos);

		lblListagemDeAlunos = new JLabel("Listagem de Alunos");
		lblListagemDeAlunos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblListagemDeAlunos.setBounds(10, 8, 145, 21);
		pnlListagem.add(lblListagemDeAlunos);

		btnLimparListagem = new JButton("Limpar");
		btnLimparListagem.setFocusable(false);
		btnLimparListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelLimpar = (DefaultTableModel) tbListagem.getModel();
				modelLimpar.setRowCount(0);
			}
		});
		btnLimparListagem.setBounds(418, 233, 89, 23);
		pnlListagem.add(btnLimparListagem);
	}
}
