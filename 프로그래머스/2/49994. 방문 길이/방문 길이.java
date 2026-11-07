import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> set = new HashSet<>();
        int x = 0, y = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int nx = x, ny = y;
            char c = dirs.charAt(i);
            if (c == 'U') ny++;
            else if (c == 'D') ny--;
            else if (c == 'R') nx++;
            else if (c == 'L') nx--;
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            String a = x + "," + y + "," + nx + "," + ny;
            String b = nx + "," + ny + "," + x + "," + y;
            set.add(a);
            set.add(b);
            x = nx;
            y = ny;
        }
        return set.size() / 2;
    }
}