import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> count = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(report));
        for (String s : set) {
            String[] arr = s.split(" ");
            count.put(arr[1], count.getOrDefault(arr[1], 0) + 1);
        }
        for (String s : set) {
            String[] arr = s.split(" ");
            if (count.get(arr[1]) >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (id_list[i].equals(arr[0])) {
                        answer[i]++;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}