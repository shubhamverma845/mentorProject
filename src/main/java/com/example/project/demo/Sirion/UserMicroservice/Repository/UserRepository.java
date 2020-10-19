package com.example.project.demo.Sirion.UserMicroservice.Repository;

import com.example.project.demo.Sirion.UserMicroservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
