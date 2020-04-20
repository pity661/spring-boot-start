package com.example.demo.dao.postgre.entity;

import com.example.demo.BaseTest;
import com.example.demo.dao.postgre.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BaseTest {

  @Autowired private UserRepository userRepository;

  @Test
  public void saveTest() {
    User user = new User();
    user.setAge(1);
    userRepository.save(user);
  }
}
