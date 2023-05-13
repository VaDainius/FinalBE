package ca.BaigiamasisBE.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class CartHelmetRequest {
    private ShoppingCart cart;
    private Helmet helmet;
}
