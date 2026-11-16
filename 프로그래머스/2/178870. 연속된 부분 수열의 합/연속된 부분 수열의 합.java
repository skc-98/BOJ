class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length};
        int i = 0, sum = 0;
        for (int j = 0; j < sequence.length; j++) {
            sum += sequence[j];
            while (sum > k) {
                sum -= sequence[i++];
            }
            if (sum == k && j - i < answer[1] - answer[0]) {
                answer[0] = i;
                answer[1] = j;
            }
        }
        return answer;
    }
}