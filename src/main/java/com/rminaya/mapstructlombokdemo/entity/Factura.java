package com.rminaya.mapstructlombokdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    private Long id;
    private String numero;
    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "factura")
    private List<FacturaDetalle> detalles;
}
