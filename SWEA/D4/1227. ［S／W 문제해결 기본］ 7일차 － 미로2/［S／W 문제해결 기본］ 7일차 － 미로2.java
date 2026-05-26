import java.util.*;
import java.io.*;

public class Solution {
    // 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스는 10개
        for (int tc = 1; tc <= 10; tc++) {
            // 테스트 케이스의 번호 입력
            int tcn = Integer.parseInt(br.readLine());

            // 크기는 항상 100*100
            int startX = 0, startY = 0;
            int endX = 0, endY = 0;
            char[][] d = new char[100][100];
            for (int i = 0; i < 100; i++) {
                String s = br.readLine();
                for (int j = 0; j < 100; j++) {
                    d[i][j] = s.charAt(j);

                    // 출발점 저장
                    if (d[i][j] == '2') {
                        startX = i;
                        startY = j;
                    }

                    // 종료 지점 저장
                    else if (d[i][j] == '3') {
                        endX = i;
                        endY = j;
                    }
                }
            }

            // BFS 세팅
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visit = new boolean[100][100];
            q.add(new int[]{startX, startY});
            visit[startX][startY] = true;

            // BFS 시작
            while (!q.isEmpty()) {
                int x = q.peek()[0];
                int y = q.peek()[1];
                q.poll();

                // 4방 탐색
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    // 범위 검사, 방문 검사, 벽 검사
                    if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || visit[nx][ny] || d[nx][ny] == '1') {
                        continue;
                    }

                    q.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                }
            }

            // 모든 탐색이 끝나고 도착 했는지 확인
            if (visit[endX][endY]) {
                System.out.printf("#%d 1\n", tc);
            } else {
                System.out.printf("#%d 0\n", tc);
            }
        }
    }
}
