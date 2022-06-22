package uz.pdp.springbootapelsin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springbootapelsin.dto.ProductDto;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.entity.Product;
import uz.pdp.springbootapelsin.repository.CategoryRepository;
import uz.pdp.springbootapelsin.repository.ProductRepository;
import uz.pdp.springbootapelsin.service.CategoryService;
import uz.pdp.springbootapelsin.service.ProductService;
import uz.pdp.springbootapelsin.dto.ProductDto;
import uz.pdp.springbootapelsin.entity.Product;
import uz.pdp.springbootapelsin.repository.CategoryRepository;
import uz.pdp.springbootapelsin.repository.ProductRepository;
import uz.pdp.springbootapelsin.service.ProductService;


import java.util.Optional;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

   private final ProductRepository productRepository;
   private final ProductService productService;
   private final CategoryRepository categoryRepository;

    @GetMapping
    public String getAll(Model model) {
        productService.getAll(model);
        return "product/list";  // page nomi -> list.html  templates
    }

    @GetMapping("/add")
    public String getAddPage(Model model) {
        model.addAttribute("categoryList",categoryRepository.findAll());
        return "product/add";
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute ProductDto productDto, Model model) {
        productService.add(model,productDto);
        return "product/list";
    }

    @GetMapping("/delete/{id}")
    public String getDeletePage(@PathVariable("id") Integer id) {
        productService.deleteById(id);
        return "index";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("product", product);
        return "product/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @RequestBody ProductDto productDto, Model model) {
        productService.update(model,productDto);
        return "index";
    }
}
