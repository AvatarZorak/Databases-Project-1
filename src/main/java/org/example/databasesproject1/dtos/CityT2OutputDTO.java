package org.example.databasesproject1.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.databasesproject1.model.Airport;
import org.example.databasesproject1.model.City;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class CityT2OutputDTO {
    private Long id;
    private String name;
    private Set<AirportT2OutputDTO> airports;

    public CityT2OutputDTO() {}

    public CityT2OutputDTO(City c) {
        this.id = c.getId();
        this.name = c.getName();
        this.airports = c.getAirports().stream().map(AirportT2OutputDTO::new).collect(Collectors.toSet());
    }
}
