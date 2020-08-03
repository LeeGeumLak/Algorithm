package Baekjoon;

import java.util.Scanner;

public class Fibonacci_1003 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int testCase = inputParameter.nextInt();

        for (int i = 0; i < testCase; i++) {
            int testElement = inputParameter.nextInt();

            int[][] testResult = new int[testElement+1][2];

            if(testElement==0) {
                System.out.println("1 0");
                continue;
            }
            if(testElement==1){
                System.out.println("0 1");
                continue;
            }

            testResult[0][0] = 1;
            testResult[1][1] = 1;

            for(int j = 2; j <= testElement; j++){
                testResult[j][0] = testResult[j-1][0] + testResult[j-2][0];
                testResult[j][1] = testResult[j-1][1] + testResult[j-2][1];

            }

            System.out.println(testResult[testElement][0]+" "+testResult[testElement][1]);

        }
    }
}
