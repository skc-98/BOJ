import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (cache.remove(city)) {
                answer++;
            } else {
                answer += 5;
            }
            if (cacheSize == 0) continue;
            cache.addLast(city);
            if (cache.size() > cacheSize) cache.removeFirst();
        }
        return answer;
    }
}