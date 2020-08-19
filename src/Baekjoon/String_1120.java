package Baekjoon;

import java.util.Scanner;

public class String_1120 {
    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        String AString = inputParameter.next();
        String BString = inputParameter.next();

        int lengthDiff = AString.length();

        for(int i = 0; i <= BString.length() - AString.length(); i++) {
            int count = 0;

            for(int j = 0; j < AString.length(); j++) {
                if( AString.charAt(j) != BString.charAt(i+j) ) {
                    count++;
                }
            }
            lengthDiff = Math.min(lengthDiff, count);
        }

        System.out.println(lengthDiff);
    }
}
