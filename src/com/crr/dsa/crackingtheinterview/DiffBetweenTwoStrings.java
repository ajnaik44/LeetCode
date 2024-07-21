package com.crr.dsa.crackingtheinterview;

public class DiffBetweenTwoStrings {
	static int min = Integer.MAX_VALUE;
	static String result = null;

	static String[] diffBetweenTwoStrings(String source, String target) {
		dfs(source, target, 0, 0, new StringBuilder(), 0);
		return result.split(",");
	}
	public static void main(String[] args) {
		String result []=  diffBetweenTwoStrings("ABCDEFG", "ABDFFGH");
		for(String s : result)
			System.out.println(s);
	}
	 public static void dfs(String source, String target, int i, int j, StringBuilder sb, int edit) {
	        // Base case: if we've reached the end of either string
	        if (i >= source.length() || j >= target.length()) {
	            // If there are remaining characters in source, they need to be deleted
	            while (i < source.length()) {
	                edit++;
	                sb.append("-").append(source.charAt(i++)).append(",");
	            }
	            // If there are remaining characters in target, they need to be inserted
	            while (j < target.length()) {
	                edit++;
	                sb.append("+").append(target.charAt(j++)).append(",");
	            }
	            // Update the minimum edit distance and result if this path is better
	            if (edit < min) {
	                min = edit;
	                result = sb.toString();
	            }
	            return;
	        }

	        int length = sb.length();

	        // Case 1: Characters match, no edit required
	        if (source.charAt(i) == target.charAt(j)) {
	            sb.append(source.charAt(i)).append(",");
	            dfs(source, target, i + 1, j + 1, sb, edit);
	            sb.setLength(length);  // backtrack
	        } else {
	            // Case 2: Replace character in source with character in target
	            sb.append("-").append(source.charAt(i)).append(",");
	            dfs(source, target, i + 1, j, sb, edit + 1);
	            sb.setLength(length);  // backtrack

	            // Case 3: Insert character from target into source
	            sb.append("+").append(target.charAt(j)).append(",");
	            dfs(source, target, i, j + 1, sb, edit + 1);
	            sb.setLength(length);  // backtrack
	        }
	    }
}
