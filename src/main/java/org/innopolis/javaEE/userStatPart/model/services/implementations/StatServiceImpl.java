package org.innopolis.javaEE.userStatPart.model.services.implementations;

import org.innopolis.javaEE.userStatPart.model.Stat;
import org.innopolis.javaEE.userStatPart.model.services.interfaces.StatService;
import org.innopolis.javaEE.userStatPart.model.services.repositories.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;

    @Autowired
    public StatServiceImpl(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @Override
    public Stat getStatByUserId(Long id) throws SQLException {
        Stat stat = statRepository.getById(id);
        if (stat == null)
            throw new SQLException("Stat from user with id: " + id + " not found");
        return stat;
    }
}
