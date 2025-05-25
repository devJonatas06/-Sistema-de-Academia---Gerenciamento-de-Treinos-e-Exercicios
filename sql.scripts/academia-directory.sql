-- 1. Criação do banco
DROP DATABASE IF EXISTS academia;
CREATE DATABASE academia;
USE academia;

-- 2. Tabela de Treinos
CREATE TABLE treinos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
duracao_minutos INT);

-- 3. Tabela de Exercícios, com relação ao treino
CREATE TABLE exercicios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    series INT,
    repeticoes INT,
    treino_id INT,  -- chave estrangeira para treinos
    CONSTRAINT fk_exercicio_treino
        FOREIGN KEY (treino_id) REFERENCES treinos(id)
        ON DELETE CASCADE
);
