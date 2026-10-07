import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long[] factorial = new long[n + 1];
        List<Integer> list = new ArrayList<>();
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            list.add(i);
        }
        k--;
        for (int i = 0; i < n; i++) {
            long size = factorial[n - i - 1];
            int index = (int)(k / size);
            answer[i] = list.remove(index);
            k %= size;
        }
        return answer;
    }
}