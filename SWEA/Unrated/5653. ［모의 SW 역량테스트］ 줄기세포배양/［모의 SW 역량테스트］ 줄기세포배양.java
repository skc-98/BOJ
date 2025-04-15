import java.util.*;
import java.io.*;

public class Solution {
    // 4방향 탐색용
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수 입력
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 답이 될 변수
            int ans = 0;

            // 영역의 크기와 시간 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 배열 초기화, 양쪽으로 k만큼 거리 줘야함
            int[][] d = new int[n + (k * 2)][m + (k * 2)];

            // 활성 상태 여부 확인할 논리형 배열, 방문 처리
            boolean[][] activate = new boolean[n + (k * 2)][m + (k * 2)];
            boolean[][] used = new boolean[n + (k * 2)][m + (k * 2)];

            // 시간 측정할 배열
            int[][] timeCount = new int[n + (k * 2)][m + (k * 2)];

            // 그리드 상태 정보 입력, 배열의 중앙에 넣기 위해 k만큼 벌리는게 포인트임
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    // 배열에 넣으면서 시간 정보도 초기화
                    d[i + k][j + k] = Integer.parseInt(st.nextToken());
                    timeCount[i + k][j + k] = d[i + k][j + k];
                }
            }

            // 우선순위 큐 선언: 생명력이 높은 세포가 우선적으로 번식하도록 처리
            // (PQ 비교 시 d[][]에 기록된 생명력 값을 이용)
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    // a와 b는 int[] {x, y} 형태로 저장되어 있으며,
                    // d[x][y] 값이 큰(= 생명력이 큰) 세포가 먼저 오도록 내림차순 정렬
                    return d[b[0]][b[1]] - d[a[0]][a[1]];
                }
            });

            // BFS 방식(시간마다 전체 격자를 순회하며 활성화 및 번식)을 우선순위 큐를 활용하여 확장 처리
            int time = 0;
            while (time < k) {
                // 시간 증가
                time++;

                // 각 세포의 활성 시간 감소
                for (int i = 0; i < (2 * k) + n; i++) {
                    for (int j = 0; j < (2 * k) + m; j++) {
                        // 시간 감소
                        if (timeCount[i][j] > 0) {
                            timeCount[i][j]--;
                            // 감소해서 0이 되면 활성 상태로 전환
                            if (timeCount[i][j] == 0) {
                                activate[i][j] = true;
                            }
                        }
                    }
                }

                // 우선순위 큐에서 번식 가능한 세포들을 처리 (생명력 값 높은 세포 우선)
                while (!pq.isEmpty()) {
                    int[] cur = pq.poll();
                    int x = cur[0];
                    int y = cur[1];
                    used[x][y] = true;
                    activate[x][y] = false;

                    // 현재 세포가 시간 k에서 살아있다면 카운트 (조건: d[x][y] + time - 1 > k)
                    if (d[x][y] + time - 1 > k)
                        ans++;

                    // 활성 세포 기준으로 4방향 탐색, 번식 가능한 칸으로 확장
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        // 범위 검사
                        if (nx < 0 || nx >= (2 * k) + n || ny < 0 || ny >= (2 * k) + m)
                            continue;

                        // 번식 가능한지 확인하고 가능하면 번식 처리
                        if (d[nx][ny] == 0) {
                            d[nx][ny] = d[x][y];
                            timeCount[nx][ny] = d[nx][ny];
                        }

                        // 이번 확장에 새로 추가된 칸에서, 만약 현재 번식하는 세포의 생명력이 더 크다면 업데이트
                        if (d[nx][ny] == timeCount[nx][ny] && d[x][y] > d[nx][ny]) {
                            d[nx][ny] = d[x][y];
                            timeCount[nx][ny] = d[nx][ny];
                        }
                    }
                }

                // 배열 전체 순회하면서 활성 상태이며 아직 번식하지 않은 세포를 우선순위 큐에 추가
                for (int i = 0; i < (2 * k) + n; i++) {
                    for (int j = 0; j < (2 * k) + m; j++) {
                        if (activate[i][j] && !used[i][j]) {
                            pq.add(new int[] { i, j });
                            activate[i][j] = false;
                        }
                    }
                }
            }

            // 시뮬레이션 종료 후 살아있는 세포 카운트 (d[i][j] != 0 && 아직 번식하지 않은 세포)
            for (int i = 0; i < (2 * k) + n; i++) {
                for (int j = 0; j < (2 * k) + m; j++) {
                    if (d[i][j] != 0 && !used[i][j]) {
                        ans++;
                    }
                }
            }

            // 답 출력
            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}
