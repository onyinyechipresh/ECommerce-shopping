package com.example.shoppingapp.Controller;


import com.example.shoppingapp.Service.ProductService;
import com.example.shoppingapp.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;


    @GetMapping("/orderPage")
    public String orderPage(Model model){
        List<Products> product = productService.viewAllProducts();
        model.addAttribute("product",product);
        return "order_page";
    }
}
