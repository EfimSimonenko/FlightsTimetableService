package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Returns all flights, that have segments with Arrival time before departure.
 */
public class ArrivalBeforeDepartureFilter implements Filter {
    public List<Flight> filtrate(List<Flight> flights) {
        List<Flight> filteredList = new ArrayList<>();

        for (Flight flight : flights){
            for (Segment segment : flight.getSegments()) {
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                    filteredList.add(flight);
                    break;
                }
            }
        }
        return filteredList;
    }
}
