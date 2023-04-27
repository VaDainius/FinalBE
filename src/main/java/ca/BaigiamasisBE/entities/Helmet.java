package ca.BaigiamasisBE.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "helmets")
@RequiredArgsConstructor
@Data
@NoArgsConstructor
public class Helmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String type;

    @NonNull
    private String manufacturer;

    @NonNull
    private String model;

    @NonNull
    private int size;

    @NonNull
    private String status;

    @NonNull
    private String color;

    @NonNull
    @Lob
    private String itemDescription;

    @NonNull
    private int price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cart_helmet",
            joinColumns = @JoinColumn(name = "helmet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<User> user = new HashSet<>();




    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shopingCart_id", nullable = false)
    private ShoppingCart shoppingCart;

}
