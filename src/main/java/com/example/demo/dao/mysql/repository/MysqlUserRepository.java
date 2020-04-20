package com.example.demo.dao.mysql.repository;

import com.example.demo.dao.mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-06 12:02
 */
@Repository
public interface MysqlUserRepository extends JpaRepository<User, Long> {
}
