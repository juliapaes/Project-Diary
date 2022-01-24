package com.feevale.agenda.repository;

import com.feevale.agenda.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Usuario findOneByEmail(String email);

}
