package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "printers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Printers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "operation_system")
    private  String operation_system;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Impressions> impressionsList;

}
