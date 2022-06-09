package uz.pdp.springbootapelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootapelsin.entity.Detail;
import uz.pdp.springbootapelsin.entity.Invoice;

public interface DetailRepository extends JpaRepository<Detail,Integer> {

}
