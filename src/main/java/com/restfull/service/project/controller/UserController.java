package com.restfull.service.project.controller;

import com.restfull.service.project.exceptions.UserServiceException;
import com.restfull.service.project.model.UserModel;
import com.restfull.service.project.model.updateUserModel;
import com.restfull.service.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/users") // https://localhost:8080/users
public class UserController {

    @Autowired
    IUserService userServiceI;

    //temporarily store users
    Map<String, UserModel> database;

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return "getUser was called with page: " + page + " and max list items: " + limit;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserModel> getUser2(@PathVariable String userId) {

        //to trigger custom exception handling. Its a test.
        if (true){throw new UserServiceException("A user-service exception is thrown");}

        if (database.containsKey(userId)){
            return new ResponseEntity<>(database.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserModel requestBody) {

        UserModel returnValue = userServiceI.createUser(requestBody);
        return new ResponseEntity<UserModel>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserModel> updateUser(@PathVariable String userId, @Valid @RequestBody updateUserModel requestBody) {

        if (database.containsKey(userId)){

            UserModel selectedUser = database.get(userId);

            selectedUser.setName(requestBody.getName());
            selectedUser.setLastName(requestBody.getLastName());

            return new ResponseEntity<>(selectedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        database.remove(userId);
        return ResponseEntity.noContent().build();
    }
}