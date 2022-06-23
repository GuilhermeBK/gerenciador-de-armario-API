package com.br.gerenciadordearmariosapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Permissao {

    @Id
    private Long codigo;
    private String descricao;
}
