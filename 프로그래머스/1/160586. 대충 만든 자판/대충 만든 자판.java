import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                map.put(c, Math.min(map.getOrDefault(c, 101), j + 1));
            }
        }
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if (!map.containsKey(c)) {
                    sum = -1;
                    break;
                }
                sum += map.get(c);
            }
            answer[i] = sum;
        }
        return answer;
    }
}