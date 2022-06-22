package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import uz.pdp.springbootapelsin.dto.OrderDto;
import uz.pdp.springbootapelsin.repository.CategoryRepository;
import uz.pdp.springbootapelsin.repository.CustomerRepository;
import uz.pdp.springbootapelsin.repository.OrderRepository;
import uz.pdp.springbootapelsin.repository.ProductRepository;
import uz.pdp.springbootapelsin.service.CategoryService;
import uz.pdp.springbootapelsin.service.OrderService;



@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderService orderService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("list",orderRepository.findAll());
        return "order/list";  // page nomi -> list.html  templates
    }

    @GetMapping("/add")
    public String getAddPage(Model model) {
        model.addAttribute("customerList",customerRepository.findAll());
        model.addAttribute("productList",productRepository.findAll());
        return "order/add";
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute OrderDto orderDto, Model model) {
        orderService.add(model,orderDto);
        model.addAttribute("list", orderRepository.findAll());
        return "redirect:";
    }

    @GetMapping("/delete/{id}")
    public String getDeletePage(@PathVariable Integer id) {
        orderService.delete(id);
        return "redirect:";
    }

//   @GetMapping("/edit/{id}")
//    public String getEditPage(@PathVariable Integer id,@ModelAttribute Category category, Model model){
//        categoryService.edit(id,model,category);
//        return "category/list";
//    }
}
