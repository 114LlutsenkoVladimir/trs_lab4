package org.example.lab4_trs.repository;

import org.example.lab4_trs.entity.Product;
import org.example.lab4_trs.entity.ProductGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    @Modifying
    @Query("update Product p set p.name = ?1, p.description = ?2, p.releaseDate = ?3, p.productGroup = ?4")
    void updateNameAndDescriptionAndReleaseDateAndProductGroupBy(String name, String description,
                                                                 LocalDate releaseDate, ProductGroup productGroup);

    @Override
    Optional<Product> findById(Long aLong);

    void deleteById(Long id);
}