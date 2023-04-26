package ca.BaigiamasisBE.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "shoppingCart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "helmet_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Helmet helmet;
}
