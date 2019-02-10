package com.mamun.springdata.repository;

import com.mamun.springdata.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserId(Long id);

    /**
     * Get a user info using JPQL query
     * */
    @Query("SELECT u FROM User u WHERE u.name = :name")
    User findUserByNameUsingJPQL(String name);

    /**
     * Get users info using native query
     * */
    @Query(
            value = "SELECT * FROM USER u   WHERE u.age = :age",
            nativeQuery = true)
    List<User> findAllByAgeGreaterThan(@Param("age") int age);

    /**
     * This method mapped to mysql procedure named "findAllByUsersAddress"
     * */
    /**
     * Using parameter index
     * */
    @Query(value = "CALL findAllByUsersAddress(?1)", nativeQuery = true)
    List<User> findAllByUsersAddress(String address);


    /**
     * Using parameter name
     * */
    /*@Query(value = "CALL findAllByUsersAddress(:address)", nativeQuery = true)
    List<User> findAllByUsersAddress(String address);*/

    /**
     * Pagination
     * */
    Page<User> findAllByAgeGreaterThan(int age, Pageable pageable);

}
