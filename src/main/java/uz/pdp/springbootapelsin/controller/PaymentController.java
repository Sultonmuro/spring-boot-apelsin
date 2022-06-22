package uz.pdp.springbootapelsin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import uz.pdp.springbootapelsin.dto.PaymentDto;
import uz.pdp.springbootapelsin.entity.Payment;
import uz.pdp.springbootapelsin.repository.PaymentRepository;
import uz.pdp.springbootapelsin.service.PaymentService;



@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping
    public String getAll(Model model) {
        paymentService.getAll(model);
        return "payment/list";  // page nomi -> list.html  templates
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "payment/add";
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute PaymentDto paymentDto, Model model) {
        paymentService.add(model,paymentDto);
        return "payment/list";
    }

    @GetMapping("/delete/{id}")
    public String getDeletePage(@PathVariable("id") Integer paymentId) {
        paymentService.delete(paymentId);
        return "payment/list";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("payment", payment);
        return "payment/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, @RequestBody PaymentDto paymentDto, Model model) {
        paymentService.edit(model,paymentDto);
        return "index";
    }

//    @GetMapping("/edit/{id}")
//    public String getEditPage(@PathVariable Integer id,@ModelAttribute Payment payment, Model model){
//        paymentService.edit(id,model,payment);
//        return "payment/list";
//    }
}