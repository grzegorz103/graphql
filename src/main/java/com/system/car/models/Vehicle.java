package com.system.car.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    // @JsonManagedReference
    @NotNull
    private Brand brand;

    @NotNull
    @NotBlank
    @Length(max = 1000)
    private String model;

    @Positive
    private Integer year;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> images;

    @Column(name = "info", length = 10000)
    @NotBlank
    @Length(max = 1000)
    private String info;

}
