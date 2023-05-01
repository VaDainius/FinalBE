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
    private int id;

    @Column
    @NonNull
    private String type;

    @NonNull
    @Column
    private String manufacturer;

    @NonNull
    @Column
    private String model;

    @NonNull
    @Column
    private String  size;

    @NonNull
    @Column
    private String status;

    @NonNull
    @Column
    private String color;

    @NonNull
    @Column
    @Lob
    private String itemDescription;

    @NonNull
    @Column
    private int price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_helmet",
            joinColumns = @JoinColumn(name = "helmet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<User> user = new HashSet<>();



}
