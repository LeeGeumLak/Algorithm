package Programmers;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // 초 단위로 기록된 주식가격 배열 = prices
        // 가격이 떨어지지 않은 기간은 몇 초인지 = answer

        int timeCount =0 ;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1;j < prices.length; j++) {
                if(prices[i] <= prices[j]) {
                    timeCount++;
                }
                else if(prices[i]>prices[j]) {
                    timeCount++;
                    break;
                }
            }

            answer[i] = timeCount;

            timeCount = 0;
        }

        return answer;
    }
}
