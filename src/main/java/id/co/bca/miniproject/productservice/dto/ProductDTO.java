package id.co.bca.miniproject.productservice.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDTO {

    private Integer sellerId;
    private String productName;
    private String productDescription;
    private Double price;
    private Integer stockQuantity;
}
