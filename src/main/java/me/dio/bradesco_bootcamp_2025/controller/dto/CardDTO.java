package me.dio.bradesco_bootcamp_2025.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CardDTO {
    private Long id;
    private String number;
    private BigDecimal limit;
}
