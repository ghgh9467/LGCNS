package com.example.myproject.repository;

import com.example.myproject.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserData, String> {

    Optional<UserData> findByUserId(String inputId);
}
