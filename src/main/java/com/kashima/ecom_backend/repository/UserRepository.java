package com.kashima.ecom_backend.repository;

import com.kashima.ecom_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String email);

}
