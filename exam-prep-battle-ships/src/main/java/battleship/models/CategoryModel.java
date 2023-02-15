package battleship.models;

import battleship.models.enums.ShipCategory;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryModel {
    private Long id;
    private ShipCategory name;
    private String description;
}
