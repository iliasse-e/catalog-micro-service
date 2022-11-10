package org.sid.entities.product;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;
import org.sid.entities.category.Category;

@Entity @Table(name = "product") @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String designation;
	private int price;
	private int quantity;
	private String dimensions;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Category category;
}
