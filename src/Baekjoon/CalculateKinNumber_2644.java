package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

// dfs
public class CalculateKinNumber_2644 {
    static int n, m;
    static int kinA, kinB;
    static int answer = -1;

    static ArrayList<ArrayList<Integer>> familyList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        // 촌수계산
        // 부모 - 자식 사이 : 1촌
        // 여러 사람들에 대한 부모 자식들 간의 관계가 주어질 때, 두 사람의 촌수 계산하기
        // 입력 : 1. 전체 사람의 수 n (1~n)
        //       2. 촌수를 계산해야하는 두 사람의 번호
        //       3. 부모 자식들 간의 관계의 개수 m
        //       4. 부모 자식간의 관계를 나타내는 두 번호 x, y (m 개 만큼)
        // 출력 : 촌수를 나타내는 정수 출력

        Scanner inputParameter = new Scanner(System.in);

        n = inputParameter.nextInt();
        for(int i = 0; i <= n; i++) {
            familyList.add(new ArrayList<>());
        }
        visited = new boolean[n +  1];

        kinA = inputParameter.nextInt();
        kinB = inputParameter.nextInt();

        m = inputParameter.nextInt();
        for(int i = 0; i < m; i++) {
            int x = inputParameter.nextInt();
            int y = inputParameter.nextInt();

            familyList.get(x).add(y);
            familyList.get(y).add(x);
        }

        dfs(kinA, kinB, 0);

        System.out.println(answer);
    }

    public static void dfs(int position, int find, int kinCount) {
        visited[position] = true;

        for(int i : familyList.get(position)) {
            if(!visited[i]) {
                if(i == find) {
                    answer = kinCount + 1;
                    return;
                }

                dfs(i, find, kinCount + 1);
            }
        }
    }
}
