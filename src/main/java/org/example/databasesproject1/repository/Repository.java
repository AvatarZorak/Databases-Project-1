package org.example.databasesproject1.repository;

import jakarta.persistence.EntityManager;
import org.example.databasesproject1.AirportFilter;
import org.example.databasesproject1.dtos.AirportT1OutputDTO;
import org.example.databasesproject1.dtos.AirportT2OutputDTO;
import org.example.databasesproject1.dtos.CountryT2OutputDTO;
import org.example.databasesproject1.model.Airport;
import org.example.databasesproject1.model.Country;

import org.springframework.data.domain.Pageable;
import java.util.LinkedList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    private final EntityManager entityManager;

    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<AirportT1OutputDTO> getAllAirports() {
        return this.entityManager.createQuery("SELECT a FROM Airport a JOIN FETCH a.city cit JOIN FETCH cit.country cou", Airport.class)
                .getResultList().stream().map(AirportT1OutputDTO::new).toList();
    }

    public List<?> getFilteredAirports(boolean countryAsRoot, AirportFilter airportFilter) {
        if(countryAsRoot) {
            return this.entityManager.createQuery("SELECT cou FROM Country cou JOIN FETCH cou.cities cit JOIN FETCH cit.airports a WHERE cou.iso2CountryCode IN ?1 OR cit.id IN ?2 OR a.icaoCode IN ?3 OR a.name IN ?4", Country.class)
                    .setParameter(1, airportFilter.countryIso2Codes())
                    .setParameter(2, airportFilter.cityIds())
                    .setParameter(3, airportFilter.airportIcaoCodes())
                    .setParameter(4, airportFilter.airportNames())
                    .getResultList().stream().map(CountryT2OutputDTO::new).toList();
        } else {
            return this.entityManager.createQuery("SELECT a FROM Airport a JOIN FETCH a.city cit JOIN FETCH cit.country cou WHERE cou.iso2CountryCode IN ?1 OR cit.id IN ?2 OR a.icaoCode IN ?3 OR a.name IN ?4", Airport.class)
                    .setParameter(1, airportFilter.countryIso2Codes())
                    .setParameter(2, airportFilter.cityIds())
                    .setParameter(3, airportFilter.airportIcaoCodes())
                    .setParameter(4, airportFilter.airportNames())
                    .getResultList().stream().map(AirportT1OutputDTO::new).toList();
        }
    }

    public List<?> getFilteredAirportsPageable(boolean countryAsRoot, AirportFilter airportFilter, Pageable pageable) {
        if(countryAsRoot) {
            return this.entityManager.createQuery("SELECT cou FROM Country cou JOIN FETCH cou.cities cit JOIN FETCH cit.airports a WHERE cou.iso2CountryCode IN ?1 OR cit.id IN ?2 OR a.icaoCode IN ?3 OR a.name IN ?4", Country.class)
                    .setParameter(1, airportFilter.countryIso2Codes())
                    .setParameter(2, airportFilter.cityIds())
                    .setParameter(3, airportFilter.airportIcaoCodes())
                    .setParameter(4, airportFilter.airportNames())
                    .setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
                    .setMaxResults(pageable.getPageSize())
                    .getResultList().stream().map(CountryT2OutputDTO::new).toList();
        } else {
            return this.entityManager.createQuery("SELECT a FROM Airport a JOIN FETCH a.city cit JOIN FETCH cit.country cou WHERE cou.iso2CountryCode IN ?1 OR cit.id IN ?2 OR a.icaoCode IN ?3 OR a.name IN ?4", Airport.class)
                    .setParameter(1, airportFilter.countryIso2Codes())
                    .setParameter(2, airportFilter.cityIds())
                    .setParameter(3, airportFilter.airportIcaoCodes())
                    .setParameter(4, airportFilter.airportNames())
                    .setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
                    .setMaxResults(pageable.getPageSize())
                    .getResultList().stream().map(AirportT1OutputDTO::new).toList();
        }
    }


}
