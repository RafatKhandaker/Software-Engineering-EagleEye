package com.company;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        int currentLoops;
        int numResistors;
        int numVoltage;
        int totalResistors;
        int resInc = 0;


        Scanner scanner = new Scanner(System.in);

        System.out.println("Make sure to use one proper convention and keep values consistent..." +
                "This program will solve the values of the current inside a mesh analysis circuit! \n \n" );

//------------------------------------Solve Current--------------------------------------------------------------------

        System.out.println("How many current loops are in this circuit? ");
        currentLoops = scanner.nextInt();

        int[] current = new int[currentLoops];

//------------------------------------Solve Resistor-------------------------------------------------------------------

        System.out.println("How many total resistors are in this circuit? ");
        totalResistors = scanner.nextInt();


        int[][] resistArrVal = new int[currentLoops][currentLoops];
        int[] resistArrHold;


        for(int i = 0; i < currentLoops; i++) {
            resistArrHold = new int[currentLoops];
            System.out.println("Number of Resistors in current mesh " +(i+1) +"? :");
            numResistors = scanner.nextInt();

            System.out.println("What is the value of Resistors in current mesh " +(i+1) +": ");

            for (int y = 0; y < numResistors; y++) {
                resistArrHold[y] = scanner.nextInt();
            }
            resistArrVal[i] = resistArrHold;

        }

//-------------------------------check diagonal R values of the determinant------------------------------------------------
        System.out.println("\n Testing the diagonal Resistor values of the Determinant \n :" );

        int check = 0;
          while(check < currentLoops){
            for(int y = 0; y < currentLoops ; y++){
                System.out.print(resistArrVal[check][y] +" ");
            }
            System.out.print("\n");
            check++;
          }






//------------------------------------Solve Voltages -------------------------------------------------------------------
        for(int i = 0; i < currentLoops; i++){
            System.out.println("Number of Voltage sources inside current mesh " +i +"? :");
            numVoltage = scanner.nextInt();

            for(int y = 0; y < numVoltage; i++){
//                System.out.println("In Current Mesh " +i +":");
//                System.out.println("What is the value of Resistor" +(y+1) + "? :");
//                resistValue[i] = scanner.nextInt();
            }
        }
    }
}
