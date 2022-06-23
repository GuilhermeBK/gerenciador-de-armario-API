package com.br.gerenciadordearmariosapi.entity;

import lombok.Getter;

@Getter
public enum Situacao {

    ALUGADO("Alugado"),
    OCUPADO("Despesa"),
    ATRASADO("Atrasado");

    private final String descricao;

    Situacao(String descricao){
        this.descricao = descricao;
    }
}
