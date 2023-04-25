package ca.BaigiamasisBE.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

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
    private String description;


}
