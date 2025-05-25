package com.Treinos.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exercicios")  // Deve corresponder ao nome da tabela no banco
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private int series;
    private int repeticoes;

    @ManyToOne
    @JoinColumn(name = "treino_id")
    @ToString.Exclude  // <-- Evita recursão no toString
    private Treino treino;


}


