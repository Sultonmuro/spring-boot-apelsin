package uz.pdp.springbootapelsin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.springbootapelsin.dto.ProductDto;
import uz.pdp.springbootapelsin.entity.Category;
import uz.pdp.springbootapelsin.entity.Product;
import uz.pdp.springbootapelsin.repository.CategoryRepository;
import uz.pdp.springbootapelsin.repository.ProductRepository;
import uz.pdp.springbootapelsin.dto.ProductDto;
import uz.pdp.springbootapelsin.entity.Product;
import uz.pdp.springbootapelsin.repository.CategoryRepository;
import uz.pdp.springbootapelsin.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public void getAll(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("list",productList);
    }

    public void add(Model model, ProductDto productDto) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPhoto(productDto.getPhoto());

        //1-variant
//        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCatId());
//        if (optionalCategory.isPresent()) {
//            Category category = optionalCategory.get();
//            product.setCategory(category);
//        }
        //yogini tanlay olmagani un mumkin

        productRepository.save(product);

        model.addAttribute("list",productRepository.findAll());
    }

    public void update(Model model, ProductDto productDto) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPhoto(productDto.getPhoto());


        //yogini tanlay olmagani un mumkin
        product.setCategory(categoryRepository.getById(productDto.getCatId()));
        productRepository.save(product);

        model.addAttribute("list",productRepository.findAll());
    }

    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
