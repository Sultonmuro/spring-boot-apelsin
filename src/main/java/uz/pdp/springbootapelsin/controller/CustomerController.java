package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springbootapelsin.entity.Customer;
import uz.pdp.springbootapelsin.repository.CustomerRepository;
import uz.pdp.springbootapelsin.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public String getAll(Model model) {
        customerService.getAll(model);
        return "customer/list";  // page nomi -> list.html  templates
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "customer/add";
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute Customer customer, Model model) {
        customerService.add((ModelAndView) model,customer);
        return "customer/list";
    }

    @GetMapping("/delete/{id}")
    public String getDeletePage(@PathVariable("id") Integer custId) {
        customerService.delete(custId);
        return "customer/list";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id, @Validated Customer customer,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            customer.setId(id);
            return "customer/list";
        }
        customerRepository.save(customer);
        return "index";
    }
}
