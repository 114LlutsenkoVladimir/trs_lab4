package org.example.lab4_trs.service;

import lombok.RequiredArgsConstructor;
import org.example.lab4_trs.entity.ParameterGroup;
import org.example.lab4_trs.entity.ProductGroup;
import org.example.lab4_trs.entity.ProductGroupParameterGroup;
import org.example.lab4_trs.repository.ParameterGroupRepository;
import org.example.lab4_trs.repository.ParameterRepository;
import org.example.lab4_trs.repository.ProductGroupParameterGroupRepository;
import org.example.lab4_trs.repository.ProductGroupRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductGroupService extends AbstractCrudService<ProductGroup, Long, ProductGroupRepository> {
    private final ProductGroupParameterGroupRepository productGroupParameterGroupRepository;
    private final ParameterRepository parameterRepository;
    private final ProductGroupRepository productGroupRepository;
    private final ParameterGroupRepository parameterGroupRepository;

    public ProductGroupService(ProductGroupRepository repository,
                               ProductGroupParameterGroupRepository productGroupParameterGroupRepository,
                               ParameterRepository parameterRepository,
                               ProductGroupRepository productGroupRepository,
                               ParameterGroupRepository parameterGroupRepository) {
        super(repository);
        this.productGroupParameterGroupRepository = productGroupParameterGroupRepository;
        this.parameterRepository = parameterRepository;
        this.productGroupRepository = productGroupRepository;
        this.parameterGroupRepository = parameterGroupRepository;
    }

    public void moveParameterGroup(Long fromProductGroupId, Long toProductGroupId, Long parameterGroupId) {
        ProductGroup from = productGroupRepository.findById(fromProductGroupId).orElseThrow();
        ProductGroup to = productGroupRepository.findById(toProductGroupId).orElseThrow();
        ParameterGroup parameter = parameterGroupRepository.findById(parameterGroupId).orElseThrow();

        ProductGroupParameterGroup link = productGroupParameterGroupRepository
                .findByProductGroup_IdAndParameterGroup_Id(fromProductGroupId, parameterGroupId)
                .orElseThrow();

        boolean alreadyExist = productGroupParameterGroupRepository
                .findByProductGroup_IdAndParameterGroup_Id(toProductGroupId, parameterGroupId)
                .isPresent();

        if(alreadyExist)
            throw new RuntimeException("група параметрів вже привьязана до цієї групи продуктів");

        link.setProductGroup(to);
    }


}
