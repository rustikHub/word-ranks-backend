package com.example.worldranksfullstack.db.service;

import com.example.worldranksfullstack.db.entity.Info;
import com.example.worldranksfullstack.db.repository.InfoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InfoService implements InfoServiceInterface {

    private final InfoRepository infoRepository;

    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @Override
    public List<Info> getAllInfo() {
        return infoRepository.findAll();
    }

    @Override
    public Info getLastInfo() {
        return infoRepository.findFirstByRequestDateIsBefore(new Date()).orElse(null);
    }

    @Override
    public void clearAll() {
        infoRepository.deleteAll();
    }

    @Override
    public Info saveOrUpdate(Info info) {
        return infoRepository.save(info);
    }
}
