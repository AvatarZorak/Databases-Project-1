package org.example.databasesproject1.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.databasesproject1.model.Country;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class CountryT2OutputDTO {
    private String name;
    private String iso2CountryCode;
    private String iso3CountryCode;
    private Set<CityT2OutputDTO> cities;

    public CountryT2OutputDTO() {}

    public CountryT2OutputDTO(Country c) {
        this.name = c.getName();
        this.iso2CountryCode = c.getIso2CountryCode();
        this.iso3CountryCode = c.getIso3CountryCode();
        this.cities = c.getCities().stream().map(CityT2OutputDTO::new).collect(Collectors.toSet());
    }
}
