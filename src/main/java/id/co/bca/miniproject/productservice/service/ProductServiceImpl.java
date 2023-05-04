package id.co.bca.miniproject.productservice.service;

import id.co.bca.miniproject.productservice.dto.ProductDTO;
import id.co.bca.miniproject.productservice.model.Product;
import id.co.bca.miniproject.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;


    @Override
    public Product create(ProductDTO productDTO) {
        Product model = new Product();
        model.setSellerId(productDTO.getSellerId());
        model.setProductName(productDTO.getProductName());
        model.setProductDescription(productDTO.getProductDescription());
        model.setPrice(productDTO.getPrice());
        model.setStockQuantity(productDTO.getStockQuantity());

        return productRepository.save(model);
    }

    @Override
    public Product update(ProductDTO productDTO, Integer id) {
        Product model = productRepository.findProductById(id);
        model.setId(id);
        model.setSellerId(productDTO.getSellerId());
        model.setProductName(productDTO.getProductName());
        model.setProductDescription(productDTO.getProductDescription());
        model.setPrice(productDTO.getPrice());
        model.setProductDescription(productDTO.getProductDescription());
        model.setStockQuantity(productDTO.getStockQuantity());

        return productRepository.save(model);

    }

    @Override
    public String delete(Integer id) {
        try {
            productRepository.deleteById(id);
            return "Successfully delete product";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete product");
        }
    }

    @Override
    public Product findProductById(Integer id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
}
