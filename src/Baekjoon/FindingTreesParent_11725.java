package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class FindingTreesParent {
    static int N;
    static ArrayList<Integer>[] tree;
    static int[] nodesParent;

    public static void main(String[] args) {
        // 루트 없는 트리가 주어짐, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하기
        // 입력 : 1. 노트의 개수 N (2 <= N <= 100,000)
        //       2. N-1 개의 줄에 트리 상에서 연결된 두 정점
        // 출력 : 첫째줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 출력

        Scanner inputParameter = new Scanner(System.in);
        N = inputParameter.nextInt();

        tree = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < N-1; i++) {
            int nodeA = inputParameter.nextInt();
            int nodeB = inputParameter.nextInt();

            tree[nodeA].add(nodeB);
            tree[nodeB].add(nodeA);
        }

        nodesParent = new int[N+1];

        dfs(1, 0);

        for(int i = 2; i <= N; i++) {
            System.out.println(nodesParent[i]);
        }
    }

    public static void dfs(int start, int parent) {
        nodesParent[start] = parent;

        for(int item : tree[start]) {
            if(item != parent) {
                dfs(item, start);
            }
        }
    }
}
