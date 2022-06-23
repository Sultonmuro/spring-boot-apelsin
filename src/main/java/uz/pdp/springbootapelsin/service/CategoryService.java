package uz.pdp.springbootapelsin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public void getAll(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("list",categoryList);

    }

    public void edit(Integer id,Model model, Category category) {

        Optional<Category> byId = categoryRepository.findById(id);
 if(byId.isPresent()){
     Category editedCategory = byId.get();
     editedCategory.setName(category.getName());
     categoryRepository.save(editedCategory);
 }
 model.addAttribute("list",categoryRepository);
    }

    public void delete(Integer id, Model model) {
        Optional<Category> byId = categoryRepository.findById(id);
        byId.isPresent();

        categoryRepository.deleteById(id);

        model.addAttribute("list",categoryRepository.findAll());
    }

    public void add(Model model, Category category) {
        Category save = categoryRepository.save(category);
        if(save!=null){

        }
    }
}
