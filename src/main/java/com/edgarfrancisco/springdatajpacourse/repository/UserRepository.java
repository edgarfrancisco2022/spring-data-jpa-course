package com.edgarfrancisco.springdatajpacourse.repository;

import com.edgarfrancisco.springdatajpacourse.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
