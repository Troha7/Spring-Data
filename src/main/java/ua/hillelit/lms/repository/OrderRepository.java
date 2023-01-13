package ua.hillelit.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.hillelit.lms.model.Order;


/**
 * {@link OrderRepository} is a class for getting orders from the entity {@link Order}.
 *
 * @author Dmytro Trotsenko on 1/10/23
 */

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    /**
     * Getting the order by id.
     *
     * @param id order id
     * @return {@link Order} object
     */
    Order getOrderById(Integer id);

}
