import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            q.offer((long) scoville[i]);
        }
        int answer = 0;
        while (q.peek() < K) {
            if (q.size() < 2) {
                return -1;
            }
            long a = q.poll();
            long b = q.poll();
            q.offer(a + b * 2);
            answer++;
        }
        return answer;
    }
}