package me.dio.bradesco_bootcamp_2025.domain.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "tb_news")
public class News extends BaseItem {

}
