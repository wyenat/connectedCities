package com.cities;

import java.util.HashSet;

/**
 * Contains the name of the city and its neighbouring cities.
 */
public class City {
    public String getName() {
        return name;
    }

    private final String name;
    private final HashSet<String> connected = new HashSet<String>();

    /**
     * @param name Name of the city.
     */
    public City(String name) {
        this.name = name;
    }

    /**
     * Add a city in the network of this city.
     * @param city {@link String} Connect this city to this.
     */
    public void addConnection(String city){
        if (!connected.contains(city)){
            connected.add(city);
        }
    }

    /**
     * Network of connected cities
     * @return A set of the connected cities
     */
    public HashSet<String> getConnected() {
        return connected;
    }

}
