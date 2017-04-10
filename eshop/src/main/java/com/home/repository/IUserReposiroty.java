package com.home.repository;

import com.home.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

//@Repository
public interface IUserReposiroty extends JpaRepository<User, UUID> {
}