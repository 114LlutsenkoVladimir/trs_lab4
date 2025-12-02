package org.example.lab4_trs.service;

import org.example.lab4_trs.entity.ParameterGroup;
import org.example.lab4_trs.repository.ParameterGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class ParameterGroupService extends AbstractCrudService<ParameterGroup, Long, ParameterGroupRepository> {
    public ParameterGroupService(ParameterGroupRepository repository) {
        super(repository);
    }
}
