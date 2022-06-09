package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/all")
    public String getAll(Model model){
        categoryService.getAll(model);
        return "category"; //page nomi - > category.html templates da topadi
    }
    @GetMapping("/add")
    public String getAddPage(Model model){
   model.addAttribute("category",null);
        return "category/add"; //page nomi - > category.html templates da topadi
    }

}
