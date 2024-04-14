package org.example.databasesproject1.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.databasesproject1.AirportFilter;
import org.example.databasesproject1.model.Airport;

@Getter
@Setter
public class AirportT2OutputDTO {
    private Long id;
    private String name;
    private String iataCode;
    private String icaoCode;
    private Double latitude;
    private Double longitude;

    public AirportT2OutputDTO() {}

    public AirportT2OutputDTO(Airport a) {
        this.id = a.getId();
        this.name = a.getName();
        this.iataCode = a.getIataCode();
        this.icaoCode = a.getIcaoCode();
        this.latitude = a.getLatitude();
        this.longitude = a.getLongitude();
    }
}
