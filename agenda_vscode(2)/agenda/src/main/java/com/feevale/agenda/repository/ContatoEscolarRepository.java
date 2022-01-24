package com.feevale.agenda.repository;

import com.feevale.agenda.models.ContatoEscolar;
import org.springframework.data.repository.CrudRepository;

public interface ContatoEscolarRepository extends CrudRepository<ContatoEscolar, Integer> {
    ContatoEscolar findByid(Integer id);

}
