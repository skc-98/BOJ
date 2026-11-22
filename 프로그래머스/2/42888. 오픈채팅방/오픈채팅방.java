import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> m = new HashMap<>();
        List<String> a = new ArrayList<>();
        String[] s;
        for (int i = 0; i < record.length; i++) {
            s = record[i].split(" ");
            if (s[0].equals("Enter") || s[0].equals("Change")) {
                m.put(s[1], s[2]);
            }
        }
        for (int i = 0; i < record.length; i++) {
            s = record[i].split(" ");
            if (s[0].equals("Enter")) {
                a.add(m.get(s[1]) + "님이 들어왔습니다.");
            } else if (s[0].equals("Leave")) {
                a.add(m.get(s[1]) + "님이 나갔습니다.");
            }
        }
        answer = a.toArray(new String[0]);
        return answer;
    }
}