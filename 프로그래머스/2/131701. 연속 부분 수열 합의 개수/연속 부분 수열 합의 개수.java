import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        int n = elements.length;
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int length = 1; length <= n; length++) {
                sum += elements[(start + length - 1) % n];
                sums.add(sum);
            }
        }
        return sums.size();
    }
}