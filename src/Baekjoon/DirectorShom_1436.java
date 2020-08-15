package Baekjoon;

import java.util.Scanner;

public class DirectorShom_1436 {
    static int N;
    static int result = 666;
    static int count = 1;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        N = inputParameter.nextInt();
        while(N != count) {
            result++;
            if(String.valueOf(result).contains("666")) {
                count++;
            }
        }

        System.out.println(result);
    }
}
