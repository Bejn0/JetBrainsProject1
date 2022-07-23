

package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of rows: ");
        String number1 = scanner.nextLine();
        
        System.out.println("Enter the number of seats in each row: ");
        String number2 = scanner.nextLine();
        
        int numOfRows= Integer.parseInt(number1);
        int numOfSeats= Integer.parseInt(number2);
        
        String[][] matrix = new String[numOfRows][numOfSeats + 1];
        
        for (int i=0; i < numOfRows; i++) {
                for (int j=0; j < numOfSeats + 1; j++) {
                    if(j==0){
                        matrix[i][j] = Integer.toString(i+1);
                    } else {
                        matrix[i][j] = "S";
                    }
                }
            }
            
        int totalIncome = 0, currentIncome = 0, numOfTicketsPurchased = 0;
        float percentage = 0;
        
        if (numOfRows*numOfSeats <= 60) {
                        totalIncome = numOfRows * numOfSeats * 10;
                    } else if (numOfRows*numOfSeats > 60 && numOfRows%2 == 0) {
                        totalIncome = numOfRows/2 * numOfSeats * 10 + numOfRows/2 * numOfSeats * 8;
                    } else if (numOfRows*numOfSeats > 60 && numOfRows%2 !=0) {
                        totalIncome = numOfRows/2 * numOfSeats * 10 + ((numOfRows/2) + 1) * numOfSeats * 8;
                    }
        
        while (true) {
        
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            
            int chosenOption = scanner.nextInt();
            
            switch(chosenOption){
                case 1: 
                    System.out.println("Cinema: ");
                    System.out.print(" ");
                    for (int i = 1; i < numOfSeats + 1; i++) {
                        System.out.print(" " + i);
                    }
                    System.out.println();
                    for (int i = 0; i < numOfRows; i++) {
                        for (int j = 0; j < numOfSeats + 1; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    int wantedRow=0, wantedSeat=0;
                    while (true){
                        System.out.println("Enter a row number: ");
                        wantedRow = scanner.nextInt();
                    
                        System.out.println("Enter a seat number in that row: ");
                        wantedSeat = scanner.nextInt();
                        
                        if(wantedRow>numOfRows || wantedSeat>numOfSeats) {
                            System.out.println("Wrong input!");
                            continue;
                        } else if (matrix[wantedRow-1][wantedSeat] == "B"){
                            System.out.println("That ticket has already been purchased!");
                            continue;
                        } else {
                            break;
                        }
                    }   
                    numOfTicketsPurchased++;
                    
                    matrix[wantedRow-1][wantedSeat] = "B";
                        
                    if(numOfRows*numOfSeats <= 60) {
                        currentIncome+=10;
                        System.out.println("Ticket price: $" + 10);
                    }else if(numOfRows*numOfSeats > 60 && wantedRow <= numOfRows/2) {
                        currentIncome+=10;
                        System.out.println("Ticket price: $" + 10);
                    }else if(numOfRows*numOfSeats > 60 && wantedRow > numOfRows/2) {
                        currentIncome+=8;
                        System.out.println("Ticket price: $" + 8);
                    }
                    
                    break;
                case 3: 
                    percentage = (float)numOfTicketsPurchased * 100 / (numOfRows*numOfSeats);
                    
                    System.out.println("Number of purchased tickets: " + numOfTicketsPurchased);
                    System.out.printf("Percentage: %.2f%%%n", percentage);
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total income: $" + totalIncome);
                    break;    
                case 0: return;
                
            }
        }
    }
}
