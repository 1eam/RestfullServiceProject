package com.restfull.service.project.service;

import java.util.UUID;

public class IdGenerator {

    public String generate(){
        return UUID.randomUUID().toString();
    }
}
