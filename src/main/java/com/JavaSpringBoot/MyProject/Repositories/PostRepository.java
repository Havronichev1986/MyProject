package com.JavaSpringBoot.MyProject.Repositories;

import com.JavaSpringBoot.MyProject.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
