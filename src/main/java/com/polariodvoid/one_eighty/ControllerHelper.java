package com.polariodvoid.one_eighty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class ControllerHelper {
    @Autowired
    private UserService userService;

    public Customer getAuthenticatedCustomer(HttpServletRequest request) {
        String email = Utility.getEmailOfAuthenticatedCustomer(request);
        return userService.findByEmail(email);
    }
}
