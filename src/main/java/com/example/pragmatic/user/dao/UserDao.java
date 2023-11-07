package com.example.pragmatic.user.dao;

import com.example.pragmatic.user.User;
import com.example.pragmatic.user.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> {
    Optional<UserDto> findByUserid(String userid);

}