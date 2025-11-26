package org.example.lab4_trs.service;

import org.example.lab4_trs.entity.Product;
import org.example.lab4_trs.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ProductService extends AbstractCrudService<Product, Long, ProductRepository> {
    public List<Product> findProductsWithoutParameter(Long parameterId) {
        return repository.findProductsWithoutParameter(parameterId);
    }

    public List<Product> findProductsByProductGroup(Long productGroupId) {
        return repository.findByProductGroup_Id(productGroupId);
    }

}
