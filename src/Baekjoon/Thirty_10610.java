package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Thirty_10610 {

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);
        String input = inputParameter.next();

        int[] N = new int[input.length()];
        int sum = 0;    // 숫자들의 합
        boolean isZero = false; // 0존재 여부

        for(int i = 0; i < input.length(); i++){
            N[i] = Integer.parseInt(input.charAt(i)+"");
            sum += N[i];
            if(N[i] == 0)
                isZero = true;
        }

        Arrays.sort(N);
        if(sum%3 == 0 && isZero){
            for(int i = N.length - 1; i >= 0; i--)
                System.out.print(N[i]);
        }else{
            System.out.print(-1);
        }
    }
}
