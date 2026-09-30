class Solution {
    public int solution(int[] topping) {
        int answer = 0, left = 0, right = 0;
        int[] count = new int[10001];
        boolean[] seen = new boolean[10001];
        for (int i = 0; i < topping.length; i++) {
            if (count[topping[i]] == 0) right++;
            count[topping[i]]++;
        }
        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];
            if (!seen[t]) {
                seen[t] = true;
                left++;
            }
            if (--count[t] == 0) right--;
            if (left == right) answer++;
        }
        return answer;
    }
}