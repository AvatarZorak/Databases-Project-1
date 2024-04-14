package org.example.databasesproject1.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.databasesproject1.model.Airport;

@Getter
@Setter
public class AirportT1OutputDTO {
    private Long id;
    private String name;
    private CityT1OutputDTO city;
    private String iataCode;
    private String icaoCode;
    private Double latitude;
    private Double longitude;

    public AirportT1OutputDTO() {}
    public AirportT1OutputDTO(Airport a) {
        this.id = a.getId();
        this.name = a.getName();
        this.city = new CityT1OutputDTO(a.getCity());
        this.iataCode = a.getIataCode();
        this.icaoCode = a.getIcaoCode();
        this.latitude = a.getLatitude();
        this.longitude = a.getLongitude();
    }
}
