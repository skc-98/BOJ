import java.util.*;

class Solution {
    public String solution(String new_id) {
        String s = new_id.toLowerCase();
        s = s.replaceAll("[^a-z0-9._-]", "");
        s = s.replaceAll("\\.{2,}", ".");
        s = s.replaceAll("^\\.|\\.$", "");
        if(s.length() == 0) s = "a";
        if(s.length() > 15) s = s.substring(0, 15);
        s = s.replaceAll("\\.$", "");
        for(int i = s.length(); i < 3; i++) {
            s += s.charAt(s.length() - 1);
        }
        return s;
    }
}