import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] arr = s.substring(2, s.length() - 2).split("\\},\\{");
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int[] answer = new int[arr.length];
        Set<Integer> set = new HashSet<>();
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            String[] nums = arr[i].split(",");
            for (int j = 0; j < nums.length; j++) {
                int num = Integer.parseInt(nums[j]);
                if (set.add(num)) {
                    answer[idx++] = num;
                }
            }
        }
        return answer;
    }
}