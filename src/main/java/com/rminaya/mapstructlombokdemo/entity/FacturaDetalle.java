package com.rminaya.mapstructlombokdemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "factura_detalle")
public class FacturaDetalle {

    @Id
    private Long id;
    private Integer cantidad;
    private BigDecimal precio;
    private String producto;
    @ManyToOne
    @JoinColumn(name = "factura_id")
    @ToString.Exclude
    private Factura factura;
}
