package com.br.gerenciadordearmariosapi.controller;

import com.br.gerenciadordearmariosapi.entity.Aluno;
import com.br.gerenciadordearmariosapi.entity.Armario;
import com.br.gerenciadordearmariosapi.repository.AlunoRepository;
import com.br.gerenciadordearmariosapi.repository.ArmarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ArmarioRepository armarioRepository;

    @GetMapping
    public List<Aluno> listaAlunos() {
        return alunoRepository.findAll();
    }

    @GetMapping("porArmario/{id}")
    public ResponseEntity<Armario> listaArmarioAluno(@PathVariable int id) {
        Optional<Aluno> byId = alunoRepository.findById(id);
        int idArmario = byId.get().getArmario().getId();

        Optional<Armario> listaPorid = armarioRepository.findById(idArmario);

        if (listaPorid.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaPorid.get());
    }

}
