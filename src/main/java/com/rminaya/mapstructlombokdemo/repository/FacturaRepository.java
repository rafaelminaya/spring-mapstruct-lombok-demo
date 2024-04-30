package com.rminaya.mapstructlombokdemo.repository;

import com.rminaya.mapstructlombokdemo.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
