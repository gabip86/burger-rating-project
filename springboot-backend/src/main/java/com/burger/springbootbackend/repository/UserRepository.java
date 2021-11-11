package com.burger.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.burger.springbootbackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
