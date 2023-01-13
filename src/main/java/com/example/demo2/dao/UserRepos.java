package com.example.demo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo2.model.User;

public interface UserRepos extends JpaRepository<User, Integer> {

}
