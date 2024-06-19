package com.lld.bms.repositories;

import com.lld.bms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository<T, Id> Id is type of Id

    // Jpa is an interface and Hibernate is the actual implementation of this interface


    @Override
    Optional<User> findById(Long aLong);
}
