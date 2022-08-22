package com.polariodvoid.one_eighty.shoppingcart;

import com.polariodvoid.one_eighty.CartItem;
import com.polariodvoid.one_eighty.CartItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class CartItemRepositoryTests {
@Autowired private CartItemRepository repo;
@Autowired private TestEntityManager entityManager;

@Test
    public void testSaveItem() {
        //CartItem item = new CartItem();
        //item.setQuantity(1);
        //item.setProduct(new Product());
        //item.setCart(new Cart());
        //entityManager.persist(item);
        //entityManager.flush();
        //repo.save(item);
    }
}
