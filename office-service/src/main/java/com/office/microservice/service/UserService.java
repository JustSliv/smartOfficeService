package com.office.microservice.service;

import com.office.microservice.model.User;

public interface UserService {

    User save(User user);
    User findById(Long userId);
    User update(User user);
    void deleteById(Long userId);
}
