class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String s = "";
        int i = 0;
        while (s.length() < t * m) {
            s += Integer.toString(i++, n).toUpperCase();
        }
        for (int j = p - 1; answer.length() < t; j += m) {
            answer += s.charAt(j);
        }
        return answer;
    }
}