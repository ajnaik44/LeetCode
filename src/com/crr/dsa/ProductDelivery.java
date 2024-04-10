package com.crr.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfClients = scanner.nextInt();
        
        int[] orderIDs = new int[numOfClients];
        for (int i = 0; i < numOfClients; i++) {
            orderIDs[i] = scanner.nextInt();
        }
        
        Map<Integer, Integer> clientwiseData = calculateClientwiseData(orderIDs);
        
        for (int i = 0; i < numOfClients; i++) {
            System.out.print(clientwiseData.get(orderIDs[i]) + " ");
        }
    }
    
    public static Map<Integer, Integer> calculateClientwiseData(int[] orderIDs) {
        Map<Integer, Integer> clientwiseData = new HashMap<>();
        
        for (int orderID : orderIDs) {
            clientwiseData.put(orderID, clientwiseData.getOrDefault(orderID, 0) + orderID);
        }
        
        return clientwiseData;
    }
}
