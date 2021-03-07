package com.gridnine.testing;

import com.sun.istack.internal.NotNull;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Returns all flights, where plane had more than two hours gaps sum between segments
 */

public class MoreThenTwoHoursOnTheGroundFilter implements Filter {

    public List<Flight> filtrate(List<Flight> flights) {
        List<Flight> filteredList = new ArrayList<>();

        for (Flight flight : flights) {
            Duration timeOnTheGround = Duration.ZERO;
            for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                 timeOnTheGround = Duration.between(flight.getSegments().get(i).getArrivalDate(),
                    flight.getSegments().get(i + 1).getDepartureDate()).plus(timeOnTheGround);
            }
            if (timeOnTheGround.compareTo(Duration.ofHours(2)) > 0) {
                filteredList.add(flight);
            }
        }

        return filteredList;
    }

}
