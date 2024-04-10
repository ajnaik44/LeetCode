package com.crr.dsa.priorityqueue;

import java.util.HashMap;
import java.util.Map;

public class SocialNetworkWithRank {
    private Map<Integer, Integer> parent;
    private Map<Integer, Integer> rank;

    public SocialNetworkWithRank() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

    public void addPerson(int personId) {
        parent.put(personId, personId); // Initially, each person is in their own friend group
        rank.put(personId, 0); // Initialize rank to 0
    }

    public int findFriendGroup(int personId) {
        if (parent.get(personId) == personId) {
            return personId; // This person is the representative of their friend group
        } else {
            return findFriendGroup(parent.get(personId));
        }
    }

    public void formFriendship(int person1, int person2) {
        int group1 = findFriendGroup(person1);
        int group2 = findFriendGroup(person2);

        if (group1 != group2) {
            // Connect the two friend groups by considering rank
            if (rank.get(group1) < rank.get(group2)) {
                parent.put(group1, group2);
            } else if (rank.get(group1) > rank.get(group2)) {
                parent.put(group2, group1);
            } else {
                parent.put(group1, group2);
                rank.put(group2, rank.get(group2) + 1);
            }
        }
    }

    public boolean areFriends(int person1, int person2) {
        return findFriendGroup(person1) == findFriendGroup(person2);
    }

    public static void main(String[] args) {
        SocialNetworkWithRank network = new SocialNetworkWithRank();

        // Adding people to the social network
        network.addPerson(1);
        network.addPerson(2);
        network.addPerson(3);
        network.addPerson(4);

        // Forming friendships
        network.formFriendship(1, 2);
        network.formFriendship(3, 4);

        // Checking if people are friends
        System.out.println("Are 1 and 3 friends? " + network.areFriends(1, 3)); // Should be false
        System.out.println("Are 2 and 4 friends? " + network.areFriends(2, 4)); // Should be false

        // Forming more friendships
        network.formFriendship(2, 3);

        // Rechecking if people are friends
        System.out.println("Are 1 and 3 friends now? " + network.areFriends(1, 3)); // Should be true
        System.out.println("Are 2 and 4 friends now? " + network.areFriends(2, 4)); // Should be true
    }
}
