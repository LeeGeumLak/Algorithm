package Programmers;

import java.util.Stack;

public class ParenthesisTransform {
    int pos;
    boolean isCorrect(String str) {
        boolean ret = true;

        int leftParenthesis = 0;
        int rightParenthesis = 0;

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < str.length(); ++i) {
            if(str.charAt(i) == '(') {
                leftParenthesis++;
                stack.push('(');
            }
            else {
                rightParenthesis++;

                if(stack.isEmpty()) {
                    ret = false;
                }
                else {
                    stack.pop();
                }
            }

            if(leftParenthesis == rightParenthesis) {
                pos = i + 1;
                break;
            }
        }

        return ret;
    }

    public String solution(String p) {
        // 괄호의 개수는 맞지만, 짝이 맞지 않는 상황
        // '(' , ')' 로만 이루어진 문자열에서 두개의 개수가 같으면 균형잡힌 괄호 문자열
        // 균형잡힌 괄호 문자열에서 두개의 짝도 모두 맞으면 올바른 괄호 문자열

        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        //    ( 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. )
        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        // 4-3. ')'를 다시 붙입니다.
        // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        // 4-5. 생성된 문자열을 반환합니다.

        // 입력 : '(' , ')' 로만 이루어진 균형잡힌 괄호 문자열 (2 ~ 1000 짝수)
        // 출력 : 변환한 올바른 괄호 문자열

        String answer = "";

        // 1번
        if(p.isEmpty()) return p;

        // 2번
        boolean correct = isCorrect(p);
        String u = p.substring(0, pos);
        String v = p.substring(pos, p.length());

        // 3번
        if(correct) {
            answer = u + solution(v);
        }
        // 4번
        else {
            answer = "(" + solution(v) + ")";

            // 4-4 번
            for(int i = 1; i < u.length() - 1; ++i) {
                if (u.charAt(i) == '(') {
                    answer += ")";
                }
                else {
                    answer += "(";
                }
            }
        }

        return answer;
    }
}
