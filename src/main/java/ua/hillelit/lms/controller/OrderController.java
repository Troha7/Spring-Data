package ua.hillelit.lms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.hillelit.lms.model.Order;
import ua.hillelit.lms.service.OrderService;

import java.util.List;

/**
 * {@link OrderController} is a class for making restful web service.
 * Main path "/api" and port "8080".
 *
 * @author Dmytro Trotsenko on 1/12/23
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    /**
     * Create GET request for getting order by id.
     * Path to order "/order/{id}".
     *
     * @param id order id
     * @return {@link Order}
     */
    @GetMapping(value = "/order/{id}")
    public Order getOrder(@PathVariable Integer id) {
        return orderService.getOrder(id);
    }

    /**
     * Create GET request for getting all orders.
     * Path to all orders "/orders".
     *
     * @return all orders
     */
    @GetMapping(value = "/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

}
