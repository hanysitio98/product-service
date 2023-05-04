package id.co.bca.miniproject.productservice.service;

import id.co.bca.miniproject.productservice.dto.ProductDTO;
import id.co.bca.miniproject.productservice.model.Product;

import java.util.List;

public interface ProductService {

    Product create(ProductDTO productDTO);
    Product update(ProductDTO productDTO, Integer productId);

    String delete(Integer productId);

    Product findProductById(Integer productId);
    List<Product> findAllProduct();
}
