import java.util.Scanner;
import java.util.Arrays;
import java.util.Calendar;

public class Table {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Number of Inputs >> ");
        int numInputs = input.nextInt();
        input.close();

        boolean possibleInputs[][] = new boolean[(int)Math.pow(2, numInputs)][numInputs];

        for (int i = 0 ; i < possibleInputs.length; i++){
            
            String binary = intToBinary(i, numInputs);
            String binArr[] = binary.split("");

            for (int x = 0; x < numInputs; x++){
                if(binArr[x].equals("1")){
                    possibleInputs[i][x] = true;
                }
            }
        }
        for (int i = 0; i < 25; i++){
            System.out.print("-");
        }
        System.out.println("\n");
        System.out.println("  Truth Table Generator  ");
        System.out.println();
        for (int i = 0; i < 25; i++){
            System.out.print("-");
        }
        System.out.println();

        //printArray(possibleInputs);
        char[] letters = {  'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 
                            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
                            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        System.out.print("     ");
        for (int i = numInputs-1; i > -1; i--){
            System.out.print(letters[i]+" ");
        }
        System.out.println();
        int mismatchCounter = 0;
        for (int i = 0; i < possibleInputs.length; i++){
            System.out.print(" >>  ");
            for(int x = 0; x < numInputs; x++){
                if (possibleInputs[i][x]){
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            boolean answer = computeOriginalBooleanAlgebra(possibleInputs[i]);
            boolean testAnswer = computeTestBooleanAlgebra(possibleInputs[i]);
            if (answer){
                System.out.print("  | 1");
            } else {
                System.out.print("  | 0");
            }
            if (testAnswer){
                System.out.print(" 1 ");
            } else {
                System.out.print(" 0 ");
            }
            
            if(answer != testAnswer) {
                mismatchCounter++;
                System.out.println(" **MISMATCH**");
            } else {
                System.out.println();
            }
        }

        System.out.println("\n\nTable Complete.\nTotal mismatches found "+mismatchCounter+"\n\n");
        System.out.println("Test ran at " + Calendar.getInstance().getTime() + "\n");
    }

    public static boolean computeOriginalBooleanAlgebra(boolean[] vars){
        /*
         * vars[vars.length-1] --> the first variable (A)
         * vars[vars.length-2] --> the second variable (B)
         */
        boolean A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
        A = vars[vars.length-1]; 
        B = vars[vars.length-2]; 
        C = vars[vars.length-3]; 
        D = vars[vars.length-4];
        E = vars[vars.length-5];
        // F = vars[vars.length-6];
        // G = vars[vars.length-7];
        // H = vars[vars.length-8];
        // I = vars[vars.length-9];
        // J = vars[vars.length-10];
        // K = vars[vars.length-11];
        // L = vars[vars.length-12];
        // M = vars[vars.length-13];
        // N = vars[vars.length-14];
        // O = vars[vars.length-15];
        // P = vars[vars.length-16];
        // Q = vars[vars.length-17];
        // R = vars[vars.length-18];
        // S = vars[vars.length-19];
        // T = vars[vars.length-20];
        // U = vars[vars.length-21];
        // V = vars[vars.length-22];
        // W = vars[vars.length-23];
        // X = vars[vars.length-24];
        // Y = vars[vars.length-25];
        // Z = vars[vars.length-26];
        
        
        boolean answer = !B && C || A && C && !D || !A && C || E && !B || E && (A || C) && (!A || !D);
        return answer;
    }

    public static boolean computeTestBooleanAlgebra(boolean[] vars){
        /*
         * vars[vars.length-1] --> the first variable (A)
         * vars[vars.length-2] --> the second variable (B)
         */
        boolean A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
        A = vars[vars.length-1];
        B = vars[vars.length-2];
        C = vars[vars.length-3];
        D = vars[vars.length-4];
        E = vars[vars.length-5];
        // F = vars[vars.length-6];
        // G = vars[vars.length-7];
        // H = vars[vars.length-8];
        // I = vars[vars.length-9];
        // J = vars[vars.length-10];
        // K = vars[vars.length-11];
        // L = vars[vars.length-12];
        // M = vars[vars.length-13];
        // N = vars[vars.length-14];
        // O = vars[vars.length-15];
        // P = vars[vars.length-16];
        // Q = vars[vars.length-17];
        // R = vars[vars.length-18];
        // S = vars[vars.length-19];
        // T = vars[vars.length-20];
        // U = vars[vars.length-21];
        // V = vars[vars.length-22];
        // W = vars[vars.length-23];
        // X = vars[vars.length-24];
        // Y = vars[vars.length-25];
        // Z = vars[vars.length-26];
        
        boolean answer = C&&!(B&&A&&D)|| !B&&E||A&&E&&!D;
        return answer;
    }
    public static String intToBinary(int num, int numInputs) {
        String returnBinary = "";
        int[] binArr = new int[numInputs];
        int counter = 0;
        while (num > 0) {
            int remainder = num % 2;
            if (remainder == 1){
                binArr[counter] = 1;
            } else {
                binArr[counter] = 0;
            }
            num = num / 2;
            counter++;
        }
        for(int val:binArr){
            returnBinary = val+returnBinary;
        }
        return returnBinary;
    }

    public static void printArray(boolean[][] arr) {
        System.out.println("{ ");
        for (boolean[] row: arr) {
            System.out.print("\t{ ");
            for (boolean val: row){
                System.out.print(val + " ");
            }
            System.out.println("},");
        }
        System.out.println("}");
    }
    public static void printSubArray(int[] arr) {
        System.out.print("{ ");
        for (int val: arr){
            System.out.print(val + " ");
        }
        
        System.out.println("}");
    }
    public static void printSubArrayStr(String[] arr) {
        System.out.print("{ ");
        for (String val: arr){
            System.out.print(val + " ");
        }
        
        System.out.println("}");
    }
}