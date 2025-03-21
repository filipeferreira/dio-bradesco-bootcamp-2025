package me.dio.bradesco_bootcamp_2025.service;

import me.dio.bradesco_bootcamp_2025.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);
}
