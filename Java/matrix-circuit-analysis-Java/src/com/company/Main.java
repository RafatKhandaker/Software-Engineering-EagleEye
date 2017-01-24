package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


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

        int[][] matrixI = new int[currentLoops][];
        int inMatrixI;
        for(int i = 0; i < currentLoops ;i++){
            System.out.println("Which resistors are in Current loop " +(i+1) +"? ");
            inMatrixI = 0;
            for(int y = 0; y < totalResistors ;y++){
                System.out.println("R" +(y+1) +"? (y or n)");

                switch(scanner.next()){
                    case "y":
                         inMatrixI += mapResistor.get("R"+y);
                        break;
                    case "n":
                        break;
                    default:
                        y--;
                        break;
                }

                matrixI[i][i] = inMatrixI;

            }

 //-----------------------------------------Test matrix Value -------------------------------------------
            int check = 0;
            while(check < currentLoops){
                for(int y = 0; y < currentLoops ; y++){
                    System.out.print(matrixI[check][y] +" ");
                }
                System.out.print("\n");
                check++;
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
