package ua.hillelit.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.hillelit.lms.model.Product;

/**
 * {@link ProductRepository} is a class for getting products from the entity {@link Product}.
 *
 * @author Dmytro Trotsenko on 1/10/23
 */

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    /**
     * Getting the product by id.
     *
     * @param id product id
     * @return {@link Product} object
     */
    Product getProductById(Integer id);
}
