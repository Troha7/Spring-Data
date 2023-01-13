package ua.hillelit.lms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.hillelit.lms.dto.ProductDto;
import ua.hillelit.lms.service.CartService;
import ua.hillelit.lms.service.OrderService;
import ua.hillelit.lms.service.ProductService;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class StoreApp {

    private final ProductService productService;
    private final OrderService orderService;
    private final CartService cartService1;
    private final CartService cartService2;

    public static void main(String[] args) {
        SpringApplication.run(StoreApp.class, args);
    }

    /**
     * Run application after all initialization steps.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void onInit() {

        ProductDto milk = new ProductDto(1, "Milk", 40.0);
        ProductDto bread = new ProductDto(2, "Bread", 18.50);
        ProductDto cola = new ProductDto(3, "Coca-Cola", 50.0);
        ProductDto sugar = new ProductDto(4, "Sugar", 35.0);
        productService.createProduct(milk);
        productService.createProduct(bread);
        productService.createProduct(cola);
        productService.createProduct(sugar);
        log.info("All products in repository: {}", productService.getAllProducts());

        cartService1.addProduct(1);
        cartService1.addProduct(3);
        orderService.addOrder(1, cartService1);

        cartService2.addProduct(2);
        cartService2.addProduct(4);
        orderService.addOrder(2, cartService2);

//        orderService.removeOrder(1);
    }

}
