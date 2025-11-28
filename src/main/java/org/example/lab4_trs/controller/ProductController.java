package org.example.lab4_trs.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.lab4_trs.entity.ProductParameterValue;
import org.example.lab4_trs.service.ProductParameterValueService;
import org.example.lab4_trs.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    ProductParameterValueService productParameterValueService;

    @GetMapping("/productWithoutParameter/{parameterId}")
    public String getProductsWithoutParameter(@PathVariable Long parameterId,
                                              Model model) {
        model.addAttribute("products",
                productService.findProductsWithoutParameter(parameterId));
        return "products";
    }

    @GetMapping("/productsByProductGroupId/{productGroupId}")
    public String getProductsByProductGroupId(@PathVariable Long productGroupId,
                                              Model model) {
        model.addAttribute("products",
                productService.findProductsByProductGroup(productGroupId));
        return "products";
    }

    @DeleteMapping("/deleteProductsWithParameters")
    public String deleteProductsByParameters(@RequestParam List<Long> parameterIds,
                                             Model model) {
        model.addAttribute("products",
                productService.deleteProductsByParameterIds(parameterIds));
        return "products";
    }

    @GetMapping("/getProductWithParameters/{productId}")
    public String getProductWithParameters(@PathVariable Long productId,
                                           Model model) {
        model.addAttribute("dtoTable",
                productParameterValueService.getParametersByProduct(productId));
        return "products";
    }



}
