package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService {

	User create(User user);
    User update(User user);
    void delete(Long userId);
    User getById(Long userId);
    List<User> getAll();
}
