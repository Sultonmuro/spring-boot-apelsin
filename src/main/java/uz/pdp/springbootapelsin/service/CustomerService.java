package uz.pdp.springbootapelsin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import uz.pdp.springbootapelsin.entity.Customer;
import uz.pdp.springbootapelsin.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository  customerRepository;

    public void getAll(Model model) {
        List<Customer> all = customerRepository.findAll();
        model.addAttribute("list",all);
    }

    public void getOne(Integer id,Model model) {
        Optional<Customer> byId = customerRepository.findById(id);
if(byId.isPresent()){
    Customer customer = byId.get();
    model.addAttribute("ketmon",customer);
}
    }

    public ModelAndView add(ModelAndView mv,Customer customer) {
        Customer save = customerRepository.save(customer);
       return mv.addObject("",save);
    }
    public void delete(Integer cust_id){
        customerRepository.deleteById(cust_id);

    }
}
