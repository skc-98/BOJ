import java.util.*;
class Solution {
    public int solution(int[] order) {
        Deque<Integer> deq = new ArrayDeque<>();
        int answer = 0;
        for (int i = 1; i <= order.length; i++) {
            deq.push(i);
            while (!deq.isEmpty() && deq.peek() == order[answer]) {
                deq.pop();
                answer++;
            }
        }
        return answer;
    }
}