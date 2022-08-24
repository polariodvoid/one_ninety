package com.polariodvoid.one_eighty.product;


import com.polariodvoid.one_eighty.Model.Product;
import com.polariodvoid.one_eighty.Model.ProductDetail;
import com.polariodvoid.one_eighty.OneEightyApplication;
import com.polariodvoid.one_eighty.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.polariodvoid.one_eighty.Model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import com.polariodvoid.one_eighty.SprintBootH2Application;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
//@ExtendWith(SpringExtension.class)
//@Transactional
//@SpringBootTest(classes)
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindByAlias() {
        Product product = getProduct();
        productRepository.save(product);
        Product result = productRepository.findByAlias(product.getAlias());
        assertEquals(product.getAlias(), result.getAlias());
    }

    private Product getProduct() {
        Product product = new Product();
        product.setId(1);
        product.setName("Mahesh");
        product.setAlias("iphone");
        return product;
    }
}
