package Programmers;

public class JoyStick {
    public int solution(String name) {
        // 조이스틱으로 이름 완성, 맨 처음엔 A로만 이루어짐
        // 위 : 다음 알파벳, 아래 : 이전 알파벳(A에서는 Z로), 왼/오 : 커서 이동 (단, 첫번째에서 왼쪽 이동시 마지막으로)
        // 입력 : 만들고자 하는 이름의 문자열
        // 출력 : 최소 조작횟수
        // A : 65 ~ Z : 90

        int answer = 0;

        // 알파벳 이동
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {

                int up = name.charAt(i) - 'A';
                int down = 1 + 'Z' - name.charAt(i);

                if (up < down) answer += up;
                else answer += down;
            }
        }

        // 커서 이동
        int minMove = name.length() - 1; // 왼쪽으로 이동했을 때
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                int next = i + 1;

                while (next < name.length() && name.charAt(next) == 'A') {
                    next++;
                }

                int move = 2 * i + name.length() - next;
                minMove = Math.min(move, minMove);
            }
        }

        return answer + minMove;
    }
}
