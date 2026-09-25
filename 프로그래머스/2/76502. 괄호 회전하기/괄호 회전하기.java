import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            Stack<Character> stack = new Stack<>();
            boolean valid = true;
            for (int j = 0; j < rotated.length(); j++) {
                char c = rotated.charAt(j);
                if (c == '(' || c == '[' || c == '{') stack.push(c);
                else {
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    char top = stack.pop();
                    if (c == ')' && top != '(') valid = false;
                    if (c == ']' && top != '[') valid = false;
                    if (c == '}' && top != '{') valid = false;
                    if (!valid) break;
                }
            }
            if (valid && stack.isEmpty()) answer++;
        }
        return answer;
    }
}