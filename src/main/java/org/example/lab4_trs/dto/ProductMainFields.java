package org.example.lab4_trs.dto;

import java.time.LocalDate;

public record ProductMainFields(
        Long productId,
        String productName,
        String productDescription,
        LocalDate productReleaseDate,
        Long productGroupId,
        String productGroupName
)
{}
