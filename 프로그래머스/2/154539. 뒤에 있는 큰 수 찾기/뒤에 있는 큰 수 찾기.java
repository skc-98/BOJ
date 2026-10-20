import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] a = new int[n];
        Arrays.fill(a, -1);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && numbers[s.peek()] < numbers[i]) {
                a[s.pop()] = numbers[i];
            }
            s.push(i);
        }
        return a;
    }
}