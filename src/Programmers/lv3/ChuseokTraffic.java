package Programmers.lv3;

public class ChuseokTraffic {
    public int solution(String[] lines) {
        // 초당 최대 처리량 = 임의의 시간부터 1초간 처리하는 요청의 최대 개수 (요청 응답 완료 여부 관계X)
        // lines 배열 : N개의 로그 문자열, 각 문자열마다 요청에 대한 응답완료시간 S와 처리시간 T가 공백으로 구분
        // 응답완료시간 S : 2016-09-15 hh:mm:ss.sss , 처리시간 T : 0.1s, 0.2s, ...(최대 소수점 셋째 자리까지)
        // lines 배열은 응답완료시간 S 기준 오름차순으로 정렬
        // ** 출력 : 초당 최대 처리량

        int answer = 0;

        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];

        // 시작점 = 응답완료시간 - 처리시간 + 1ms
        // 1. 시작점이 범위(작업 시작 ~ 작업 종료)에 걸쳐있는 경우
        // 2. 끝점이 범위(작업 시작 ~ 작업 종료)에 걸쳐있는 경우
        // 3. 로그가 범위(작업 시작 ~ 작업 종료)를 포함하고 있는 경우

        getTimes(lines, startTimes, endTimes);

        // 시작점 : startTimes
        for(int i = 0 ; i < lines.length ; ++i) {
            int cnt = 0;
            int startOfSection = startTimes[i];
            int endOfSection = startOfSection + 1000;

            for(int j = 0 ; j < lines.length ; ++j) {
                // 1. 시작점이 범위(작업 시작 ~ 작업 종료)에 걸쳐있는 경우
                if(startTimes[j] >= startOfSection && startTimes[j] < endOfSection) {
                    cnt++;
                }
                // 2. 끝점이 범위(작업 시작 ~ 작업 종료)에 걸쳐있는 경우
                else if(endTimes[j] >= startOfSection && endTimes[j] < endOfSection) {
                    cnt++;
                }
                // 3. 로그가 범위(작업 시작 ~ 작업 종료)를 포함하고 있는 경우
                else if(startTimes[j] <= startOfSection && endTimes[j] >= endOfSection) {
                    cnt++;
                }
            }

            answer = Math.max(cnt, answer);
        }

        // 시작점 : endTimes
        for(int i = 0 ; i < lines.length ; ++i) {
            int cnt = 0;
            int startOfSection = endTimes[i];
            int endOfSection = startOfSection + 1000;

            for(int j = 0 ; j < lines.length ; ++j) {
                // 1. 시작점이 범위(작업 시작 ~ 작업 종료)에 걸쳐있는 경우
                if(startTimes[j] >= startOfSection && startTimes[j] < endOfSection) {
                    cnt++;
                }
                // 2. 끝점이 범위(작업 시작 ~ 작업 종료)에 걸쳐있는 경우
                else if(endTimes[j] >= startOfSection && endTimes[j] < endOfSection) {
                    cnt++;
                }
                // 3. 로그가 범위(작업 시작 ~ 작업 종료)를 포함하고 있는 경우
                else if(startTimes[j] <= startOfSection && endTimes[j] >= endOfSection) {
                    cnt++;
                }
            }

            answer = Math.max(cnt, answer);
        }

        return answer;
    }

    public void getTimes(String[] lines, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < lines.length; ++i) {
            String[] log = lines[i].split(" ");
            String[] responseTime = log[1].split(":");

            int processingTime = (int)(Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);

            int startTime;
            int endTime = 0;

            endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(responseTime[1]) * 60 * 1000;
            endTime += (int)(Double.parseDouble(responseTime[2]) * 1000);
            startTime = endTime - processingTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }
}
