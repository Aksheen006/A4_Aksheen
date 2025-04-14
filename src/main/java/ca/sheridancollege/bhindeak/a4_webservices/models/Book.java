package ca.sheridancollege.bhindeak.a4_webservices.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String authorName;
    private Double price;
    private Integer quantity;

    private boolean edit; // must be true to allow updates
}
