package org.example.lab4_trs.repository;

import org.example.lab4_trs.entity.Parameter;
import org.example.lab4_trs.entity.Product;
import org.example.lab4_trs.entity.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
    select p from Product p
        where not exists (
            select 1
                from ProductParameterValue ppv
                    where ppv.product = p
                        and ppv.parameter.id = :parameterId
        )
    """)
    List<Product> findProductsWithoutParameter(@Param("parameterId") Long parameterId);

    List<Product> findByProductGroup_Id(Long id);


}