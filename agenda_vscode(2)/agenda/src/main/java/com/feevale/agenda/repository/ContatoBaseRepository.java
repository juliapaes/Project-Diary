package com.feevale.agenda.repository;

import java.util.List;

import com.feevale.agenda.models.Contato;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ContatoBaseRepository<EntityType extends Contato> extends Repository<EntityType, Integer> {

    @Query("select e from #{#entityName} e") // #{#entityName} will be magically replaced by type arguments in children
    List<EntityType> findThemAll();

}
