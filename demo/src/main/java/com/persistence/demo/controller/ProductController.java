package com.persistence.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.persistence.demo.bl.BasicProductManagement;
import com.persistence.demo.domain.Product;

@Controller
public class ProductController {

    @Autowired
    private BasicProductManagement basicProductManagement;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listProducts = basicProductManagement.GetAllProducts();
        model.addAttribute("list", listProducts);
        return "product/index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        basicProductManagement.AddProduct(product);
        return "redirect:/";
    }

}
