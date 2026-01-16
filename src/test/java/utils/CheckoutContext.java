package utils;

import models.CartItem;

import java.util.List;

public class CheckoutContext {
    private static List<CartItem> cartItems;

    public static void setCartItems(List<CartItem> items) {
        cartItems = items;
    }

    public static List<CartItem> getCartItems() {
        return cartItems;
    }
}
