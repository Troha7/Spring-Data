package ua.hillelit.lms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.hillelit.lms.dto.OrderDto;
import ua.hillelit.lms.model.Order;
import ua.hillelit.lms.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * {@link OrderService} is a class for creation an order and getting orders.
 *
 * @author Dmytro Trotsenko on 1/10/23
 */

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;

    /**
     * Create new entity {@link Order} and save row with data in database
     *
     * @param orderDto object with data
     * @return orderDto
     */
    public OrderDto createOrder(OrderDto orderDto){

        Order order = objectMapper.convertValue(orderDto, Order.class);
        orderRepository.save(order);
        orderDto.setId(order.getId());

        return orderDto;
    }

    /**
     * Getting the order by id.
     *
     * @param id order id
     * @return {@link Order}
     */
    public Order getOrder(Integer id) {
        return orderRepository.getOrderById(id);
    }

    /**
     * Getting all orders from database.
     *
     * @return all orders
     */
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    /**
     * Create an order from the cart and add order to the database.
     *
     * @param id          order id
     * @param cartService cart with products
     */
    public void addOrder(Integer id, CartService cartService){
        createOrder(new OrderDto(id, LocalDate.now(),cartService.totalPrice(),cartService.getProducts()));
    }

    /**
     * Remove order from database.
     *
     * @param id order id
     */
    public void removeOrder(Integer id){
        orderRepository.deleteById(id);
    }

}
