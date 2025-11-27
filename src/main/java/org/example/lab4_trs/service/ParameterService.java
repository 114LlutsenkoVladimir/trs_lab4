package org.example.lab4_trs.service;

import org.example.lab4_trs.entity.Parameter;
import org.example.lab4_trs.repository.ParameterRepository;
import org.example.lab4_trs.repository.ProductGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ParameterService extends AbstractCrudService<Parameter, Long, ParameterRepository> {

    ProductGroupRepository productGroupRepository;

    public List<Parameter> getParametersByProductGroup(Long productGroupId) {
        productGroupRepository.findById(productGroupId);
        return repository.findDistinctByParameterGroup_ProductGroupParameterGroups_ProductGroup_Id(productGroupId);
    }
}
