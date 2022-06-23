package com.br.gerenciadordearmariosapi.controller;

import com.br.gerenciadordearmariosapi.entity.Aluno;
import com.br.gerenciadordearmariosapi.entity.Armario;
import com.br.gerenciadordearmariosapi.entity.Situacao;
import com.br.gerenciadordearmariosapi.repository.AlunoRepository;
import com.br.gerenciadordearmariosapi.repository.ArmarioRepository;
import com.br.gerenciadordearmariosapi.service.ArmarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/armario")
public class ArmarioController {

    @Autowired
    private ArmarioService armarioService;

    @Autowired
    private ArmarioRepository armarioRepository;
    @Autowired
    private AlunoRepository alunoRepository;


    @GetMapping("armarios/")
    public List<Armario> listarArmarios() {
        return armarioRepository.findAll();
    }

    @GetMapping("armarios/{id}")
    public ResponseEntity<Armario> listarPorId(int id) {
        log.info("chamando findById");

        Optional<Armario> listaPorid = armarioRepository.findById(id);

        if (listaPorid.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaPorid.get());

    }

    @PostMapping("/create/armario")
    public ResponseEntity<Armario> criarArmario(@Valid @RequestBody Armario armario) {
        Armario armarioSalvo = armarioRepository.save(armario);
        return ResponseEntity.status(HttpStatus.CREATED).body(armarioSalvo);
    }


    @PostMapping("atualiar/{idArmario}")
    public ResponseEntity<String> atualizarSituacao(@PathVariable int idArmario,
                                    @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataExpiracao,
                                    @RequestParam int idAluno,
                                    @RequestParam String situacao,
                                    @RequestBody(required = false) String observacao) {

        log.info("chamando >>> atualizarSituacao ");

        Optional<Armario> armario = armarioRepository.findById(idArmario);
        Optional<Aluno> aluno = alunoRepository.findById(idAluno);

        if (armario.isEmpty() || aluno.isEmpty()) {
            new EmptyResultDataAccessException(1);
            log.error("Armario ou aluno nao existem");
            return ResponseEntity.notFound().build();
        }

        LocalDate dataContratacao = LocalDate.now();

        armario.get().setSituacao(Situacao.valueOf(situacao));
        armario.get().setAluno(aluno.get());
        armario.get().setObservacao(observacao);
        armario.get().setDataDaContratacao(dataContratacao);
        armario.get().setDataDeExpiracao(dataExpiracao);

        return ResponseEntity.ok().body("Salvo!");

    }


}
