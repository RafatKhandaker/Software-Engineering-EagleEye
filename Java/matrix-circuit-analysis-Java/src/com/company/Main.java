package com.company;

import java.util.Scanner;

// TEST JAVA, NOT COMPLETE !!!   MORE COMPLEX THAN IT LOOKS:  
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

        int[] current = new int[]{currentLoops};

        for(int i = 0; i < currentLoops; i++){
            System.out.println("What is the value of current " +(i+1) +"? : ");
            current[i] = scanner.nextInt();
        }
//------------------------------------Solve Resistor-------------------------------------------------------------------

        System.out.println("How many total resistors are in this circuit? ");
        totalResistors = scanner.nextInt();

        int resValHolder;
        int[][] resistArrVal = new int[currentLoops][currentLoops];

        for(int i = 0; i < currentLoops; i++) {
            System.out.println("Number of Resistors in current mesh " +(i+1) +"? :");
            numResistors = scanner.nextInt();
            resValHolder = 0;

            for (int y = 0; y < numResistors; y++) {
                System.out.println("In Current Mesh " + i + ":");
                System.out.println("What is the value of Resistor" + (y + 1) + "? :");
                resValHolder += scanner.nextInt();

                if(i == y) {
                    resistArrVal[i] = new int[resValHolder];
                }else{
                    resValHolder = -resValHolder;
                    resistArrVal[i] = new int[resValHolder];
                    resValHolder = -resValHolder;
                }


            }
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
