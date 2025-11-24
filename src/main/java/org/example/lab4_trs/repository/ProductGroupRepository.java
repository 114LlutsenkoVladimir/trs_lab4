package org.example.lab4_trs.repository;

import org.example.lab4_trs.entity.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {

}