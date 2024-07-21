package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class NumFriendRequests {
	public static void main(String[] args) {
		int num[] = {20,30,100,110,120};
		NumFriendRequests friendRequests = new NumFriendRequests();
		System.out.println(friendRequests.numFriendRequests(num));
	}
	private boolean helper(int i, int j){
        return !((j <= i*0.5+7) || (j>i) || (j>100 && i<100));
    }


    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:ages){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int res=0;
        for(int i:map.keySet()){
            for(int j:map.keySet()){
                if(helper(i, j)) {
                    res += map.get(i) * (map.get(j) - (i==j?1:0));
                }
            }
        }
        return res;
    }
}
