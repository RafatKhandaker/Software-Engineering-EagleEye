package com.company;

import java.util.*;


/** Testing the correct matrix to print.. pass ... still working on this problem.
 * PS: No calculator was made to solve determinants and matricies  50% Complete .. all the matrix are correct
 Proves the problem can be done **/


public class Main {
   private static Map<String,Integer> mapResistor = new HashMap<>();


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

            for(int i = 0; i < totalResistors; i++){
                System.out.println("What is the value of R" +(i+1) +"?: ");
                mapResistor.put("R"+(i+1),scanner.nextInt());

            }

        int[][] matrixR = new int[currentLoops][currentLoops];
        int inMatrixR;

        boolean[][] checkResistDim = new boolean[currentLoops][totalResistors];
        boolean[] addResistDim = new boolean[totalResistors];

        for(int i = 0; i < currentLoops ;i++) {
            System.out.println("Which resistors are in Current loop " + (i + 1) + "? ");
            inMatrixR = 0;
            for (int y = 0; y < totalResistors; y++) {
                System.out.println("R" + (y + 1) + "? (y or n)");

                switch (scanner.next()) {
                    case "y":
                        inMatrixR += mapResistor.get("R" + (y + 1));
                        addResistDim[y] = true;
                        break;
                    case "n":
                        addResistDim[y] = false;
                        break;
                    default:
                        y--;
                        break;
                }
                matrixR[i][i] = inMatrixR;
            }
            checkResistDim[i] = addResistDim;
            addResistDim = new boolean[totalResistors];

        }

        for(int i = 0; i < currentLoops; i++){
            for(int y = 0; y < currentLoops; y++){
                if(i != y){
                    for(int z = 0; z < totalResistors; z++){
                        if(checkResistDim[i][z] == checkResistDim[y][z]){
                            matrixR[i][y] -= mapResistor.get("R"+(z+1));
                        }
                    }
                }
            }
        }

 //-----------------------------------------Test matrix Value -------------------------------------------
            int check = 0;
            int count = 1;

        System.out.println("\n\n Printing the Current Matrix Equation: \n");

        System.out.println("Resistor | Current | Voltage \n");

            while(check < currentLoops){
                for(int y = 0; y < currentLoops ; y++){
                    System.out.print(matrixR[check][y] +" ");
                    if(y+1 == currentLoops){
                        System.out.print(" I" +count +"  V" +count);
                        count++;
                    }
                }
                System.out.print("\n");
                check++;
            }

        System.out.print("\n \n \n");

            check = 0;

//        while(check < currentLoops){
//            for(int y = 0; y < totalResistors ; y++){
//                System.out.print(checkResistDim[check][y] +" ");
//
//            }
//            System.out.print("\n");
//            check++;
//        }
//
//        System.out.println("\n \n");

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
