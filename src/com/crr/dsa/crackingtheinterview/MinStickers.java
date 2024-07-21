package com.crr.dsa.crackingtheinterview;

import java.util.HashMap;
import java.util.Map;

public class MinStickers {

	public int minStickers(String[] stickers, String target) {
		Map<String, Map<Character, Integer>> map = new HashMap<>();
		for (String sticker : stickers) {
			Map<Character, Integer> counts = new HashMap<>();
			for (char c : sticker.toCharArray()) {
				counts.put(c, counts.getOrDefault(c, 0) + 1);
			}
			map.put(sticker, counts);
		}
		Map<Character, Integer> targetMap = new HashMap<>();
		for (char c : target.toCharArray()) {
			targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
		}

		int minSticker = 0;

		while (!targetMap.isEmpty()) {
			String dominateString = dominateString(map, targetMap);
			if (dominateString.isEmpty())
				return -1;
			minSticker++;
			for (char c : dominateString.toCharArray()) {
				if (targetMap.containsKey(c)) {
					targetMap.put(c, targetMap.get(c) - 1);
					if (targetMap.get(c) == 0)
						targetMap.remove(c);
				}
			}
		}

		return minSticker;

	}

	public String dominateString(Map<String, Map<Character, Integer>> map, Map<Character, Integer> target) {
		String result = "";
		int maxCount = 0;
		for (Map.Entry<String, Map<Character, Integer>> temp : map.entrySet()) {
			int count = 0;
			for (Map.Entry<Character, Integer> charMap : temp.getValue().entrySet()) {
				if (target.containsKey(charMap.getKey())) {
					count++;
				}

			}
			if (count > maxCount) {
				result = temp.getKey();
				maxCount = count;
			}
		}
		return result;
	}
public static void main(String[] args) {
	MinStickers minStickers = new MinStickers();
	String [] stickers= {"these","guess","about","garden","him"};
	System.out.println(minStickers.minStickers(stickers, "atomher"));
}
}
