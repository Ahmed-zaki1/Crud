package com.export.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.export.entity.Users;

@Repository
public interface UserReop extends JpaRepository<Users, Long> {

}
