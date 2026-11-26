import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            for (int j = 0; j < 2; j++) {
                String[] t = book_time[i][j].split(":");
                time[i][j] = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            }
            time[i][1] += 10;
        }
        Arrays.sort(time, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < time.length; i++) {
            if (!pq.isEmpty() && pq.peek() <= time[i][0]) {
                pq.poll();
            }
            pq.offer(time[i][1]);
        }
        answer = pq.size();
        return answer;
    }
}