package com.restfull.service.project.service;

import com.restfull.service.project.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    //temporarily store users
    Map<String, UserModel> database;

    //create User method
    @Override
    public UserModel createUser(UserModel requestBody) {

        UserModel newUser = new UserModel();
        newUser.setName(requestBody.getName());
        newUser.setLastName(requestBody.getLastName());
        newUser.setEmail(requestBody.getEmail());
        newUser.setPassword(requestBody.getPassword());
        String uuid = UUID.randomUUID().toString();
        newUser.setId(uuid);

        if (database == null) database = new HashMap<>();

        database.put(newUser.getId(), newUser);
        return newUser;
    }
}
