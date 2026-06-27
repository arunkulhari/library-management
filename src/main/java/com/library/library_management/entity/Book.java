package com.library.library_management.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name ="books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "TIlte cannot be empty")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "author cant be empty")
    @Column(nullable = false)
    private String author;

    @NotBlank(message = "genre cant be empty")
    private String genre;

    @Min(value=0, message="price cannot be neg")
    private Double price;

    @Min(value=1, message = "at least 1 copy must be there")
    @Column(nullable = false)
    private Integer totalCopies;

    @Column(nullable = false)
    private Integer availableCopies;

    private boolean active = true;

}
