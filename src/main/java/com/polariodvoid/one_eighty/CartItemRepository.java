package com.polariodvoid.one_eighty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.polariodvoid.one_eighty.CartItem;
import com.polariodvoid.one_eighty.User;
import com.polariodvoid.one_eighty.Product;
import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
    List<CartItem> findByUser(User user);
    public CartItem findByUserAndProduct(User user, Product product);

    @Modifying
    @Query("UPDATE CartItem c SET c.quantity = ?1 WHERE c.user.id = ?2 AND c.product.id = ?3")
    public void updateQuantity(Integer quantity, Integer userId, Integer productId);

    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.user.id = ?1 AND c.product.id = ?2")
    public void deleteByCustomerAndProduct(Integer customerId, Integer productId);

    @Modifying
    @Query("DELETE CartItem c WHERE c.user.id = ?1")
    public void deleteByCustomer(Integer userId);

}


