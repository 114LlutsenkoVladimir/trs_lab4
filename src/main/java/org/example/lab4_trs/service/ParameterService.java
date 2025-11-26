package org.example.lab4_trs.service;

import org.example.lab4_trs.entity.Parameter;
import org.example.lab4_trs.repository.ParameterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ParameterService extends AbstractCrudService<Parameter, Long, ParameterRepository> {
    public List<Parameter> getParametersByProductGroup(Long productGroupId) {
        return repository.findDistinctByParameterGroup_ProductGroupParameterGroups_ProductGroup_Id(productGroupId);
    }
}
