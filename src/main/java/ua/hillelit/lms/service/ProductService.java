package ua.hillelit.lms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.hillelit.lms.dto.ProductDto;
import ua.hillelit.lms.model.Order;
import ua.hillelit.lms.model.Product;
import ua.hillelit.lms.repository.OrderRepository;
import ua.hillelit.lms.repository.ProductRepository;

import java.util.List;

/**
 * {@link ProductService} is a class for creation a product and getting products.
 *
 * @author Dmytro Trotsenko on 1/10/23
 */

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    /**
     * Create new entity {@link Product} and save row with data in database
     *
     * @param productDto object with data
     * @return productDto
     */
    public ProductDto createProduct(ProductDto productDto){

        Product product = objectMapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        productDto.setId(product.getId());

        return productDto;
    }

    /**
     * Getting the product by id.
     *
     * @param id product id
     * @return {@link Product}
     */
    public Product getProduct(Integer id){
        return productRepository.getProductById(id);
    }

    /**
     * Getting all products from database.
     *
     * @return all products
     */
    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

}
