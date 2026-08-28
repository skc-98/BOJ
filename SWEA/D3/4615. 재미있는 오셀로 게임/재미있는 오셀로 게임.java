import java.util.*;
import java.io.*;

public class Solution {
    // 방향 벡터
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 보드 한 변의 길이, 돌을 놓는 횟수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 보드 생성, 초기 배치
            int[][] map = new int[n + 1][n + 1];
            int mid = n / 2;
            map[mid][mid] = 2;
            map[mid + 1][mid + 1] = 2;
            map[mid][mid + 1] = 1;
            map[mid + 1][mid] = 1;

            // m번 돌을 놓으며 게임 진행
            for (int i = 0; i < m; i++) {
                // 돌을 놓을 열, 행, 색 입력
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());
                map[y][x] = color;

                // 상대 돌의 색 결정
                int enemy;
                if (color == 1) {
                    enemy = 2;
                } else {
                    enemy = 1;
                }

                // 8방향 탐색
                for (int k = 0; k < 8; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];

                    // 바로 옆에 상대 돌이 없으면 스킵
                    if (ny < 1 || ny > n || nx < 1 || nx > n || map[ny][nx] != enemy) {
                        continue;
                    }

                    // 상대 돌 다음 위치부터 같은 방향으로 탐색
                    int checkY = ny + dy[k];
                    int checkX = nx + dx[k];

                    // 같은 방향으로 상대 돌이 이어지는 동안 이동
                    while (checkY >= 1 && checkY <= n && checkX >= 1 && checkX <= n && map[checkY][checkX] == enemy) {
                        checkY += dy[k];
                        checkX += dx[k];
                    }

                    // 끝에 자신의 돌이 존재하지 않으면 뒤집지 않음
                    if (checkY < 1 || checkY > n || checkX < 1 || checkX > n || map[checkY][checkX] != color) {
                        continue;
                    }

                    // 사이에 있는 상대 돌을 자신의 돌로 변경
                    while (ny != checkY || nx != checkX) {
                        map[ny][nx] = color;
                        ny += dy[k];
                        nx += dx[k];
                    }
                }
            }

            // 게임 종료 후 흑돌과 백돌의 개수 저장
            int black = 0;
            int white = 0;

            // 보드 전체를 확인하며 돌의 개수 계산
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][j] == 1) {
                        black++;
                    } else if (map[i][j] == 2) {
                        white++;
                    }
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d %d\n", tc, black, white);
        }
    }
}
