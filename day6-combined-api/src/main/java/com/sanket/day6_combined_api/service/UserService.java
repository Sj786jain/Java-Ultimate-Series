package com.sanket.day6_combined_api.service;

import com.sanket.day6_combined_api.entity.User;
import com.sanket.day6_combined_api.exception.ResourceNotFoundException;
import com.sanket.day6_combined_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;
    public UserService(UserRepository repo) { this.repo = repo; }

    public List<User> getAll() { return repo.findAll(); }
    public User getById(Long id) { return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id)); }
    public User create(User u) { return repo.save(u); }
    public User update(Long id, User updated) {
        User u = getById(id);
        u.setUsername(updated.getUsername());
        u.setEmail(updated.getEmail());
        u.setPassword(updated.getPassword()); // in real apps hash the password
        return repo.save(u);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
