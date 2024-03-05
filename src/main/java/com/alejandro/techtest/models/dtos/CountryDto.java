package com.alejandro.techtest.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDto {

    @JsonProperty(value = "name.common")
    private String country;
    private List<String> capital;
    private String continent;
    private Long population;
    private Map<String, CurrencyDetailDto> currencies;
}
