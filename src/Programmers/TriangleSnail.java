package Programmers;

public class TriangleSnail {
    public static int calculateTotalSum(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return calculateTotalSum(n - 1) +    n;
        }
    }

    public int[] solution(int n) {
        // 입력 : n
        // 출력 : 높이가 n인 삼각형
        //       단, 맨 위 꼭지점부터 반시계 방향으로 숫자를 채우고
        //           출력은 위에서 아래 순서대로
        //       예시
        //                1
        //              2   9
        //            3   10  8
        //          4   5   6   7

        int[][] triangleArray = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                triangleArray[i][j] = -1;
            }
        }

        int totalSumN = calculateTotalSum(n);
        int[] answer = new int[totalSumN];

        int i = 0, j = 0, k = 1;
        triangleArray[i][j] = k;

        // 삼각형 배열 숫자 입력
        while (k < totalSumN) {
            // 왼쪽 변
            while (i + 1 < n && k < totalSumN && triangleArray[i + 1][j] < 0) {
                triangleArray[++i][j] = ++k;
            }

            // 아래쪽 변
            while (j + 1 < n && k < totalSumN && triangleArray[i][j + 1] < 0) {
                triangleArray[i][++j] = ++k;
            }

            // 오른쪽 변
            while (i - 1 > 0 && k < totalSumN && triangleArray[i - 1][j - 1] < 0) {
                triangleArray[--i][--j] = ++k;
            }
        }

        k = 0;

        // 위에서 아래 순서대로 answer 배열에 입력
        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                answer[k++] = triangleArray[i][j];
            }
        }

        return answer;

        /*
        // cool answer
        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                matrix[x][y] = num++;
            }
        }

        int k = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
         */
    }
}
