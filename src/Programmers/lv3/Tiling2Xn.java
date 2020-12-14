package Programmers.lv3;

public class Tiling2Xn {
    public int solution(int n) {
        // 가로가 2, 세로가 1인 직사각형 타일
        // 세로가 2이고, 가로가 n인 바닥 가득 채우기
        // 가로 길이 n이 주어질 때, 바닥을 채우는 방법의 수 return
        // * 경우의 수가 많아질 수 있으므로, 경우의 수를 1,000,000,007로 나눈 나머지 return
        // * 1 <= n <= 60,000 의 자연수

        int answer = 0;

        // case(n-3) = case(n-1) + case(n-2)

        int firstElement = 1;
        int secondElement = 1;

        for (int i = 0; i < n - 1; i++) {
            // 숫자가 너무 커지는 것을 방지하기 위해 나머지를 구한다.
            int thirdElement = (firstElement + secondElement) % 1000000007;
            firstElement = secondElement;
            secondElement = thirdElement;
        }

        return secondElement;
    }
}
