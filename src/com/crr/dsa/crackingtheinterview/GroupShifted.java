package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GroupShifted {
	
	
	// Create a hash value
    String getHash(String s) {
        char[] chars = s.toCharArray();
        StringBuilder hashKey = new StringBuilder();
        
        for (int i = 1; i < chars.length; i++) {
            hashKey.append((char) ( ( chars[i] - chars[i - 1] + 26) % 26 + 'a'));
        }
        
        return hashKey.toString();
    }
    
    public List<List<String>> groupStringsEditorial(String[] strings) {
        Map<String, List<String>> mapHashToList = new HashMap<>();
        
        // Create a hash_value (hashKey) for each string and append the string
        // to the list of hash values i.e. mapHashToList["cd"] = ["acf", "gil", "xzc"]
        for (String str : strings ) {
            String hashKey = getHash(str);
            if (mapHashToList.get(hashKey) == null) {
                mapHashToList.put(hashKey, new ArrayList<>());
            } 
            mapHashToList.get(hashKey).add(str);
        }
      
        // Iterate over the map, and add the values to groups
        List<List<String>> groups = new ArrayList<>();
        for (List<String> group : mapHashToList.values()) {
            groups.add(group);
        }
        
        // Return a list of all of the grouped strings
        return groups;
    }
	public static void main(String[] args) {
		String arr []= {"ba","ab"};
		System.out.println(new GroupShifted().groupStringsEditorial(arr));
	}

	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList();
		Map<Integer, PriorityQueue<String>> map = new HashMap();

		for (String s : strings) {
			int length = s.length();
			if (map.containsKey(length)) {
				map.get(length).add(s);
			} else {
				PriorityQueue<String> pq = new PriorityQueue<String>();
				pq.add(s);
				map.put(length, pq);
			}
		}
		for (Map.Entry<Integer, PriorityQueue<String>> iterator1 : map.entrySet()) {
			List<String> list = new ArrayList<String>();

			PriorityQueue<String> priorityQueue = iterator1.getValue();
			while (!priorityQueue.isEmpty()) {
				list.add(priorityQueue.poll());
			}
			result.add(list);

		}

		return result;
	}
}
