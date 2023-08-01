package com.gustavosantospro.softgu.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(nullable = false)
    private Sale sales;

    @OneToOne
    @JoinColumn(nullable = false)
    private Product product;
    @JoinColumn(nullable = false)
    private int qtd;
    @JoinColumn(nullable = false)
    private BigDecimal discount;
    @JoinColumn(nullable = false)
    private BigDecimal total;
}
