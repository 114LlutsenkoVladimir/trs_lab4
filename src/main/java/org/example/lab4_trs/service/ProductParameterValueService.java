package org.example.lab4_trs.service;

import org.example.lab4_trs.dto.ParametersByProductDto;
import org.example.lab4_trs.dto.ProductWithParametersDto;
import org.example.lab4_trs.entity.Parameter;
import org.example.lab4_trs.entity.ProductParameterValue;
import org.example.lab4_trs.repository.ParameterRepository;
import org.example.lab4_trs.repository.ProductParameterValueRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductParameterValueService extends AbstractCrudService<ProductParameterValue, Long,
        ProductParameterValueRepository> {

    public List<ParametersByProductDto> getParametersByProduct(List<Long> productIds) {
        List<ProductWithParametersDto> productWithParametersDtos =
                repository.findProductWithParametersByProductId(productIds);

        Map<Long, ParametersByProductDto> map = new LinkedHashMap<>();

        for (ProductWithParametersDto dto : productWithParametersDtos) {
            Long productId = dto.getProduct().productId();

            ParametersByProductDto resultDto =
                    map.computeIfAbsent(productId,
                            id -> new ParametersByProductDto(dto.getProduct())
                    );
            resultDto.addParameterWithValue(dto.getParameter());
        }
        return new ArrayList<>(map.values());
    }

    public List<ParametersByProductDto> getParametersByProduct(Long productId) {
        return getParametersByProduct(new ArrayList<>(List.of(productId)));
    }


}
