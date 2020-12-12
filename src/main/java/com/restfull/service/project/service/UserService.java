package com.restfull.service.project.service;

import com.restfull.service.project.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    //temporary database
    Map<String, UserModel> database;

    IdGenerator idGenerator;

    public UserService() {
    }

    public UserService(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @Override
    public UserModel createUser(UserModel requestBody) {

        UserModel newUser = new UserModel();
        newUser.setName(requestBody.getName());
        newUser.setLastName(requestBody.getLastName());
        newUser.setEmail(requestBody.getEmail());
        newUser.setPassword(requestBody.getPassword());
        newUser.setId(idGenerator.generate());

        if (database == null) database = new HashMap<>();

        database.put(newUser.getId(), newUser);
        return newUser;
    }
}
