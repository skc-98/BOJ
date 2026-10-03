import java.util.*;
class Solution {
    static List<String> dictionary = new ArrayList<>();
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        dictionary.clear();
        dfs("");
        return dictionary.indexOf(word) + 1;
    }

    static void dfs(String word) {
        if (!word.isEmpty()) {
            dictionary.add(word);
        }

        if (word.length() == 5) {
            return;
        }

        for (int i = 0; i < vowels.length; i++) {
            dfs(word + vowels[i]);
        }
    }
}