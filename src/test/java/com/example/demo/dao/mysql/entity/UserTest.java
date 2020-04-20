package com.example.demo.dao.mysql.entity;

import static org.junit.Assert.*;

import com.example.demo.BaseTest;
import com.example.demo.dao.mysql.repository.MysqlUserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BaseTest {
    @Autowired
    private MysqlUserRepository userRepository;

    @Test
    public void saveTest() {
        User user = new User();
        user.setAge(1);
        userRepository.save(user);
    }
}
