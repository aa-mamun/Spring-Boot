package com.mamun.springbootcrud.repository;

import com.mamun.springbootcrud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserId(Long id);
}
