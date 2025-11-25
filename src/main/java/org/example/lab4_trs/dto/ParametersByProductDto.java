package org.example.lab4_trs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ParametersByProductDto {

    private ProductMainFields product;

    private List<ParameterWithValue> parameters;

    public ParametersByProductDto() {

    }
}
