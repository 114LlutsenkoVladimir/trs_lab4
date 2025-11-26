package org.example.lab4_trs.service;

import org.example.lab4_trs.entity.Parameter;
import org.example.lab4_trs.entity.ParameterGroup;
import org.example.lab4_trs.entity.ProductGroup;
import org.example.lab4_trs.entity.ProductGroupParameterGroup;
import org.example.lab4_trs.repository.ParameterRepository;
import org.example.lab4_trs.repository.ProductGroupParameterGroupRepository;
import org.example.lab4_trs.repository.ProductGroupRepository;
import org.springframework.stereotype.Service;

@Service
class ProductGroupService extends AbstractCrudService<ProductGroup, Long, ProductGroupRepository>{
    ProductGroupParameterGroupRepository productGroupParameterGroupRepository;

    ParameterRepository parameterRepository;

    public void moveParameterGroup(Long fromProductGroupId, Long toProductGroupId, Long parameterGroupId) {
        ProductGroup fromProductGroup = repository.findById(fromProductGroupId);
        ProductGroup toProductGroup = repository.findById(toProductGroupId);
        ParameterGroup parameter = parameterRepository.findById(parameterGroupId);

        if (fromProductGroup.getProductGroupParameterGroups().stream().
                filter(pg -> pg.getProductGroup().getId().equals(fromProductGroupId))
                .toList().isEmpty())
            return;

        fromProductGroup.getProductGroupParameterGroups().removeIf(
                pg -> pg.getParameterGroup().getId().equals(parameterGroupId));

        toProductGroup.getProductGroupParameterGroups().add(new ProductGroupParameterGroup(toProductGroup, parameter));
    }
}
