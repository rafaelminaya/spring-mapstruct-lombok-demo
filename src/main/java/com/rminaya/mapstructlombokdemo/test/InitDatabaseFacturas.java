package com.rminaya.mapstructlombokdemo.test;

import com.rminaya.mapstructlombokdemo.dto.FacturaDto;
import com.rminaya.mapstructlombokdemo.entity.Factura;
import com.rminaya.mapstructlombokdemo.mapper.FacturaMapper;
import com.rminaya.mapstructlombokdemo.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitDatabaseFacturas {

    @Autowired
    private FacturaRepository facturaRepository;

    private FacturaMapper facturaMapper = FacturaMapper.INSTANCE;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            List<Factura> facturas = this.facturaRepository.findAll();
            System.out.println("------------------- FACTURAS -------------------");
            facturas.forEach(System.out::println);

            System.out.println("------------------- FACTURAS DTO -------------------");
            List<FacturaDto> facturasDto = this.facturaMapper.toFacturaDtoList(facturas);
            facturasDto.forEach(System.out::println);

            System.out.println("------------------- MAPPED FACTURAS -------------------");
            List<Factura> mappedFacturas = this.facturaMapper.toEntityList(facturasDto);
            mappedFacturas.forEach(System.out::println);
        };
    }
}
