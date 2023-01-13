package ua.hillelit.lms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * {@link Product}  is a product entity class.
 *
 * @author Dmytro Trotsenko on 1/10/23
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(schema = "my_store")
@NamedQueries(@NamedQuery(name = "Product.getByCost", query = "from Product u where u.cost = ?1"))
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Double cost;


}
