package com.company;

import java.util.*;


/** Testing the correct matrix to print.. pass ... still working on this problem.
 * PS: No calculator was made to solve determinants and matricies  50% Complete .. all the matrix are correct
 Proves the problem can be done

 Written By: Rafat Khandaker

 **/

public class Main {

   private static Map<String,Integer> mapResistor = new HashMap<>();
   private static int currentLoops;
   private static int[][] matrixR;
   private static Map<String, Integer> voltageMap;

    private static int countSize = 0;  //



    public static void main(String[] args) {

        int numVoltage;
        int totalResistors;


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

        matrixR = new int[currentLoops][currentLoops];

        boolean[][] checkResistDim = new boolean[currentLoops][totalResistors];
        boolean[] addResistDim = new boolean[totalResistors];

        for(int i = 0; i < currentLoops ;i++) {
            System.out.println("Which resistors are in Current loop " + (i + 1) + "? ");
            int inMatrixR = 0;
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

//------------------------------------Solve Voltages -------------------------------------------------------------------


        voltageMap = new HashMap<>();

        for(int i = 0; i < currentLoops; i++){
            System.out.println("Number of Voltage sources inside current mesh " +(i+1) +"? :");
            numVoltage = scanner.nextInt();
            int voltVal = 0;
            for(int y = 0; y < numVoltage; y++){
                System.out.println("what is the value of Voltage source" +(y+1) +" in mesh" +(i+1) +": " +
                        "(keep convention +/-)");
                voltVal += scanner.nextInt();
                voltageMap.put("V" +(i+1), voltVal);
            }
        }

//-------------------------------Testing Determinant Values----------------------------------------------------------

        testPrintMatrixEquation(matrixR, currentLoops, currentLoops);

        System.out.print("\n Test printing Determinant Value after 3x3 to 3x5 conversion:\n");
        testPrintMatrixValue(
                set3x5Determinant(matrixR),currentLoops,(currentLoops + currentLoops-1));

        System.out.print("\n Test print Determinant conversion from 3x3 resistor to voltage replacement: \n");

        System.out.print("Determinant is equal to diagonal of positive hash minus negative hash");

        System.out.println("Test Printing solve positive diagonal of determinant: ");

        System.out.println(multPosDiagonal(set3x5Determinant(matrixR), currentLoops, 0));
        countSize = 0;     // reset countSize
        System.out.println(multPosDiagonal(set3x5Determinant(matrixR), currentLoops, 1));
        countSize = 0;
        System.out.println(multPosDiagonal(set3x5Determinant(matrixR), currentLoops, 2));

        /** Negative hash of determinant calculations is incorrect values at the moment**/
    //-------------------------------negative determinant-------------------------------------------

//        System.out.println("Test Printing solve negative diagonal of determinant: ");
//
//        System.out.println(multPosDiagonal(set3x5Determinant(matrixR), currentLoops, 0));
//        countSize = 0;     // reset countSize
//        System.out.println(multPosDiagonal(set3x5Determinant(matrixR), currentLoops, 1));
//        countSize = 0;
//        System.out.println(multPosDiagonal(set3x5Determinant(matrixR), currentLoops, 2));

      //--------------------------------Determinant-----------------------------------------------

//        System.out.println(" The Determinant is " +set3x5Determinant(matrixR));

        //        testPrintMatrixValue(
//                convert3x3Determinant(matrixR,0),currentLoops, currentLoops
//        );

    }

    //-----------------------------------------Test matrix Value -------------------------------------------

    private static void testPrintMatrixEquation(int[][] matrix, int loop1, int loop2 ){
        int check = 0;
        int count = 1;

        System.out.println("\n\n Printing the Current Matrix Equation: \n");

        System.out.println("Resistor | Current | Voltage \n");

        while(check < loop1){
            for(int y = 0; y < loop2 ; y++){
                System.out.print(matrix[check][y] +" ");
                if(y+1 == loop2){
                    System.out.print("      I" +count +"      " + voltageMap.get("V"+count));
                    count++;
                }
            }
            System.out.print("\n");
            check++;
        }

        System.out.print("\n");
    }

    private static void testPrintMatrixValue(int[][] matrix, int loop1, int loop2 ){
        int check = 0;

        while(check < loop1){
            for(int y = 0; y < loop2 ; y++){
                System.out.print(matrix[check][y] +" ");

            }
            System.out.print("\n");
            check++;
        }

        System.out.print("\n");
    }

    private static int[][] set3x5Determinant(int[][] matrix){
        int n = currentLoops + (currentLoops -1);
        int[][] newMatrix = new int[currentLoops][n];

        for(int i = 0; i < currentLoops; i++){
            for(int y = 0; y < n ; y++){
                if(y < currentLoops) {
                    newMatrix[i][y] = matrix[i][y];
                }else{
                    int x = (y+1) % (currentLoops);
                    newMatrix[i][y] = matrix[i][x-1];
                }
            }
        }
        return newMatrix;
    }

    private static int[][] convert3x3Determinant(int[][] matrix,int column){
        int[][] newMatrix = matrix;
        for(int i = 0; i < currentLoops ; i++){
            for(int y = 0; y < currentLoops; y++){
                if(y == column){
                    newMatrix[i][y] = voltageMap.get("V"+(i+1));
                }
            }
        }
        return newMatrix;
    }

    private static int multPosDiagonal(int[][] matrix, int loopSize, int shift){
        int x = countSize;
        if(countSize == loopSize){ return 1; }
        countSize++;
        return
            (matrix[x][x+shift] * multPosDiagonal(matrix, loopSize, shift));
    }
    private static int convertSize = currentLoops + (currentLoops--);

    private static int multNegDiagonal(int[][] matrix, int loopSize, int shift){
        int x = countSize;
        if(loopSize < convertSize ){ return 1; }
        countSize++;
        return matrix[x][(loopSize-1) +shift] * multNegDiagonal(matrix,loopSize-1, shift);
    }

    private static int solvDeterminant(int[][] matrix){
        int result1 = 0;
        int result2 = 0;
        for(int i = 0; i < currentLoops; i++){
            if(true) {
                int x = multPosDiagonal(set3x5Determinant(matrix), currentLoops, i);
                int y = multNegDiagonal(set3x5Determinant(matrix), currentLoops, i);

                result1 += x;
                result2 += y;
            }
            countSize = 0;
        }


        return result1 - result2;
    }



// 00x11x22 + 01x12x23 + 02x13x24

}
