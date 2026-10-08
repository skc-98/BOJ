import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            q.add(i);
            visit[i] = true;
            answer++;
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int j = 0; j < n; j++) {
                    if (computers[now][j] == 1 && !visit[j]) {
                        visit[j] = true;
                        q.add(j);
                    }
                }
            }
        }
        return answer;
    }
}