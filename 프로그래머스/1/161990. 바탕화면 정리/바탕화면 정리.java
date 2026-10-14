import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int a = 50, b = 50, c = 0, d = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    a = Math.min(a, i);
                    b = Math.min(b, j);
                    c = Math.max(c, i + 1);
                    d = Math.max(d, j + 1);
                }
            }
        }
        return new int[]{a, b, c, d};
    }
}