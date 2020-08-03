package Baekjoon;

import java.util.Scanner;

public class Coin_0_11047 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        int coinTypeNum = 0;
        int valueAmount = 0;

        coinTypeNum = inputParameter.nextInt();
        valueAmount = inputParameter.nextInt();

        int[] coinValueArray = new int[coinTypeNum];

        for(int i = 0; i < coinTypeNum; i++) {
            coinValueArray[i] = inputParameter.nextInt();
        }

        System.out.println( calMinCoinNum(coinTypeNum, valueAmount, coinValueArray) );
    }

    public static int calMinCoinNum(int coinTypeNum, int valueAmount, int[] coinValueArray) {
        int minCoinNum = 0;

        for(int i = coinTypeNum - 1; i >= 0; i--) {
            if(valueAmount >= coinValueArray[i]) {
                minCoinNum += valueAmount / coinValueArray[i];
                valueAmount = valueAmount % coinValueArray[i];
            }
        }

        return minCoinNum;
    }

}
