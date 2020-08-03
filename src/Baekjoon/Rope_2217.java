package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Rope_2217 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int ropeNum = inputParameter.nextInt();
        int[] ropeWeight = new int[ropeNum];

        for(int i = 0; i < ropeNum; i++) {
            ropeWeight[i] = inputParameter.nextInt();
        }

        System.out.println( calMaxWeight(ropeNum, ropeWeight) );
    }

    public static int calMaxWeight(int ropeNum, int[] ropeWeight) {
        int maxWeight = 0;

        Arrays.sort(ropeWeight);

        for(int i = ropeNum - 1; i >= 0; i--) {
            ropeWeight[i] = ropeWeight[i] * (ropeNum-i);
            if(maxWeight < ropeWeight[i]) {
                maxWeight = ropeWeight[i];
            }
        }

        return maxWeight;
    }
}
