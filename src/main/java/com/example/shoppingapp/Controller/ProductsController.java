package com.example.shoppingapp.Controller;

import com.example.shoppingapp.Service.ProductService;
import com.example.shoppingapp.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/myListProduct")
    public String getProducts(Model model){
        List<Products> pro = productService.viewAllProducts();
        model.addAttribute("allProduct", pro);
        return "Products/list_product_page";
    }



    @PostMapping ("/myproducts")
    public String addProducts(@ModelAttribute("product") Products products, Model model){
        productService.addProducts(products);
       List<Products> pro = productService.viewAllProducts();
        model.addAttribute("allProduct", pro);
        return "Products/list_product_page";
        }

    @GetMapping("/addproduct")
    public String addProduct(Model model){
        Products products = new Products();
        model.addAttribute("product", products);
        return "Products/add_product_page";
    }

    @GetMapping("/myListProduct/{id}")
    public String viewProduct(@PathVariable(name = "id") Long id,Model model){
        Products products = productService.get(id);
        model.addAttribute("product",products);
        return "Products/view_products";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("Products/edit_product");
        Products products = productService.get(id);
        mav.addObject("product", products);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name="id") Long id){
    productService.deleteProducts(id);
    return "redirect:/myListProduct";
    }
}
