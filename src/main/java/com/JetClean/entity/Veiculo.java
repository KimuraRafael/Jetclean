package com.JetClean.entity;

import com.JetClean.enums.TipoVeiculo;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private TipoVeiculo tipoVeiculo;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private String modelo;
}
