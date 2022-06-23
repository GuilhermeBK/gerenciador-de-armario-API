package com.br.gerenciadordearmariosapi.service;

import com.br.gerenciadordearmariosapi.repository.ArmarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ArmarioService {

    @Autowired
    private ArmarioRepository armarioRepository;


}
