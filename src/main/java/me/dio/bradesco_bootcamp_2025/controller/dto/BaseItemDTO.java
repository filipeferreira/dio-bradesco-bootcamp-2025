package me.dio.bradesco_bootcamp_2025.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseItemDTO {
    private Long id;
    private String icon;
    private String description;
}
