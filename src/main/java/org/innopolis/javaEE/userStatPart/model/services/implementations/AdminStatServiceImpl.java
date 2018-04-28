package org.innopolis.javaEE.userStatPart.model.services.implementations;

import org.innopolis.javaEE.userStatPart.model.Stat;
import org.innopolis.javaEE.userStatPart.model.services.interfaces.AdminStatService;
import org.innopolis.javaEE.userStatPart.model.services.repositories.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminStatServiceImpl implements AdminStatService {
    private final StatRepository statRepository;

    @Autowired
    public AdminStatServiceImpl(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @Override
    public List<Stat> getAllStats() {
        List<Stat> stats = statRepository.getAll();
        return stats == null ? new ArrayList<>() : stats;
    }
}
