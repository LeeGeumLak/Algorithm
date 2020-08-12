package Baekjoon;

import java.util.Scanner;

public class GroupWordChecker_1316 {
    static int N, result = 0;

    static Scanner inputParameter = new Scanner(System.in);

    public static void main(String[] args) {
        N = inputParameter.nextInt();

        for(int i = 0; i < N; i++) {
            if( groupWordChecker() ) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static boolean groupWordChecker() {
        int prev = 0;
        boolean[] alphabetChecker = new boolean[26]; // 알파벳 개수 26

        String word = inputParameter.next();
        for (int i = 0; i < word.length(); i++) {
            int now = word.charAt(i);

            if ( prev != now ) {
                if ( !alphabetChecker[now - 'a'] ) {
                    alphabetChecker[now - 'a'] = true;
                    prev = now;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}
