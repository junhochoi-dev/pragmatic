package com.project.pragmatic.user.dao;

import com.project.pragmatic.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> {
    User findByUserid(String userid);
}