class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        int l = 1;
        for (int i = 0; i < signals.length; i++) {
            int p = signals[i][0] + signals[i][1] + signals[i][2];
            int a = l, b = p;
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            l = l / a * p;
        }
        for (int i = 1; i <= l; i++) {
            boolean ok = true;
            for (int j = 0; j < signals.length; j++) {
                int p = signals[j][0] + signals[j][1] + signals[j][2];
                int t = (i - 1) % p;
                if (t < signals[j][0] || t >= signals[j][0] + signals[j][1]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}