package org.example.lab4_trs.controller;

import lombok.RequiredArgsConstructor;
import org.example.lab4_trs.service.ParameterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/parameters")
class ParameterController {
    ParameterService parameterService;

    @GetMapping("/parametersByGroup/{productGroupId}")
    public String getParametersByGroup(@PathVariable Long productGroupId,
                                       Model model) {
        model.addAttribute("parameters",
                parameterService.getParametersByProductGroup(productGroupId));
        return "parameters";
    }




}
