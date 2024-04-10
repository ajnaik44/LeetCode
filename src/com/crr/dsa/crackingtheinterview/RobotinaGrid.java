package com.crr.dsa.crackingtheinterview;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;

public class RobotinaGrid {
	static ArrayList<Point> getPath(boolean[][] maze) {
	    if (maze == null || maze.length == 0) return null;
	    ArrayList<Point> path = new ArrayList<Point>();
	    HashSet<Point> failedPoints = new HashSet<Point>();
	    if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
	        return path;
	    }
	    return null;
	}

	static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path,
	                HashSet<Point> failedPoints) {
	    /* If out of bounds or not available, return.*/
	    if (col < 0 || row < 0 || !maze[row][col]) {
	        return false;
	    }

	    Point p = new Point(row, col);

	    /* If we've already visited this cell, return. */
	    if (failedPoints.contains(p)) {
	        return false;
	    }

	    boolean isAtOrigin = (row == 0) && (col == 0);

	    /* If there's a path from start to my current location, add my location.*/
	    if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) ||
	            getPath(maze, row - 1, col, path, failedPoints)) {
	        path.add(p);
	        return true;
	    }

	    failedPoints.add(p); // Cache result
	    return false;
	}
	public static void main(String[] args) {
        boolean[][] maze = {
            {true, true, true, true},
            {true, false, true, true},
            {true, false, false, true},
            {false, true, true, true}
        };

        ArrayList<Point> path = getPath(maze);

        if (path != null) {
            System.out.println("Path found:");
            for (Point point : path) {
                System.out.println("(" + point.x + ", " + point.y + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
