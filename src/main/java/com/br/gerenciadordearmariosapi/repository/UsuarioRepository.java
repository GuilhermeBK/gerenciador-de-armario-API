package com.br.gerenciadordearmariosapi.repository;

import com.br.gerenciadordearmariosapi.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository {

    public Optional<Usuario> findByEmail(String email);

    public List<Usuario> findByPermissoesDescricao(String permissaoDescricao);

}
