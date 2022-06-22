package uz.pdp.springbootapelsin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import uz.pdp.springbootapelsin.dto.OrderDto;
import uz.pdp.springbootapelsin.entity.Detail;
import uz.pdp.springbootapelsin.entity.Invoice;
import uz.pdp.springbootapelsin.entity.Order;
import uz.pdp.springbootapelsin.repository.*;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    DetailRepository detailRepository;
    @Autowired
    InvoiceRepository invoiceRepository;



    public void add(Model model, OrderDto orderDto) {
        Order order = new Order();

        Order save = orderRepository.save(order);

        Detail detail = new Detail();
        detail.setOrder(save);

        Detail detailSave = detailRepository.save(detail);

        Invoice invoice = new Invoice();
        invoice.setOrder(save);
        BigDecimal price = detailSave.getProduct().getPrice();
        Integer quantity = detailSave.getQuantity();
        invoice.setAmount(price.multiply(BigDecimal.valueOf(quantity)));
        invoice.setDue((java.sql.Date) new Date());
        invoiceRepository.save(invoice);

    }

    public void delete(Integer id) {
        orderRepository.deleteById(id);
    }
}
