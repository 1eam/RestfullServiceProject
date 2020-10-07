package com.restfull.service.project.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // https://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50") int limit) {
        return "getUser was called with page: " + page + " and max list items: " + limit;
    }

    @GetMapping(path = "/{userId}")
    public String getUser1(@PathVariable String userId) {
        return "getUser was called on id:" + userId;
    }

    @PostMapping
    public String createUser() {
        return "createUser was called";
    }

    @PutMapping
    public String updateUser() {
        return "updateUser was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "deleteUser was called";
    }

}
