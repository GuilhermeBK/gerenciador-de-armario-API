package com.br.gerenciadordearmariosapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table
public class Armario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_contratacao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDaContratacao;

    @Column(name = "data_expiracao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeExpiracao;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private String observacao;

    @OneToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;
}
