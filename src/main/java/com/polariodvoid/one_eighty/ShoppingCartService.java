package com.polariodvoid.one_eighty;

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

    public List<CartItem> listCartItems(Customer customer) {
        return cartRepo.findByUser(user);
    }

    public float updateQuantity(Integer productId, Integer quantity, Customer customer) {
        cartRepo.updateQuantity(quantity, customer.getId(), productId);
        Product product = productRepo.findById(productId).get();
        float subtotal = product.getDiscountPrice() * quantity;
        return subtotal;
    }

    public void removeProduct(Integer productId, Customer customer) {
        cartRepo.deleteByCustomerAndProduct(customer.getId(), productId);
    }

    public void deleteByCustomer(Customer customer) {
        cartRepo.deleteByCustomer(customer.getId());
    }
}
