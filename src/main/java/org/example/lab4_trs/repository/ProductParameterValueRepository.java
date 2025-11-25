package org.example.lab4_trs.repository;

import org.example.lab4_trs.entity.ProductParameterValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductParameterValueRepository extends JpaRepository<ProductParameterValue, Long> {
    List<ProductParameterValue> findByProduct_Id(Long id);

}