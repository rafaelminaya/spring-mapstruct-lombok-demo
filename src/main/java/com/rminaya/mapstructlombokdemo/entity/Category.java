package com.rminaya.mapstructlombokdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "category")
public class Category {

    @Id
    private Long id;
    private String name;
    private Boolean status;

}
