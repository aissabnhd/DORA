package fr.ajaate.dora.service;

import fr.ajaate.dora.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}