package com.office.officeservice.service;

import com.office.officeservice.model.User;

public interface UserService {

    User save(User user);
    User findById(Long userId);
    User update(User user);
    void deleteById(Long userId);
}
