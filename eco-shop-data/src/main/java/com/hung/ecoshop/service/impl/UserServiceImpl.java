package com.hung.ecoshop.service.impl;

import com.hung.ecoshop.entity.User;
import com.hung.ecoshop.enums.ResultEnum;
import com.hung.ecoshop.exception.MyException;
import com.hung.ecoshop.repository.UserRepository;
import com.hung.ecoshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
//@DependsOn("passwordEncoder")
public class UserServiceImpl implements UserService {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @Override
    public User findOne(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Collection<User> findByRole(String role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    @Transactional
    public User save(User user) {
        //register
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            return userRepository.save(user);

        } catch (Exception e) {
            throw new MyException(ResultEnum.VALID_ERROR);
        }
    }

    @Override
    @Transactional
    public User update(User user) {
        User oldUser = userRepository.findByEmail(user.getEmail());
//        oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        oldUser.setName(user.getName());
        oldUser.setPhone(user.getPhone());
        oldUser.setAddress(user.getAddress());
        return userRepository.save(oldUser);
    }

}
