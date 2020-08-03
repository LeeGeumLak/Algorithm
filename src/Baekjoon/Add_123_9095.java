package Baekjoon;

import java.util.Scanner;

public class Add_123_9095 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int testCase = inputParameter.nextInt();
        int[] testResult = new int[11];

        testResult[1] = 1;
        testResult[2] = 2;
        testResult[3] = 4;

        int[] testElement = new int[testCase];
        for(int i = 0; i < testCase; i++) {
            testElement[i] = inputParameter.nextInt();

            for(int j = 4; j <= testElement[i]; j++) {
                testResult[j] = testResult[j-1] + testResult[j-2] + testResult[j-3];
            }
        }

        for(int i = 0; i < testCase; i++) {
            System.out.println(testResult[testElement[i]]);
        }

    }
}
