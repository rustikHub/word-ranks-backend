package com.example.worldranksfullstack.db.service;

import com.example.worldranksfullstack.db.entity.Info;

import java.util.List;

public interface InfoServiceInterface {
    List<Info> getAllInfo();

    Info getLastInfo();

    void clearAll();

    Info saveOrUpdate(Info info);
}
