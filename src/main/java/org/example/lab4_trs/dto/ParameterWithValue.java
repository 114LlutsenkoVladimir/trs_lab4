package org.example.lab4_trs.dto;

public record ParameterWithValue(
        Long parameterId,
        String parameterName,
        String parameterUnit,
        String parameterValue
) {}
