package com.system.car.api.rest.dto.in;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class BrandIn {

    @NotBlank
    @Length(max=250)
    private String name;

}
