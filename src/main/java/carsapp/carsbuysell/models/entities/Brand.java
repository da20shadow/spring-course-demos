package carsapp.carsbuysell.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column
    private LocalDateTime created;
    @Column
    private LocalDateTime modified;

}
