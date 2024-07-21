package com.crr.dsa.crackingtheinterview;

import java.util.Scanner;

public class CinemaSeats {

    // Function to accept the seats data from the user
    public static int[] acceptSeatsData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of seats in each row: ");
        int seatsRow = scanner.nextInt();
        return new int[]{rows, seatsRow};
    }

    // Function to create the seats as per instructions
    public static char[][] createSeats(int rows, int seatsRow) {
        char[][] seats = new char[rows][seatsRow];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < seatsRow; col++) {
                seats[row][col] = (char) (col + 'A');
            }
        }
        return seats;
    }

    // Function to display the seats as per the given format
    public static void displaySeats(char[][] seats) {
        int rowNum = 1;
        for (char[] seatsRow : seats) {
            System.out.print(String.format("%" + String.valueOf(seats.length).length() + "d ", rowNum++));
            int colNum = 0;
            for (char eachSeat : seatsRow) {
                if (colNum == seatsRow.length / 2) {
                    System.out.print(" ");
                }
                System.out.print(eachSeat + " ");
                colNum++;
            }
            System.out.println();
        }
    }

    // Function to accept the seat number
    public static int[] getSeatNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input seat number (row seat): ");
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        char seat = input[1].charAt(0);
        return new int[]{row, seat};
    }

    // Function to select the seat from the available seats
    public static char[][] selectSeat(char[][] seats) {
        Scanner scanner = new Scanner(System.in);
        char moreSeats = 'y';
        while (moreSeats == 'y' || moreSeats == 'Y') {
            int[] seatNum = getSeatNum();
            int row = seatNum[0];
            int seat = Character.toUpperCase(seatNum[1]);
            if (row > seats.length || seat > seats[0][seats[0].length - 1]) {
                System.out.println("Seat number is invalid!");
                continue;
            } else if (seats[row - 1][seat - 'A'] == 'X') {
                System.out.println("That seat is taken!");
                continue;
            } else {
                seats[row - 1][seat - 'A'] = 'X';
                displaySeats(seats);
                System.out.print("More seats (y/n)? ");
                moreSeats = scanner.nextLine().charAt(0);
            }
        }
        return seats;
    }

    // Main method
    public static void main(String[] args) {
        int[] seatsData = acceptSeatsData();
        int rows = seatsData[0];
        int seatsRow = seatsData[1];
        char[][] seats = createSeats(rows, seatsRow);
        displaySeats(seats);
        seats = selectSeat(seats);
        
    }
}