package com.feevale.agenda.repository;

import com.feevale.agenda.models.ContatoEscolar;
import org.springframework.data.repository.CrudRepository;

public interface ContatoERepository extends ContatoBaseRepository<ContatoEscolar>, CrudRepository<ContatoEscolar, Integer> {

}
