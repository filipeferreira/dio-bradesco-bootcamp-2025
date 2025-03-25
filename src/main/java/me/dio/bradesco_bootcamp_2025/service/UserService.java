package me.dio.bradesco_bootcamp_2025.service;

import me.dio.bradesco_bootcamp_2025.controller.dto.UserDTO;

public interface UserService {

    UserDTO findById(Long id);

    UserDTO create(UserDTO userDTO);

    UserDTO update(Long id, UserDTO userDTO);

    void deleteById(Long id);
}
