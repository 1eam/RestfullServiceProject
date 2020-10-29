package com.restfull.service.project.controller;

import com.restfull.service.project.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users") // https://localhost:8080/users
public class UserController {

    //temporarily store users
    Map<String, User> database;

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return "getUser was called with page: " + page + " and max list items: " + limit;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getUser2(@PathVariable String userId) {

        if (database.containsKey(userId)){
            return new ResponseEntity<>(database.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping//(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public User createUser(@Valid @RequestBody User user) {

        User returnValue = new User();
        returnValue.setName(user.getName());
        returnValue.setLastName(user.getLastName());
        returnValue.setEmail(user.getEmail());
        String uuid = UUID.randomUUID().toString();
        returnValue.setId(uuid);

        if (database == null) database = new HashMap<>();

        database.put(returnValue.getId(), returnValue);

        return returnValue;
    }

    @PutMapping()
    public String updateUser() {
        return "updateUser was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "deleteUser was called";
    }

}
