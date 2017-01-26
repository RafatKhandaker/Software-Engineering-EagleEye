package com.company;

import java.util.*;

/** 

 Written By: Rafat Khandaker

 **/

public class Main {

   private static Map<String,Double> mapResistor = new HashMap<>();
   private static Map<String, Double> voltageMap;
   private static Map<String, Double> currentMap;

   private static int currentLoops;
   private static double determinant;

   private static double[] saveMatrixVal;
   private static double[][] matrixR;

   private static int countSize = 0;  //
    private static boolean[][] checkResistDim;


    public static void main(String[] args) {

        int numVoltage;
        int totalResistors;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Make sure to use one proper convention and keep values consistent..." +
                "This program will solve the values of the current inside a mesh analysis circuit! \n \n" );

//------------------------------------Solve Current--------------------------------------------------------------------

        System.out.println("How many current loops are in this circuit? ");
        currentLoops = scanner.nextInt();

        saveMatrixVal = new double[currentLoops];
        currentMap = new HashMap<>();

//------------------------------------Solve Resistor-------------------------------------------------------------------

        System.out.println("How many total resistors are in this circuit? ");
        totalResistors = scanner.nextInt();

            for(int i = 0; i < totalResistors; i++){
                System.out.println("What is the value of R" +(i+1) +"?: ");
                mapResistor.put("R"+(i+1),scanner.nextDouble());

            }

        matrixR = new double[currentLoops][currentLoops];

        checkResistDim = new boolean[currentLoops][totalResistors];
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

//        testBoolMatrixValue(currentLoops, totalResistors);

        for(int i = 0; i < currentLoops; i++){
            for(int y = 0; y < currentLoops; y++){
                if(i != y){
                    for(int z = 0; z < totalResistors; z++){
                        if(checkResistDim[i][z] && checkResistDim[y][z] == true){
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

            if(numVoltage != 0) {
                double voltVal = 0;

                for (int y = 0; y < numVoltage; y++) {
                    System.out.println("what is the value of Voltage source" + (y + 1) + " in mesh" + (i + 1) + ": " +
                            "(keep convention +/-)");
                    voltVal += scanner.nextInt();
                    voltageMap.put("V" + (i + 1), voltVal);
                }


            }else{  voltageMap.put("V" +(i + 1), 0.0);}

        }

//-------------------------------Testing Determinant Values----------------------------------------------------------

        testPrintMatrixEquation(matrixR, currentLoops, currentLoops);

        System.out.print("\n Test printing Determinant Value after 3x3 to 5x3 conversion:\n");
        testPrintMatrixValue(
                set5x3Determinant(matrixR),currentLoops,(currentLoops + currentLoops-1));

        System.out.print("Determinant is equal to diagonal of positive hash minus negative hash");


      //--------------------------------Determinant-----------------------------------------------

        countSize = 0;
        determinant = solveDeterminant(matrixR);

        System.out.println(" \n The Determinant is " +determinant);

        solveCurrentValues();

    }

    //-----------------------------------------Test matrix Value -------------------------------------------

    private static void testPrintMatrixEquation(double[][] matrix, int loop1, int loop2 ){
        int check = 0;
        int count = 1;

        System.out.println("\n\n Printing the Current Matrix Equation: \n");

        System.out.println("Resistor       |     Current   |     Voltage \n");

        while(check < loop1){
            for(int y = 0; y < loop2 ; y++){
                System.out.print(matrix[check][y] +"     ");
                if(y+1 == loop2){
                    System.out.print("    I" +count +"             " + voltageMap.get("V"+count));
                    count++;
                }
            }
            System.out.print("\n\n\n");
            check++;
        }

        System.out.print("\n");
    }

    private static void testPrintMatrixValue(double[][] matrix, int loop1, int loop2 ){
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

    private static void testBoolMatrixValue( int loop1, int loop2 ){
        int check = 0;

        while(check < loop1){
            for(int y = 0; y < loop2 ; y++){
                System.out.print(checkResistDim[check][y] +" ");

            }
            System.out.print("\n");
            check++;
        }

        System.out.print("\n");
    }

    private static double[][] set5x3Determinant(double[][] matrix){
        int n = currentLoops + (currentLoops -1);
        double[][] newMatrix = new double[currentLoops][n];

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

    private static double[][] convert3x3Determinant(double[][] matrix, int column){
        for(int n = 0; n < currentLoops; n++) {
            saveMatrixVal[n] = matrix[n][column];
        }

        for(int i = 0; i < currentLoops ; i++){
            for(int y = 0; y < currentLoops; y++){
                if(y == column){
                    matrix[i][y] = voltageMap.get("V"+(i+1));
                }
            }
        }
        return matrix;
    }

    private static double[][] revertBack3x3Determinant(double[][] matrix, int column){
        for(int i = 0; i < currentLoops ; i++){
            for(int y = 0; y < currentLoops; y++){
                if(y == column){
                    matrix[i][y] = saveMatrixVal[i];
                }
            }
        }
        return matrix;
    }

    private static double multPosDiagonal(double[][] matrix, int loopSize, int shift){
        int x = countSize;
        if(countSize == loopSize){ return 1; }
        countSize++;
        return
            (matrix[x][x+shift] * multPosDiagonal(matrix, loopSize, shift));
    }

    private static double multNegDiagonal(double[][] matrix, int loopSize, int shift){
        int x = countSize;
        if(countSize == currentLoops ){ return 1; }
        countSize++;
        loopSize--;
        return matrix[x][(loopSize) +shift] * multNegDiagonal(matrix,loopSize, shift);
    }


    private static int solveDeterminant(double[][] matrix){
        int result1 = 0;
        int result2 = 0;
        for(int i = 0; i < currentLoops; i++){
            if(true) {
                double x = multPosDiagonal(set5x3Determinant(matrix), currentLoops, i);
                countSize = 0;
                double y = multNegDiagonal(set5x3Determinant(matrix), currentLoops, i);

                result1 += x;
                result2 += y;
            }
            countSize = 0;
        }
        return result1 - result2;
    }

    private static void solveCurrentValues(){
        double detA;

        for(int i = 0; i < currentLoops; i++) {

            convert3x3Determinant(matrixR, i);
            set5x3Determinant(matrixR);

            countSize = 0;
            detA = solveDeterminant(matrixR);

            currentMap.put("I"+i, (detA / determinant));

            System.out.println("\nCurrent Value for Mesh loop "+i+" is : " + currentMap.get("I"+i) + " amps");

            revertBack3x3Determinant(matrixR, i);

        }
    }

}
