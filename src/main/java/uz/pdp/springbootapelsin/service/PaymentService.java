package uz.pdp.springbootapelsin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.springbootapelsin.dto.PaymentDto;
import uz.pdp.springbootapelsin.entity.Invoice;
import uz.pdp.springbootapelsin.entity.Payment;
import uz.pdp.springbootapelsin.repository.InvoiceRepository;
import uz.pdp.springbootapelsin.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    InvoiceRepository invoiceRepository;


    public void getAll(Model model) {
        List<Payment> paymentList = paymentRepository.findAll();
        model.addAttribute("list",paymentList);
    }

    public void add(Model model, PaymentDto paymentDto) {
        Optional<Invoice> byId = invoiceRepository.findById(paymentDto.getInv_id());
        Payment payment = new Payment();
     payment.setAmount(paymentDto.getAmount());

     payment.setTime(paymentDto.getTimestamp());


        paymentRepository.save(payment);
        model.addAttribute("list",paymentRepository.findAll());
    }

    public void delete(Integer id) {
        paymentRepository.deleteById(id);
    }

    public void edit( Model model, PaymentDto paymentDto) {
       Payment payment1 = new Payment();

       payment1.setAmount(paymentDto.getAmount());
       paymentRepository.save(payment1);
        model.addAttribute("edit",paymentRepository.findAll());
    }
}
