package Programmers;

// 완전탐색
public class Carpet {
    public int[] solution(int brown, int yellow) {
        // 카펫의 갈색과 노란색의 개수를 가지고 카펫의 가로, 세로 크기를 구하기
        int[] answer = new int[2];

        int sum = (brown+4) / 2;
        int m = 3;
        int n = sum - m;

        while(n >= 3 && n >= m) {
            if((n-2) * (m-2) == yellow) {
                answer[0] = n;
                answer[1] = m;
                break;
            }

            n--;
            m++;
        }

        return answer;
    }
}
