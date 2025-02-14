package com.JavaSpringBoot.MyProject.Repositories;

import com.JavaSpringBoot.MyProject.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
