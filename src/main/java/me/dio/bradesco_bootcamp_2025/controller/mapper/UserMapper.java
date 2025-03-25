package me.dio.bradesco_bootcamp_2025.controller.mapper;

import lombok.RequiredArgsConstructor;
import me.dio.bradesco_bootcamp_2025.controller.dto.AccountDTO;
import me.dio.bradesco_bootcamp_2025.controller.dto.CardDTO;
import me.dio.bradesco_bootcamp_2025.controller.dto.FeatureDTO;
import me.dio.bradesco_bootcamp_2025.controller.dto.NewsDTO;
import me.dio.bradesco_bootcamp_2025.controller.dto.UserDTO;
import me.dio.bradesco_bootcamp_2025.domain.model.Account;
import me.dio.bradesco_bootcamp_2025.domain.model.Card;
import me.dio.bradesco_bootcamp_2025.domain.model.Feature;
import me.dio.bradesco_bootcamp_2025.domain.model.News;
import me.dio.bradesco_bootcamp_2025.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public UserDTO toDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .account(toAccountDto(user.getAccount()))
                .card(toCardDto(user.getCard()))
                .features(toFeatureDtoList(user.getFeatures()))
                .news(toNewsDtoList(user.getNews()))
                .build();
    }

    public User toEntity(UserDTO userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .account(toAccountEntity(userDto.getAccount()))
                .card(toCardEntity(userDto.getCard()))
                .features(toFeatureEntityList(userDto.getFeatures()))
                .news(toNewsEntityList(userDto.getNews()))
                .build();
    }

    private AccountDTO toAccountDto(Account account) {
        if (account == null) return null;
        return AccountDTO.builder()
                .id(account.getId())
                .number(account.getNumber())
                .agency(account.getAgency())
                .balance(account.getBalance())
                .limit(account.getLimit())
                .build();
    }

    private Account toAccountEntity(AccountDTO accountDto) {
        if (accountDto == null) return null;
        return Account.builder()
                .id(accountDto.getId())
                .number(accountDto.getNumber())
                .agency(accountDto.getAgency())
                .balance(accountDto.getBalance())
                .limit(accountDto.getLimit())
                .build();
    }

    private CardDTO toCardDto(Card card) {
        if (card == null) return null;
        return CardDTO.builder()
                .id(card.getId())
                .number(card.getNumber())
                .limit(card.getLimit())
                .build();
    }

    private Card toCardEntity(CardDTO cardDto) {
        if (cardDto == null) return null;
        return Card.builder()
                .id(cardDto.getId())
                .number(cardDto.getNumber())
                .limit(cardDto.getLimit())
                .build();
    }

    private List<FeatureDTO> toFeatureDtoList(List<Feature> features) {
        if (features == null) return null;
        return features.stream()
                .map(feature -> FeatureDTO.builder()
                        .id(feature.getId())
                        .icon(feature.getIcon())
                        .description(feature.getDescription())
                        .build())
                .collect(Collectors.toList());
    }

    private List<Feature> toFeatureEntityList(List<FeatureDTO> featureDtos) {
        if (featureDtos == null) return null;
        return featureDtos.stream()
                .map(dto -> Feature.builder()
                        .id(dto.getId())
                        .icon(dto.getIcon())
                        .description(dto.getDescription())
                        .build())
                .collect(Collectors.toList());
    }

    private List<NewsDTO> toNewsDtoList(List<News> news) {
        if (news == null) return null;
        return news.stream()
                .map(item -> NewsDTO.builder()
                        .id(item.getId())
                        .icon(item.getIcon())
                        .description(item.getDescription())
                        .build())
                .collect(Collectors.toList());
    }

    private List<News> toNewsEntityList(List<NewsDTO> newsDtos) {
        if (newsDtos == null) return null;
        return newsDtos.stream()
                .map(dto -> News.builder()
                        .id(dto.getId())
                        .icon(dto.getIcon())
                        .description(dto.getDescription())
                        .build())
                .collect(Collectors.toList());
    }
}
