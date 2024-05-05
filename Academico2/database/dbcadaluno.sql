-- DB SISTEMA DE CADASTRO DE ALUNO 

-- CRIANDO BANCO DE DADOS
CREATE DATABASE IF NOT EXISTS dbcadaluno 
DEFAULT CHARACTER SET latin1
DEFAULT COLLATE latin1_swedish_ci;

USE dbcadaluno;

	-- TABELA DE CADASTRO DO ALUNO
CREATE TABLE IF NOT EXISTS tbaluno ( 
	rgmAluno INT(11) NOT NULL ,
    nomeAluno VARCHAR(50) NOT NULL ,
    dataNascAluno CHAR(11) NOT NULL ,
    cpfAluno CHAR(14) NOT NULL UNIQUE,
    emailAluno VARCHAR(50) NOT NULL UNIQUE,
    enderecoAluno VARCHAR(50) NOT NULL ,
    municipioAluno VARCHAR(30) NOT NULL ,
    ufAluno CHAR(2) NOT NULL ,
    celularAluno VARCHAR(16) NOT NULL UNIQUE,
    cursoAluno VARCHAR(40) NOT NULL,
    campusAluno VARCHAR(25) NOT NULL,
    periodoAluno VARCHAR(11) NOT NULL,
    PRIMARY KEY (rgmAluno)
);
    
SELECT * FROM tbaluno;
    
	-- TABELA DE NOTAS E FALTAS
CREATE TABLE IF NOT EXISTS tbnotafalta (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	rgmAluno INT NOT NULL,
	disciplina VARCHAR(40) NOT NULL,
	semestre VARCHAR(2) NOT NULL,
	nota VARCHAR(4) NOT NULL,
	falta VARCHAR(2) NOT NULL,
	FOREIGN KEY (rgmAluno)
    REFERENCES tbaluno (rgmAluno)
);

SELECT * FROM tbnotafalta;