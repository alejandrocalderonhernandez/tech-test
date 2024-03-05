package com.alejandro.techtest.services;

import com.alejandro.techtest.components.CountriesClient;
import com.alejandro.techtest.models.dtos.CountryDto;
import com.alejandro.techtest.models.dtos.SortEnum;
import com.alejandro.techtest.services.definitions.CountriesFacade;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@AllArgsConstructor
@Service
public class RestCountriesService implements CountriesFacade {

    private final CountriesClient countriesClient;

    @Override
    public List<CountryDto> getCounties(@Nullable SortEnum sort) {

        final var countriesResponse = this.countriesClient.getAllCountries().getBody();

        if (Objects.nonNull(countriesResponse)) {
            if (Objects.isNull(sort)) {
                return Arrays.asList(countriesResponse);
            }

            return (sort.equals(SortEnum.COUNTRY)) ?
                    Arrays.stream(countriesResponse).
                            sorted(Comparator.comparing(CountryDto::getCountry)).toList() :
                    Arrays.stream(countriesResponse).
                            sorted(Comparator.comparing(CountryDto::getPopulation)).toList();
        }

        throw new NoSuchElementException();
    }
}
