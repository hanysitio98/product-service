package id.co.bca.miniproject.productservice.kafka;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.bca.miniproject.productservice.dto.ProductDTO;
import id.co.bca.miniproject.productservice.dto.TransferDTO;
import id.co.bca.miniproject.productservice.model.Product;
import id.co.bca.miniproject.productservice.repository.ProductRepository;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private NewTopic productTopic;

    public ConsumerService(ProductRepository repository) {
        this.productRepository = repository;
    }

    @KafkaListener(topics = "updateStock", groupId = "miniproject", containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) {
        ObjectMapper mapper = new ObjectMapper();
        TransferDTO transferDTO = new TransferDTO();

        try {
            transferDTO = mapper.readValue(message, new TypeReference<TransferDTO>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        Product product = productRepository.findProductById(transferDTO.getProductId());
        product.setStockQuantity(product.getStockQuantity() - transferDTO.getStockQuantity());
        productRepository.save(product);
        System.out.println("Stock Quantity = " + product.getStockQuantity() );
    }

}
