import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }

        for(int i=0; i<callings.length; i++){
            String player = callings[i];

            int index = map.get(player);
            String frontPlayer = players[index-1];

            players[index-1] = player;
            players[index] = frontPlayer;

            map.put(player, index-1);
            map.put(frontPlayer, index);
        }

        answer = players;
        return answer;
    }
}