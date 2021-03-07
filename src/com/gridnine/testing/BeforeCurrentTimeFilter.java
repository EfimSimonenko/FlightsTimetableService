package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Returns all flights, that already departed at the moment
 */

public class BeforeCurrentTimeFilter implements Filter {
    public List<Flight> filtrate(List<Flight> allFlights) {
        LocalDateTime currentTime = LocalDateTime.now();
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : allFlights) {
            if (flight.getSegments().get(0).getDepartureDate().isBefore(currentTime)) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
