package com.gustavosantospro.softgu.model;


import com.gustavosantospro.softgu.model.user.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "produto", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    private String description;
    @Column(nullable = false)
    private Float price;

   /*@ManyToOne
    private Category category;
    private Integer amount;

    @JoinColumn(nullable = false, name = "user_id")
    @ManyToOne
    private Usuario username;
    private LocalDateTime creationDateHour;*/

}
