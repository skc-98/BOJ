import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int t = 1, s = 0, i = 0;
        while (i < truck_weights.length) {
            while (!q.isEmpty() && q.peek()[1] <= t) {
                s -= q.poll()[0];
            }
            if (q.size() < bridge_length && s + truck_weights[i] <= weight) {
                q.offer(new int[]{truck_weights[i], t + bridge_length});
                s += truck_weights[i++];
                t++;
            } else {
                t = q.peek()[1];
            }
        }
        answer = t + bridge_length - 1;
        return answer;
    }
}