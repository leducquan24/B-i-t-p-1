package com.example.apiwcrud.service;

import com.example.apiwcrud.model.UserssEntity;
import com.example.apiwcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(UserssEntity u) {
        userRepository.save(u);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserssEntity findById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<UserssEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<UserssEntity> findAllByName(String name) {
        return userRepository.findAllByNameContainsIgnoreCase(name);
    }
}
