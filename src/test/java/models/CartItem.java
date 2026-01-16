package models;

import java.math.BigDecimal;

public record CartItem(String product, int quantity, BigDecimal price) {}
