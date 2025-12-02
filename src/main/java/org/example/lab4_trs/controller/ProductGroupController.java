package org.example.lab4_trs.controller;

import lombok.RequiredArgsConstructor;
import org.example.lab4_trs.entity.ParameterGroup;
import org.example.lab4_trs.entity.Product;
import org.example.lab4_trs.entity.ProductGroup;
import org.example.lab4_trs.service.ParameterGroupService;
import org.example.lab4_trs.service.ProductGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productGroups")
@RequiredArgsConstructor
public class ProductGroupController {
    private final ProductGroupService productGroupService;

    private final ParameterGroupService parameterGroupService;

    @ModelAttribute("allProductGroups")
    public List<ProductGroup> allProductGroups() {
        return productGroupService.findAll();
    }

    @ModelAttribute("allParameterGroups")
    public List<ParameterGroup> allParameterGroups() {
        return parameterGroupService.findAll();
    }

    @GetMapping("/")
    public String startPage(Model model) {
        model.addAttribute("productGroups", productGroupService.findAll());
        return "productGroups";
    }

    @GetMapping("/moveParametersToAnotherGroup")
    public String moveParametersToAnotherGroup(@RequestParam Long from,
                                               @RequestParam Long to,
                                               @RequestParam Long parameterGroupId,
                                               Model model) {
        try {
            productGroupService.moveParameterGroup(from, to, parameterGroupId);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("openErrorModal", true);
        }
        model.addAttribute("productGroups", productGroupService.findAll());
        return "productGroups";
    }
}
