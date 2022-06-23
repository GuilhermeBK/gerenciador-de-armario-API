package com.br.gerenciadordearmariosapi.repository;

import com.br.gerenciadordearmariosapi.entity.Armario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmarioRepository extends JpaRepository<Armario, Integer> {
}
