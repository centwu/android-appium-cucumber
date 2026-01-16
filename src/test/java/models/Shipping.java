package models;

public record Shipping(
        String fullName,
        String addressLine1,
        String city,
        String zipCode,
        String state,
        String country
) {}
