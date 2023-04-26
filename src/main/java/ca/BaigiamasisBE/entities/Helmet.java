package ca.BaigiamasisBE.entities;

import jakarta.persistence.*;
import lombok.*;


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
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    private void setUser(User user) {
        this.user = user;
    }


}
