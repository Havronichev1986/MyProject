package com.JavaSpringBoot.MyProject.Repositories;

import com.JavaSpringBoot.MyProject.Models.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchases, Long> {
}
