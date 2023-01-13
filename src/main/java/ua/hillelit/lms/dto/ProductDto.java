package ua.hillelit.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {@link ProductDto}  is a product data class.
 *
 * @author Dmytro Trotsenko on 1/10/23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;

    private String name;

    private Double cost;

}
