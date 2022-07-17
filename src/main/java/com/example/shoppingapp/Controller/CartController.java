package com.example.shoppingapp.Controller;


import com.example.shoppingapp.Service.ProductService;
import com.example.shoppingapp.model.GlobalData;
import com.example.shoppingapp.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CartController {


    @Autowired
    ProductService productService;


    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable(name = "id") Long id){
        GlobalData.cart.add(productService.getProductsById(id).get());

        return "redirect:/orderPage";
    }


    @GetMapping("/cart")
    public String cartGet(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Products::getPrice).sum());

        List<Products> product = GlobalData.cart;
        model.addAttribute("cart", product);

        return "cart_page";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String removeItemFromCart(@PathVariable int index){
        GlobalData.cart.remove(index);

        return "redirect:/cart";

    }


}
