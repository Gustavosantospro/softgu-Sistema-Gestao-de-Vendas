package com.gustavosantospro.softgu.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
/*@SequenceGenerator(name = "Client_seq", sequenceName = "Client_seq", allocationSize = 1, initialValue = 1)
    nesse caso, criaria uma sequencia para ser utilizada a nível de classe, cada vez q fosse instaciada*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String adress;
}
