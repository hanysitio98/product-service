package id.co.bca.miniproject.productservice.controller;

import id.co.bca.miniproject.productservice.dto.ProductDTO;
import id.co.bca.miniproject.productservice.model.Product;
import id.co.bca.miniproject.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Product> findAll() {
        return productService.findAllProduct();
    }

    @GetMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Product findByProductId(@RequestParam("id") Integer id) {
        return productService.findProductById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object createProduct(@RequestBody ProductDTO productDTO) {
        return productService.create(productDTO);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object updateProduct(@RequestBody ProductDTO productDTO, @RequestParam("id") Integer id) {
        return productService.update(productDTO, id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Object deleteProduct(@RequestParam("id") Integer id) {
        return productService.delete(id);
    }

}
