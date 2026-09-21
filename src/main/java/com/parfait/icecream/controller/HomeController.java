package com.parfait.icecream.controller;

import com.parfait.icecream.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ProductService productService;

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("products", productService.selectProduct());
        model.addAttribute("toppings", productService.selectTopping());
        return "index";
    }
}
