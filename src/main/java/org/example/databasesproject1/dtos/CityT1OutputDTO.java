package org.example.databasesproject1.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.databasesproject1.model.City;

@Getter
@Setter
public class CityT1OutputDTO {
    private Long id;
    private String name;
    private CountryT1OutputDTO country;

    public CityT1OutputDTO() {}
    public CityT1OutputDTO(City c) {
        this.id = c.getId();
        this.name = c.getName();
        this.country = new CountryT1OutputDTO(c.getCountry());
    }
}
