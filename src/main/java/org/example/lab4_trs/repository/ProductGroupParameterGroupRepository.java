package org.example.lab4_trs.repository;

import org.example.lab4_trs.entity.Parameter;
import org.example.lab4_trs.entity.ProductGroupParameterGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductGroupParameterGroupRepository extends JpaRepository<ProductGroupParameterGroup, Long> {
    @Query("""
        select distinct p
        from Parameter p
            join p.parameterGroup pg
            join pg.productGroupParameterGroups link
                on link.parameterGroup = p.parameterGroup
            where link.productGroup.id = :productGroupId
    """)
    List<Parameter> getParametersForProductGroup(Long productGroupId);

}