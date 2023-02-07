package com.bergamos.workshopmongo.services;

import com.bergamos.workshopmongo.entities.User;
import com.bergamos.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() { return userRepository.findAll(); }

}
