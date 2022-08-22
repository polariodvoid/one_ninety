package com.polariodvoid.one_eighty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class ControllerHelper {
    @Autowired
    private UserService userService;

    public User getAuthenticatedUser(HttpServletRequest request) {
        // String email = request.getQueryString(); //email
        String email = "abcd@gmail.com";
        return userService.findByEmail(email);
    }
}
