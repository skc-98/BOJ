class Solution {
    // 방향 벡터
    int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        boolean[][] d = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 9; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        
                        // 범위 검사
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        d[nx][ny] = true;
                    }
                }
            }
        }
        // 안전 지역 개수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!d[i][j]) answer++;
            }
        }
        return answer;
    }
}