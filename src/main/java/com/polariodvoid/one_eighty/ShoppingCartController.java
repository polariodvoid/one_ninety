package com.polariodvoid.one_eighty;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class ShoppingCartController {
    @Autowired
    private ControllerHelper controllerHelper;
    @Autowired private ShoppingCartService cartService;


    @GetMapping("/cart")
    public String viewCart(Model model, HttpServletRequest request) {
        Customer customer = controllerHelper.getAuthenticatedCustomer(request);
        List<CartItem> cartItems = cartService.listCartItems(customer);

        float estimatedTotal = 0.0F;

        for (CartItem item : cartItems) {
            estimatedTotal += item.getSubtotal();
        }

        return "cart/shopping_cart";
    }
}
