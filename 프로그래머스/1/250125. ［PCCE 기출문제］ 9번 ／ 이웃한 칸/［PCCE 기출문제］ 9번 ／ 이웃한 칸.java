class Solution {
    // 방향 벡터
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        for (int i = 0; i < 4; i++) {
            int x = h + dx[i];
            int y = w + dy[i];

            if (x >= 0 && x < n && y >= 0 && y < n) {
                if (board[h][w].equals(board[x][y])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}