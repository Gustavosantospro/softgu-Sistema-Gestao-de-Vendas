package com.gustavosantospro.softgu.model;


import com.gustavosantospro.softgu.model.user.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Float totalSale;
    @Column(nullable = false)
    private Float amountPaid;
    @Column(nullable = false)
    private Float change;
    @Column(nullable = false)
    private Float discount;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Client client;

    @JoinColumn(nullable = false)
    @OneToOne
    private Usuario username;
    private LocalDateTime criationDateHour;
    private LocalDateTime update;

    /*@JoinColumn(nullable = false)
    private HashMap<String, SalesDetails> salesDetails;*/

}
