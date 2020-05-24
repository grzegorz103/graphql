package com.system.car.api.rest.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotorcycleIn {

    @Positive
    private Long brandId;

    @NotBlank
    @Length(max = 1000)
    private String model;

    @Positive
    private Integer year;

    @NotNull
    private List<String> images;

    @Length(max = 1000)
    private String info;

}
