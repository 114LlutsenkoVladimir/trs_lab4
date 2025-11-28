package org.example.lab4_trs.controller;

import org.example.lab4_trs.service.ProductGroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productGroups")
public class ProductGroupController {
    ProductGroupService productGroupService;

    @PostMapping("/moveParametersToAnotherGroup/{from}/{to}/{parameterGroupId}")
    public String moveParametersToAnotherGroup(@PathVariable Long from,
                                               @PathVariable Long to,
                                               @PathVariable Long parameterGroupId,
                                               Model model) {
        productGroupService.moveParameterGroup(from, to, parameterGroupId);
        return "productGroups";
    }
}
