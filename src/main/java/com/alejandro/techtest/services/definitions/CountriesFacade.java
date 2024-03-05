package com.alejandro.techtest.services.definitions;

import com.alejandro.techtest.models.dtos.CountryDto;
import com.alejandro.techtest.models.dtos.SortEnum;
import jakarta.annotation.Nullable;

import java.util.List;

public interface CountriesFacade {

    List<CountryDto> getCounties(@Nullable SortEnum sort);
}
