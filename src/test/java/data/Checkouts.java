package data;

import models.Shipping;
import models.Payment;

public class Checkouts {
    public static final Shipping VALID_SHIPPING =
            new Shipping(
                    "Rebecca Winter",
                    "Mandorley 112",
                    "Truro",
                    "89750",
                    "Cornwall",
                    "United Kingdom"
            );

    public static final Payment VALID_PAYMENT =
            new Payment(
                    "Rebecca Winter",
                    "3258125675687891",
                    "0325",
                    "123"
            );

    private Checkouts() {}
}
