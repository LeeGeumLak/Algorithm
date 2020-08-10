package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lotto_6603 {
    static int K;
    static int[] combination;
    static int[] buffer;

    static List<List<String>> answer = new ArrayList<>();
    static List<String> currentList;

    public static void main(String[] args) {
        Scanner inputParameter = new Scanner(System.in);

        while (true) {
            String[] str = inputParameter.nextLine().split(" ");
            K = Integer.parseInt(str[0]);
            combination = new int[K];
            buffer = new int[K];

            if (K == 0) {
                break;
            }
            for (int i = 0; i < K; i++) {
                combination[i] = Integer.parseInt(str[i + 1]);
            }

            DFS(0, 0);

            currentList = new ArrayList<>();
            currentList.add("");
            answer.add(currentList);
        }

        for(int i = 0; i < answer.size(); i++) {
            for(int j = 0; j < answer.get(i).size(); j++) {
                System.out.print(answer.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void DFS(int start, int depth) {
        if (depth == 6) {
            currentList = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                if (buffer[i] == 1) {
                    currentList.add(String.valueOf(combination[i]).concat(" "));
                }
            }
            answer.add(currentList);
        }

        for (int i = start; i < K; i++) {
            buffer[i] = 1;
            DFS(i + 1, depth + 1);
            buffer[i] = 0;
        }
    }
}