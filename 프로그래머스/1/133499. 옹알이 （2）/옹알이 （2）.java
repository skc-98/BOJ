import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            String str = babbling[i];
            String prev = "";
            boolean check = true;
            while (!str.isEmpty()) {
                boolean found = false;
                for (int j = 0; j < words.length; j++) {
                    if (str.startsWith(words[j]) && !prev.equals(words[j])) {
                        str = str.substring(words[j].length());
                        prev = words[j];
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    check = false;
                    break;
                }
            }
            if (check) answer++;
        }
        return answer;
    }
}