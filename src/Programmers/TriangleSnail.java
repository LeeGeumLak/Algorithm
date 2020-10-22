package Programmers;

public class TriangleSnail {
    public static int calculateFactorial(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return calculateFactorial(n - 1) * n;
        }
    }

    public int[] solution(int n) {
        // 입력 : n
        // 출력 : 높이가 n인 삼각형
        //       단, 맨 위 꼭지점부터 반시계 방향으로 숫자를 채우고
        //           출력은 위에서 아래 순서대로
        /* 예시
                1
              2   9
            3   10  8
          4   5   6   7
        */

        int[] answer = {};

        int[] triangleArray = new int[calculateFactorial(n)];

        // ( 아래로 높이 n 만큼 -> 가로로 길이 n-1 만큼 -> 위로 높이 n-2 만큼 ) 반복
        

        return answer;
    }
}
