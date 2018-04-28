package org.innopolis.javaEE.userStatPart.model.services.implementations;

import org.innopolis.javaEE.userStatPart.model.Stat;
import org.innopolis.javaEE.userStatPart.model.services.interfaces.AdminTopService;
import org.innopolis.javaEE.userStatPart.model.services.repositories.TopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminTopServiceImpl implements AdminTopService {

    private final TopRepository topRepository;

    @Autowired
    public AdminTopServiceImpl(TopRepository topRepository) {
        this.topRepository = topRepository;
    }

    @Override
    public List<Stat> getTTops() {
        List<Stat> top = topRepository.getTops();
        return top == null ? new ArrayList<>() : top;
    }
}
