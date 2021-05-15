package com.hcmus.weshare.repository;

import com.hcmus.weshare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByDisplayName(String displayName);
}
