package com.feevale.agenda.repository;

import com.feevale.agenda.models.ContatoFamiliar;
import org.springframework.data.repository.CrudRepository;

public interface ContatoFamiliarRepository extends CrudRepository<ContatoFamiliar, Integer> {
    ContatoFamiliar findByid(Integer id);
}
