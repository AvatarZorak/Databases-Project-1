package org.example.databasesproject1.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.databasesproject1.model.Country;

@Getter
@Setter
public class CountryT1OutputDTO {
    private String name;
    private String iso2CountryCode;
    private String iso3CountryCode;

    public CountryT1OutputDTO() {}
    public CountryT1OutputDTO(Country c) {
        this.name = c.getName();
        this.iso2CountryCode = c.getIso2CountryCode();
        this.iso3CountryCode = c.getIso3CountryCode();
    }
}
