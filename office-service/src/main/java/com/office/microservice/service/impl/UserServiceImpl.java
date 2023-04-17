package com.office.microservice.service.impl;

import com.office.microservice.service.UserService;
import com.office.microservice.model.User;
import com.office.microservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    @Transactional
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
