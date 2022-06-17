package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
@PostMapping("/add")
    public String getSavePage(@ModelAttribute Category category,Model model){
return "category/add";
}
@GetMapping("/edit/{id}")
public String getEdtiPage(){return "category/edit";}
@GetMapping("/edit{id}")
    public String saveEditPage(@PathVariable Integer id, @ModelAttribute Category category, Model model){
        categoryService.edit(id,model,category);
        return "category/list";

}

@GetMapping("/delete/{id}")
    public String deletePage(@PathVariable Integer id,Model model){
        categoryService.delete(id,model);
        return "category/list";
}
}
