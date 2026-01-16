package transformers;

import io.cucumber.java.DataTableType;
import models.CartItem;

import java.math.BigDecimal;
import java.util.Map;

public class DataTableTransformers {

    @DataTableType
    public CartItem cartItemTransformer(Map<String, String> row) {
        return new CartItem(
                row.get("product"),
                Integer.parseInt(row.get("quantity")),
                new BigDecimal(row.get("price"))
        );
    }
}
