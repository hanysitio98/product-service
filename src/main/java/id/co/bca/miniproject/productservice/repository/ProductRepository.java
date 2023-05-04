package id.co.bca.miniproject.productservice.repository;

import id.co.bca.miniproject.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductById(Integer id);

}
