package com.example.productmanagement;

import com.example.productmanagement.entity.Category;
import com.example.productmanagement.entity.Product;
import com.example.productmanagement.repository.CategoryRepository;
import com.example.productmanagement.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProductManagementApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
		assertThat(categoryRepository).isNotNull();
		assertThat(productRepository).isNotNull();
	}

	@Test
	void testCategoryAndProductCreation() {
		Category electronics = Category.builder()
				.name("Electronics")
				.description("Gadgets and electronic devices")
				.build();
		Category savedCategory = categoryRepository.save(electronics);

		assertThat(savedCategory.getId()).isNotNull();

		Product laptop = Product.builder()
				.name("High-Performance Laptop")
				.description("16-inch display, 32GB RAM")
				.price(new BigDecimal("1299.99"))
				.stockQuantity(10)
				.category(savedCategory)
				.build();

		Product savedProduct = productRepository.save(laptop);

		assertThat(savedProduct.getId()).isNotNull();
		assertThat(savedProduct.getCategory().getName()).isEqualTo("Electronics");
	}
}
