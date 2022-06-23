package com.br.gerenciadordearmariosapi.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

}
