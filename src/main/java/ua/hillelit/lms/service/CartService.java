package ua.hillelit.lms.service;

import lombok.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.hillelit.lms.model.Product;
import ua.hillelit.lms.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link CartService} is a class for storing a list of products for this cart,
 * and for adding and removing products from the cart.
 *
 * @author Dmytro Trotsenko on 1/12/23
 */
@Value
@Service
@Scope("prototype")
public class CartService {

    ProductRepository productRepository;
    List<Product> products = new ArrayList<>();

    /**
     * Adding product to the cart.
     *
     * @param id id product id
     */
    public void addProduct(Integer id) {
        products.add(productRepository.getProductById(id));
    }

    /**
     * Removing the product from the cart.
     *
     * @param id product id
     */
    public void removeProduct(Integer id) {
        products.remove(productRepository.getProductById(id));
    }

    /**
     * Calculation of the total cost of products.
     *
     * @return total price of products
     */
    public Double totalPrice() {
        return products.stream()
                .map(Product::getCost)
                .reduce(0.0, Double::sum);
    }

}
