package com.crr.dsa.crackingtheinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SeatsToReserveFamiliesofFour {

	public static void main(String[] args) {
		System.out.println(airPlaneSeatReservation(22, "1A 3C 2B 20G 5A"));
	}

	public static int airPlaneSeatReservation(int N, String S) {
		int seatAllocated = N * 2;

		Map<Integer, ArrayList<Character>> map = new HashMap();

		String seats[] = S.split(" ");
		for (String seat : seats) {
			String rowNumber ="";
			int i=0;
			for(;i< seat.length();i++)
			{
				if(Character.isDigit(seat.charAt(i)))
				{
					rowNumber+=seat.charAt(i);
				}
				
			}
			int row =  Integer.parseInt(rowNumber);
			char label =  seat.charAt(i-1);
			if (!seat.isEmpty()) {
				if (map.get(row) == null) {
					map.put(row, new ArrayList<Character>());
				}
				map.get(row).add(label);

			}
		}
		Set<Character> allreadyConsider = new HashSet<Character>();
		for (Map.Entry<Integer, ArrayList<Character>> tempMap : map.entrySet()) {

			int row = tempMap.getKey();
			if (row <= N) {

				for (char col : tempMap.getValue()) {
					if (!allreadyConsider.contains(col) && (col == 'B' || col == 'C')){
							
						seatAllocated--;
						allreadyConsider.add('B');
						allreadyConsider.add('C');
					}
					if( (col == 'D' || col == 'E' || col == 'F' || col == 'G') ) {
						seatAllocated--;
						allreadyConsider.add('D');
						allreadyConsider.add('E');
						allreadyConsider.add('F');
						allreadyConsider.add('G');
					}
					if( (col == 'H' || col == 'J'))
					{
						seatAllocated--;
						allreadyConsider.add('H');
						allreadyConsider.add('J');
					}

				}
				allreadyConsider.clear();
			}
		}

		return seatAllocated;
	}
}
