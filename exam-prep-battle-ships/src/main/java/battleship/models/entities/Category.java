package battleship.models.entities;

import battleship.models.enums.ShipCategory;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(nullable = false,unique = true)
    @Enumerated(EnumType.STRING)
    private ShipCategory name;
    @Column(columnDefinition = "TEXT")
    private String description;
}
