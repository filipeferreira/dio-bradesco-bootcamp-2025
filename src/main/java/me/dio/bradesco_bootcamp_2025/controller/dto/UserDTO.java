package me.dio.bradesco_bootcamp_2025.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private AccountDTO account;
    private CardDTO card;
    private List<FeatureDTO> features;
    private List<NewsDTO> news;
}
