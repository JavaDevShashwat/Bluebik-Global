package com.user.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	 @Autowired
	    private UserRepository userRepository;

	    @Override
	    public User create(User user) {
	        return userRepository.save(user);
	    }

	    @Override
	    public User update(User user) {
	        return userRepository.save(user);
	    }

	    @Override
	    public void delete(Long userId) {
	        userRepository.deleteById(userId);
	    }

	    @Override
	    public User getById(Long userId) {
	        return userRepository.findById(userId).orElse(null);
	    }

	    @Override
	    public List<User> getAll() {
	        return userRepository.findAll();
	    }

	    
}
