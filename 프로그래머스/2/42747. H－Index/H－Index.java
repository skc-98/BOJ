import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (citations[n - 1 - i] >= i + 1) ans = i + 1;
            else break;
        }
        return ans;
    }
}