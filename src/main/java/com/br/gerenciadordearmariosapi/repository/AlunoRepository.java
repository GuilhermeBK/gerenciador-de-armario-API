package com.br.gerenciadordearmariosapi.repository;

import com.br.gerenciadordearmariosapi.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
