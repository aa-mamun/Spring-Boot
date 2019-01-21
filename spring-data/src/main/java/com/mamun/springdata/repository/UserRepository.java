package com.mamun.springdata.repository;

import com.mamun.springdata.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserId(Long id);

    @Query(
            value = "SELECT * FROM USER u   WHERE u.age = :age ",
            nativeQuery = true)
    List<User> findAllByAgeGreaterThan(@Param("age") int age);

    /**
     * This method mapped mysql function named "findAllByUsersAddress"
     * */

    @Query(value = "CALL findAllByUsersAddress(?1)", nativeQuery = true)
    List<User> findAllByUsersAddress(String address);
}
