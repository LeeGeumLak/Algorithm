package Programmers;

// dfs/ bfs
public class TargetNumber {
    public int solution(int[] numbers, int target) {
        // n개의 음이 아닌 정수, 이 수를 적절히 더하거나 빼서 다켓 넘버를 만들고자 함
        // 사용할 수 있는 숫자가 담긴 배열로 타겟 넘버를 만들 수 있는 방법의 수는?

        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    public static int dfs(int[] numbers, int node, int sum, int target) {
        if(node == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs(numbers, node+1, sum + numbers[node], target)
                + dfs(numbers, node+1, sum - numbers[node], target);
    }
}
