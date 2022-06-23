package com.br.gerenciadordearmariosapi.dto;

import com.br.gerenciadordearmariosapi.entity.Aluno;
import com.br.gerenciadordearmariosapi.entity.Armario;
import com.br.gerenciadordearmariosapi.entity.Situacao;
import lombok.Data;

@Data
public class ArmarioAtualizaDto {

    private Situacao situacao;

    private int idAluno;

    private int idArmario;


}
