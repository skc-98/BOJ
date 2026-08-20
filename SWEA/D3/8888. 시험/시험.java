import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 참가자 수, 문제 수, 지학이 번호
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            // 참가자 별 풀이여부, 각 문제 점수, 참가자별 푼 문제 수
            int[][] d = new int[n][t];
            int[] problemScore = new int[t];
            int[] count = new int[n];

            // 참가자별 문제 풀이 여부 입력
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < t; j++) {
                    d[i][j] = Integer.parseInt(st.nextToken());

                    // 문제를 풀지 못한 참가자 수가 해당 문제의 점수
                    if (d[i][j] == 0) {
                        problemScore[j]++;
                    } else {
                        count[i]++;
                    }
                }
            }

            // 각 참가자의 점수 계산
            int[] score = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < t; j++) {
                    // 해당 문제를 풀었다면 문제 점수 획득
                    if (d[i][j] == 1) {
                        score[i] += problemScore[j];
                    }
                }
            }

            // 다른 참가자들과 비교
            int target = p - 1, rank = 1;
            for (int i = 0; i < n; i++) {
                // 자기 자신은 제외
                if (i == target) {
                    continue;
                }

                // 지학이랑 점수 비교
                if (score[i] > score[target]) {
                    rank++;
                } else if (score[i] == score[target]) {
                    // 지학이보다 더 많은 문제를 푼 경우
                    if (count[i] > count[target]) {
                        rank++;
                    }
                    // 푼 문제 수도 같은 경우
                    else if (count[i] == count[target]) {
                        // 참가자 번호가 더 작은 경우
                        if (i < target) {
                            rank++;
                        }
                    }
                }
            }

            // 답 출력하기
            System.out.printf("#%d %d %d\n", tc, score[target], rank);
        }
    }
}