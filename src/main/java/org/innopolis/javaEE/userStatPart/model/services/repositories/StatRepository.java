package org.innopolis.javaEE.userStatPart.model.services.repositories;

import org.innopolis.javaEE.userStatPart.model.Stat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatRepository extends CrudRepository<Stat, Long> {
    List<Stat> getAll();
    Stat getById(Long id);
}
