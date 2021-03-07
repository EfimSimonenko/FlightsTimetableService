package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();

        FilterManager filterManager = new FilterManager();
        filterManager.setFilter(new BeforeCurrentTimeFilter());
        List<Flight> filteredList = filterManager.filtrate(flightList);
        for (Flight flight : filteredList) {
            System.out.println(flight);
        }
        //System.out.println("--------------------"); // uncomment for better view

        filterManager.setFilter(new ArrivalBeforeDepartureFilter());
        filteredList = filterManager.filtrate(flightList);
        for (Flight flight : filteredList) {
            System.out.println(flight);
        }

        //System.out.println("--------------------"); // uncomment for better view

        filterManager.setFilter(new MoreThenTwoHoursOnTheGroundFilter());
        filteredList = filterManager.filtrate(flightList);
        for (Flight flight : filteredList) {
            System.out.println(flight);
        }

    }
}
