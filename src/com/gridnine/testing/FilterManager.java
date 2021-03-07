package com.gridnine.testing;

import java.util.List;

/**
 * Strategy pattern implementation class
 */

public class FilterManager {
    private Filter filter;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public List<Flight> filtrate(List<Flight> flights) {
        return filter.filtrate(flights);
    }


}
