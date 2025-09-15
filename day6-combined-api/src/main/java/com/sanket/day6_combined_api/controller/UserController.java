package com.sanket.day6_combined_api.controller;

import com.sanket.day6_combined_api.entity.User;
import com.sanket.day6_combined_api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserController {
    private final UserService service;
    public UserController(UserService service) { this.service = service; }

    @GetMapping
    public List<User> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public User create(@RequestBody User u) { return service.create(u); }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User u) { return service.update(id, u); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
