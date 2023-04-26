package ca.BaigiamasisBE.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "shoppingCart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Helmet> helmets = new HashSet<>();
}
