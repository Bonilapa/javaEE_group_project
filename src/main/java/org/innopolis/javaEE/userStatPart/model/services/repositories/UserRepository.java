package org.innopolis.javaEE.userStatPart.model.services.repositories;

import org.innopolis.javaEE.dataService.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
