package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();


        char[][] seatTables = new char[rows][seats];

        for (char[] seatTable : seatTables) {
            Arrays.fill(seatTable, 'S');
        }


        int action;
        int purchasedTickets = 0;
        int totalSeats = rows * seats;
        double percentage = 0.0;
        int currentIncome = 0;
        int totalIncome = 0;
        showMenu();
        while (true) {
            action = scanner.nextInt();
            if (action == 0) {
                break;
            } else if (action == 1) {
                printTable(rows, seats, seatTables);
                showMenu();
            } else if (action == 2) {
                System.out.println();
                System.out.println("Enter a row number:");
                int rowChoose = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                int seatChoose = scanner.nextInt();

                while (true) {
                    if ((rowChoose <= 0 || rowChoose > rows) || (seatChoose <= 0 || seatChoose > seats)) {
                        System.out.println();
                        System.out.println("Wrong input!");

                    } else if (seatTables[rowChoose - 1][seatChoose - 1] == 'B') {
                        System.out.println();
                        System.out.println("That ticket has already been purchased!");
                    } else {
                        break;
                    }
                    System.out.println();
                    System.out.println("Enter a row number:");
                    rowChoose = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    seatChoose = scanner.nextInt();

                }



                int ticketPrice = 0;
                int firstHalfRows = rows / 2;
                int lastHalfRows = rows - firstHalfRows;

                if (totalSeats < 60) {
                    ticketPrice = 10;
                } else {
                    if (rowChoose <= firstHalfRows) {
                        ticketPrice = 10;
                    } else if (rowChoose >= lastHalfRows) {
                        ticketPrice = 8;
                    }
                }

                System.out.println();
                System.out.println("Ticket price: $" + ticketPrice);
                currentIncome = currentIncome + ticketPrice;
                purchasedTickets = purchasedTickets + 1;
                percentage = purchasedTickets * 100.0 / totalSeats;
                seatTables[rowChoose - 1][seatChoose - 1] = 'B';
                showMenu();

            } else if (action == 3) {
                System.out.printf("Number of purchased tickets: %d\n", purchasedTickets);;
                System.out.printf("Percentage: %.2f%%\n", percentage);
                System.out.printf("Current income: $%d\n", currentIncome);
                totalIncome = calculateTotalIncome(rows, seats);
                System.out.printf("Total income: $%d\n", totalIncome);
                showMenu();
            }
        }
//        printTable(rows, seats, seatTables);
    }

    private static void printTable(int rows, int seats, char[][] seatTables) {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
           System.out.print((i + 1) + " ");
           for (int j = 0; j < seats; j++) {
               System.out.print(seatTables[i][j] + " ");
           }
           System.out.println();
       }
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("""
           1. Show the seats
           2. Buy a ticket
           3. Statistics
           0. Exit"""
        );

    }

    private static int calculateTotalIncome(int rows, int seats) {
        int totalSeats = rows * seats;
        int firstHalfRows = rows / 2;
        int lastHalfRows = rows - firstHalfRows;
        int totalInCome = 0;
        int price = 0;
        if (totalSeats < 60) {
            return totalInCome = 10 * totalSeats;
        } else {
            return totalInCome = (firstHalfRows * 10 + lastHalfRows * 8) * seats;
        }
    }
}