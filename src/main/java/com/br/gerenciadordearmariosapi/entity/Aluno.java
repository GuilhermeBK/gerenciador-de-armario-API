package com.br.gerenciadordearmariosapi.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty @NotNull
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @NotEmpty @NotNull
    @OneToOne
    @JoinColumn(name = "id_armario")
    private Armario armario;


}
