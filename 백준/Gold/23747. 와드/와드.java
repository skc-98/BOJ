import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 격자 입력 (1-index)
        char[][] d = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                d[i][j] = s.charAt(j - 1);
            }
        }

        // 시작 위치
        st = new StringTokenizer(br.readLine());
        int nowX = Integer.parseInt(st.nextToken());
        int nowY = Integer.parseInt(st.nextToken());

        // 이동 경로
        String route = br.readLine();

        // 정답 배열 초기화
        char[][] ans = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(ans[i], '#');
        }

        // 밝힌 구역 체크
        boolean[][] revealed = new boolean[n + 1][m + 1];

        // 이동 처리
        for (int i = 0; i < route.length(); i++) {
            char cmd = route.charAt(i);

            if (cmd == 'W') {
                // 와드 설치 → 같은 구역 BFS
                char alpha = d[nowX][nowY];
                if (!revealed[nowX][nowY]) {
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{nowX, nowY});
                    revealed[nowX][nowY] = true;
                    ans[nowX][nowY] = '.';

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0], y = cur[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                            if (revealed[nx][ny]) continue;
                            if (d[nx][ny] != alpha) continue;

                            revealed[nx][ny] = true;   // ✅ 수정된 부분
                            ans[nx][ny] = '.';
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            } else if (cmd == 'L') nowY--;
            else if (cmd == 'R') nowY++;
            else if (cmd == 'U') nowX--;
            else if (cmd == 'D') nowX++;
        }

        // 마지막 위치 + 상하좌우 밝히기
        ans[nowX][nowY] = '.';
        for (int k = 0; k < 4; k++) {
            int nx = nowX + dx[k];
            int ny = nowY + dy[k];
            if (1 <= nx && nx <= n && 1 <= ny && ny <= m) {
                ans[nx][ny] = '.';
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sb.append(ans[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
