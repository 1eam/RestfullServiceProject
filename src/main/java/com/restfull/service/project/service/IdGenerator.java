package com.restfull.service.project.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdGenerator {

    public String generateUserId(){
        return UUID.randomUUID().toString();
    }
}
