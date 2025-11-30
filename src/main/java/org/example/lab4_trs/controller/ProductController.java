package org.example.lab4_trs.controller;

import lombok.RequiredArgsConstructor;
import org.example.lab4_trs.entity.Parameter;
import org.example.lab4_trs.entity.Product;
import org.example.lab4_trs.entity.ProductGroup;
import org.example.lab4_trs.service.ParameterService;
import org.example.lab4_trs.service.ProductGroupService;
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

    private final ProductService productService;
    private final ProductParameterValueService productParameterValueService;
    private final ParameterService parameterService;
    private final ProductGroupService productGroupService;

    @ModelAttribute("allParameters")
    public List<Parameter> allParameters() {
        return parameterService.findAll();
    }

    @ModelAttribute("allProductGroups")
    public List<ProductGroup> allProductGroups() {
        return productGroupService.findAll();
    }

    @ModelAttribute("allProducts")
    public List<Product> allProducts() {
        return productService.findAll();
    }

    @GetMapping("/")
    public String startPage() {
        return "products";
    }

    @GetMapping("/productWithoutParameter")
    public String getProductsWithoutParameter(@RequestParam Long parameterId,
                                              Model model) {
        model.addAttribute("products",
                productService.findProductsWithoutParameter(parameterId));
        return "products";
    }

    @GetMapping("/productsByProductGroupId")
    public String getProductsByProductGroupId(@RequestParam Long productGroupId,
                                              Model model) {
        model.addAttribute("products",
                productService.findProductsByProductGroup(productGroupId));
        return "products";
    }

    @GetMapping("/deleteProductsWithParameters")
    public String deleteProductsByParameters(@RequestParam List<Long> parameterIds,
                                             Model model) {
        model.addAttribute("products",
                productService.deleteProductsByParameterIds(parameterIds));
        return "products";
    }

//    @GetMapping("/getProductWithParameters/{productId}")
//    public String getProductWithParameters(@PathVariable Long productId,
//                                           Model model) {
//        model.addAttribute("dtoTable",
//                productParameterValueService.getParametersByProduct(productId));
//        return "products";
//    }



}
