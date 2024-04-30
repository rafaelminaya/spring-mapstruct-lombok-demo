package com.rminaya.mapstructlombokdemo.repository;

import com.rminaya.mapstructlombokdemo.entity.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle, Long> {
}
