package models;

public record Payment(
        String cardHolderName,
        String cardNumber,
        String expiryDate,
        String securityCode
) {}
