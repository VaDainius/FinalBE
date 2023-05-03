package ca.BaigiamasisBE.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Helmets {

    @NonNull
    private List<Helmet> helmets;

    public static Helmets of (List<Helmet> helmets) {
        return new Helmets(helmets);
    }
}
