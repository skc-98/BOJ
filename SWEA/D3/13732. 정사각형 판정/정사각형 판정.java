import java.util.*;
import java.io.*;

public class Solution {
    // 방향 벡터
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 맵 크기
            int n = Integer.parseInt(br.readLine());

            // 맵 입력
            char[][] d = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    d[i][j] = s.charAt(j);
                }
            }

            // BFS 세팅
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visit = new boolean[n][n];

            // BFS 시작
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 이미 두개 이상이면 정지
                    if (ans >= 2) break;

                    // 아직 방문하지 않은 곳만
                    if (!visit[i][j] && d[i][j] == '#') {
                        ans++;
                        q.add(new int[]{i, j});
                        visit[i][j] = true;

                        // 정사각형 판정 세팅
                        int minX = i, maxX = i, minY = j, maxY = j;
                        int cnt = 1;

                        // 큐가 빌 때까지
                        while (!q.isEmpty()) {
                            int x = q.peek()[0];
                            int y = q.peek()[1];
                            q.poll();

                            // 4방 탐색
                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];

                                // 범위 검사, 방문 검사, 상자 검사
                                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny] || d[nx][ny] != '#')
                                    continue;

                                // 큐에 넣고 진행
                                q.add(new int[]{nx, ny});
                                visit[nx][ny] = true;

                                cnt++;
                                minX = Math.min(minX, nx);
                                maxX = Math.max(maxX, nx);
                                minY = Math.min(minY, ny);
                                maxY = Math.max(maxY, ny);
                            }
                        }

                        // 정사각형 여부 확인
                        int h = maxX - minX + 1;
                        int w = maxY - minY + 1;
                        if (h != w || cnt != h * w) {
                            ans = 2;
                        }
                    }
                }
            }

            // 답 출력하기
            if (ans == 1) {
                System.out.printf("#%d yes\n", tc);
            } else {
                System.out.printf("#%d no\n", tc);
            }
        }
    }
}
