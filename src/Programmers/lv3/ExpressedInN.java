package Programmers.lv3;

/*
다른 문제와는 다르게 answer의 초기값을 -1로 했습니다. 원래는 최소값이 나올 때 초기값으로 정수의 최대값을 주면,
최소값 비교에서 answer이 cnt보다 작은 값으로 간주됨 (cnt가 dfs에서 크게 증가)
그래서 answer = -1로 두고 number == prev(연산 결과값) 일 때, answer == -1 || answer > cnt 라면 answer = cnt
그리고 사칙연산을 진행.

테스트 케이스 예제
[ N = 5 / number = 12 ]
12 = 5 + 5 + (5 / 5) + (5 / 5)
12 = 55 / 5 + 5 / 5
12 = (55 + 5) / 5

N을 55로 만들어서 연산을 진행합니다. 이 부분을 처리하기 위해 사칙연산을 진행한 후에
N과 같은 값의 temp_N을 생성해서 temp_N *10 + N으로 N의 값을 변경 / N으로 나누는 게 아니라 temp_N으로 나눔
*/

public class ExpressedInN {
    private static int answer = -1;

    public int solution(int N, int number) {
        // 입력받은 숫자 N과 사칙연산만을 사용해서 number를 표현할 때,
        // 숫자 N을 사용하는 횟수의 최솟값 return
        // 최솟값이 8보다 크면 -1 return

        dfs(N, number, 0, 0);

        return answer;
    }

    static void dfs(int N, int number , int cnt, int prev) {
        //N의 카운트를 늘려가며 dfs 로 수행한다.
        //그 값을 저장하고 그 값이 number와 동일한지 확인한다.
        int temp_N = N;

        if (cnt > 8) {
            answer = -1;
            return;
        }

        if (number == prev ) {
            if (answer == -1 || answer > cnt)
                answer = cnt;
            return;
        }

        for (int i = 0; i < 8-cnt; i++) {
            dfs(N, number, cnt+i+1, prev-temp_N);
            dfs(N, number, cnt+i+1, prev+temp_N);
            dfs(N, number, cnt+i+1, prev*temp_N);
            dfs(N, number, cnt+i+1, prev/temp_N);

            // 5 -> 55
            temp_N = temp_N * 10 + N;
        }
    }
}
