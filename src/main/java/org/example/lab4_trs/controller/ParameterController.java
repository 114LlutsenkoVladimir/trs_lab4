package org.example.lab4_trs.controller;

import lombok.RequiredArgsConstructor;
import org.example.lab4_trs.entity.Product;
import org.example.lab4_trs.entity.ProductGroup;
import org.example.lab4_trs.service.ParameterService;
import org.example.lab4_trs.service.ProductGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/parameters")
class ParameterController {
    private final ParameterService parameterService;

    private final ProductGroupService productGroupService;

    @ModelAttribute("allProductGroups")
    public List<ProductGroup> allProductGroups() {
        return productGroupService.findAll();
    }

    @GetMapping("/")
    public String startPage() {
        return "parameters";
    }

    @GetMapping("/parametersByGroup")
    public String getParametersByGroup(@RequestParam Long productGroupId,
                                       Model model) {
        model.addAttribute("parameters",
                parameterService.getParametersByProductGroup(productGroupId));
        return "parameters";
    }
    
}
