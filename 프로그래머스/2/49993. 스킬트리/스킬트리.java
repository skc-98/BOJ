class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            int j = 0;
            for (int k = 0; k < skill_trees[i].length(); k++) {
                if (skill.indexOf(skill_trees[i].charAt(k)) == -1) {
                    continue;
                }
                if (j >= skill.length() || skill_trees[i].charAt(k) != skill.charAt(j)) {
                    break;
                }
                j++;
            }
            if (j == skill_trees[i].replaceAll("[^" + skill + "]", "").length()) {
                answer++;
            }
        }
        return answer;
    }
}