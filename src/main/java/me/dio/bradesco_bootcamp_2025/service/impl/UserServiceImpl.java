package me.dio.bradesco_bootcamp_2025.service.impl;

import me.dio.bradesco_bootcamp_2025.controller.dto.UserDTO;
import me.dio.bradesco_bootcamp_2025.controller.mapper.UserMapper;
import me.dio.bradesco_bootcamp_2025.domain.model.User;
import me.dio.bradesco_bootcamp_2025.domain.repository.UserRepository;
import me.dio.bradesco_bootcamp_2025.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        if (userRepository.existsByAccountNumber(userDTO.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        var user = userMapper.toEntity(userDTO);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        User dbUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        User userToUpdate = userMapper.toEntity(userDTO);

        dbUser.setName(userToUpdate.getName());
        dbUser.setAccount(userToUpdate.getAccount());
        dbUser.setCard(userToUpdate.getCard());
        dbUser.setFeatures(userToUpdate.getFeatures());
        dbUser.setNews(userToUpdate.getNews());

        return userMapper.toDto(this.userRepository.save(dbUser));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
