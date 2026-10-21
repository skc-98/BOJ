class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int[] a = new int[n * 2];
        long sum = 0, s = 0;
        for (int i = 0; i < n; i++) {
            a[i] = queue1[i];
            a[i + n] = queue2[i];
            s += queue1[i];
            sum += (long) queue1[i] + queue2[i];
        }
        if (sum % 2 != 0) return -1;
        int i = 0, j = n;
        for (int k = 0; k < n * 4; k++) {
            if (s == sum / 2) return k;
            if (s > sum / 2) s -= a[i++ % (n * 2)];
            else s += a[j++ % (n * 2)];
        }
        return -1;
    }
}