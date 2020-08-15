package Baekjoon;

import java.util.Scanner;

public class LostParenthesis_1541 {
    static int result = 0;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        String formula = inputParameter.next();

        String[] formulaArray = formula.split("-");
        result += sum(formulaArray[0].split("[+]"));

        // 그 뒤로 나오는 -까지 덩어리들의 합
        for (int i = 1; i < formulaArray.length; i++) {
            result -= sum(formulaArray[i].split("[+]"));
        }

        System.out.println(result);
    }

    static int sum(String[] input) {
        int output = 0;
        for (String num : input) {
            output += Integer.parseInt(num);
        }
        return output;
    }
}