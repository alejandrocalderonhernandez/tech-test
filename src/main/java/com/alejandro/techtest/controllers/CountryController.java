package com.alejandro.techtest.controllers;

import com.alejandro.techtest.models.dtos.CountryDto;
import com.alejandro.techtest.models.dtos.SortEnum;
import com.alejandro.techtest.services.definitions.CountriesFacade;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "country")
public class CountryController {

    private final CountriesFacade countriesFacade;

    @GetMapping
    public ResponseEntity<List<CountryDto>> get(@RequestParam(required = false) SortEnum sort) {
        return ResponseEntity.ok(this.countriesFacade.getCounties(sort));
    }
}
