package com.crr.dsa.priorityqueue;

import java.util.HashMap;
import java.util.Map;

public class Problem1_Cities {
    private Map<String, String> cities;
    private Map<String, Integer> rank;

    public Problem1_Cities() {
        cities = new HashMap<>();
        rank = new HashMap<>();
    }

    public void cityEntries(String city) {
        cities.put(city, city);
        rank.put(city, 0);
    }

    public String findJoinCity(String city1) {
        if (cities.get(city1).equalsIgnoreCase(city1)) {
            return city1;
        } else {
            return findJoinCity(cities.get(city1));
        }
    }

    public void joinCities(String city1, String city2) {
        String c1 = findJoinCity(city1);
        String c2 = findJoinCity(city2);

        if (!c1.equalsIgnoreCase(c2)) {
            if (rank.get(c1) < rank.get(c2)) {
                cities.put(c1, c2);
            } else if (rank.get(c1) > rank.get(c2)) {
                cities.put(c2, c1);
            } else {
                cities.put(c1, c2);
                rank.put(c2, rank.get(c1) + 1);
            }
        }
    }

    public static void main(String[] args) {
        Problem1_Cities cityNetwork = new Problem1_Cities();

        cityNetwork.cityEntries("CityA");
        cityNetwork.cityEntries("CityB");
        cityNetwork.cityEntries("CityC");

        System.out.println("Initial Cities Network:");
        System.out.println(cityNetwork.findJoinCity("CityA"));
        System.out.println(cityNetwork.findJoinCity("CityB"));
        System.out.println(cityNetwork.findJoinCity("CityC"));

        cityNetwork.joinCities("CityA", "CityB");
        cityNetwork.joinCities("CityB", "CityC");

        System.out.println("\nUpdated Cities Network:");
        System.out.println(cityNetwork.findJoinCity("CityA"));
        System.out.println(cityNetwork.findJoinCity("CityB"));
        System.out.println(cityNetwork.findJoinCity("CityC"));
    }
}

