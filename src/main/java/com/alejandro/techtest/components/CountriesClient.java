package com.alejandro.techtest.components;

import com.alejandro.techtest.models.dtos.CountryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class CountriesClient {

    private final RestTemplate restTemplate;
    private final String uri;

    public CountriesClient() {
        this.restTemplate = new RestTemplate();
        this.uri = "https://restcountries.com/v3.1/all";
    }

    public ResponseEntity<CountryDto[]> getAllCountries() {
        log.info("making request {}", this.uri);
        return this.restTemplate
                .getForEntity(this.uri, CountryDto[].class);
    }
}
