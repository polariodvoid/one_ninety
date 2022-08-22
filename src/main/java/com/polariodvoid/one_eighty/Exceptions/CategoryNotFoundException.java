package com.polariodvoid.one_eighty.Exceptions;

public class CategoryNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
// Compare this snippet from ShopmeCommon/src/main/java/com/shopme/common/exception/ProductNotFoundException.java:
