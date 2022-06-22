package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.repository.CategoryRepository;
import uz.pdp.springbootapelsin.service.CategoryService;



@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public String getAll(Model model) {
        categoryService.getAll(model);
        return "category/list";  // page nomi -> list.html  templates
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "category/add";
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute Category category, Model model) {
        categoryService.add(model,category);
        return "category/list";
    }

    @GetMapping("/delete/{id}")
    public String getDeletePage(@PathVariable("id") Integer custId, ModelAndView mv) {
        categoryService.delete(custId, (Model) mv);
        return "category/list";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @RequestBody Category category,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            category.setId(id);
            return "category/list";
        }
        categoryRepository.save(category);
        return "index";
    }



//    @GetMapping("/edit/{id}")
//    public String getEditPage(@PathVariable Integer id,@ModelAttribute Category category, Model model){
//        categoryService.edit(id,model,category);
//        return "category/list";
//    }
}
