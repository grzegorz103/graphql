package com.system.car.api.rest.dto.in;

import com.system.car.models.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarIn {

    @Positive
    private Long brandId;

    @NotBlank
    @Length(max = 1000)
    private String model;

    @Positive
    private Integer year;

    @NotNull
    @Size(max = 5)
    private List<String> images;

    @NotBlank
    @Length(max = 1000)
    private String info;

}
