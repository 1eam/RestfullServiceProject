package com.restfull.service.project.controller;

import com.restfull.service.project.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users") // https://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return "getUser was called with page: " + page + " and max list items: " + limit;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User getUser1(@PathVariable String userId) {

        User getResponse = new User();
        getResponse.setName("Esther");
        getResponse.setLastName("A M");
        getResponse.setEmail("test@test.com");

        return getResponse;
    }

    @PostMapping//(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public User createUser(@Valid @RequestBody User user) {

        User returnValue = new User();
        returnValue.setName(user.getName());
        returnValue.setLastName(user.getLastName());
        returnValue.setEmail(user.getEmail());

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
