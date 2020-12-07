package Programmers;

// dfs
public class CountOfQuadCompression {
    private static int[][] map;
    private static int zeroNumber = 0;
    private static int oneNumber = 0;

    public int[] solution(int[][] arr) {
        // 0/1로 이루어진 2^n x 2^n 크기 2차원 배열 arr -> 쿼드 트리 방식으로 압축
        // 1. 압축하고자하는 영역 s
        // 2. 영역 s 내부에 있는 값이 모두 같으면 s를 해당 수 하나로 압축
        // 3. 모두 같지 않으면 정확히 4개의 균일한 정사각형으로 쪼갠 뒤, 각 영역에서 반복
        // 배열에 최종적으로 남는 0개수와 1개수 배열에 담아서 return

        int[] answer = new int[2];

        map = arr;
        dfs(arr.length, 0, 0);

        answer[0] = zeroNumber;
        answer[1] = oneNumber;

        return answer;
    }

    private static void dfs(int n, int x, int y) {
        if (n == 1) { // 한개인 경우 해당 값 +
            if (map[x][y] == 1) {
                oneNumber++;
            }
            else {
                zeroNumber++;
            }

            return;
        }

        if (isSame(n, x, y)) { //같은값인지 압축 가능한지
            return;
        }

        //4개 분리 탐색
        dfs(n / 2, x, y);
        dfs(n / 2, x + n / 2, y);
        dfs(n / 2, x, y + n / 2);
        dfs(n / 2, x + n / 2, y + n / 2);
    }

    public static boolean isSame(int n, int x, int y) {
        int first = map[x][y];

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (first != map[i][j]) {
                    return false;
                }
            }
        }

        //압축 가능하면 해당 값 +1
        if (first == 0) {
            zeroNumber += 1;
        }
        else {
            oneNumber += 1;
        }

        return true;
    }
}
