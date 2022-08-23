package com.polariodvoid.one_eighty.Service;

import com.polariodvoid.one_eighty.*;
import com.polariodvoid.one_eighty.Model.CartItem;
import com.polariodvoid.one_eighty.Model.Product;
import com.polariodvoid.one_eighty.Model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShoppingCartService {
    @Autowired
    private CartItemRepository cartRepo;
    @Autowired private ProductRepository productRepo;

    public Integer addProduct(Integer productId, Integer quantity, User user)
            throws ShoppingCartException {
        Integer updatedQuantity = quantity;
        Product product = new Product(productId);

        CartItem cartItem = cartRepo.findByUserAndProduct(user, product);

        if (cartItem != null) {
            updatedQuantity = cartItem.getQuantity() + quantity;

            if (updatedQuantity > 5) {
                throw new ShoppingCartException("Could not add more " + quantity + " item(s)"
                        + " because there's already " + cartItem.getQuantity() + " item(s) "
                        + "in your shopping cart. Maximum allowed quantity is 5.");
            }
        } else {
            cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
        }

        cartItem.setQuantity(updatedQuantity);

        cartRepo.save(cartItem);

        return updatedQuantity;
    }

    public List<CartItem> listCartItems(User user) {
        return cartRepo.findByUser(user);
    }

    public float updateQuantity(Integer productId, Integer quantity, User user) {
        cartRepo.updateQuantity(quantity, user.getId(), productId);
        Product product = productRepo.findById(productId);
        float subtotal = product.getDiscountPrice() * quantity;
        return subtotal;
    }

    public void removeProduct(Integer productId, User user) {
        cartRepo.deleteByCustomerAndProduct(user.getId(), productId);
    }

    public void deleteByUser(User user) {
        cartRepo.deleteByCustomer(user.getId());
    }
}
