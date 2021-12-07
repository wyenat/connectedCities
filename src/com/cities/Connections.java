package com.cities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Contains the connections between the {@link City} objects.
 */
public class Connections {
    private final HashMap<String, City> connectionNode = new HashMap<String, City>();
    private HashSet<String> explored = new HashSet<String>();
    private boolean foundConnection = false;

    /**
     * Connect 2 cities together.
     * @param cityA {@link City} to connect to cityB
     * @param cityB {@link City} to connect to cityA
     */
    public void addCityConnection(String cityA, String cityB){
        if (connectionNode.containsKey(cityA)){
            connectionNode.get(cityA).addConnection(cityB);
        } else {
            City cA = new City(cityA);
            cA.addConnection(cityB);
            connectionNode.put(cityA, cA);
        }
        if (connectionNode.containsKey(cityB)){
            connectionNode.get(cityB).addConnection(cityA);
        } else {
            City cB = new City(cityB);
            cB.addConnection(cityA);
            connectionNode.put(cityB, cB);
        }
    }

    /**
     * Recursively check if city are connected
     * @param cityA {@link City} starting city
     * @param cityB {@link City} final city
     * @return true if city are connected, false otherwise
     */
    public boolean isConnected(String cityA, String cityB){
        City cA = connectionNode.get(cityA);
        if (cA == null || !connectionNode.containsKey(cityB)){
            // Don't search a city that doesn't exist
            return false;
        }
        explored.add(cityA);
        boolean found = false;
        if (cA.getConnected().contains(cityB)){
            foundConnection = true;
            return true;
        }
        for (String city: cA.getConnected()){
            if (!explored.contains(city) && !foundConnection){
                found |= this.isConnected(city, cityB);
            }
        }
        return found;
    }
}
