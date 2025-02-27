package com.JavaSpringBoot.MyProject.Repositories;

import com.JavaSpringBoot.MyProject.Models.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchases, Long> {
    List<Purchases> findByUserId(Long userId);
}
