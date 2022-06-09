package uz.pdp.springbootapelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootapelsin.entity.Order;
import uz.pdp.springbootapelsin.entity.Product;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
