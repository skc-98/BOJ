class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i <= discount.length - 10; i++) {
            int matched = 0;
            for (int j = 0; j < want.length; j++) {
                int count = 0;
                for (int k = i; k < i + 10; k++) {
                    if (want[j].equals(discount[k])) count++;
                }
                if (count == number[j]) matched++;
            }
            if (matched == want.length) answer++;
        }
        return answer;
    }
}