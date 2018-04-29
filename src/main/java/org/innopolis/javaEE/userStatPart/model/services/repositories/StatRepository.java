package org.innopolis.javaEE.userStatPart.model.services.repositories;

import org.innopolis.javaEE.userStatPart.model.Stat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface StatRepository extends CrudRepository<Stat, Integer> {
    List<Stat> getAll();
    Stat getById(Integer id);
}
