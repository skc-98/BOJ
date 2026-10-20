import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> idx = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(priorities[i]);
            idx.offer(i);
        }
        int a = 0;
        while (!q.isEmpty()) {
            int p = q.poll();
            int n = idx.poll();
            if (!q.isEmpty() && Collections.max(q) > p) {
                q.offer(p);
                idx.offer(n);
            } else {
                a++;
                if (n == location) return a;
            }
        }
        return a;
    }
}