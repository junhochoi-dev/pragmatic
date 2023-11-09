package com.project.pragmatic.user.dao;

import com.project.pragmatic.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByUserid(String userid);
}