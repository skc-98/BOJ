import java.util.*;
import java.io.*;

public class Main{
    // 도시 크기
    static int n;
    // 도시 상태 저장
    static char[][] d;

    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시 크기 입력
        n = Integer.parseInt(br.readLine());

        // 도시 상태 저장할 배열
        d = new char[n][n];

        // 도시 상태 입력
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                d[i][j] = s.charAt(j);
                if (d[i][j] == '.')
                    d[i][j] = 'B';  // 일단 모든 빈칸에 폭탄 설치 가정
            }
        }

        // 멀쩡한 건물 기준으로 폭탄 설치 불가능한 칸 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == 'O') {
                    // 4방향 메서드
                    up(i, j);
                    down(i, j);
                    right(i, j);
                    left(i, j);
                }
            }
        }

        // 답 출력하기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(d[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    // 윗방향 메서드
    static void up(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (d[i][y] == 'O' || d[i][y] == 'X') break;  // 건물(잔해) 만나면 중단
            if (d[i][y] == 'B') d[i][y] = '.';          // 폭탄 설치 불가 표시
        }
    }

    // 아랫방향 메서드
    static void down(int x, int y) {
        for (int i = x + 1; i < n; i++) {
            if (d[i][y] == 'O' || d[i][y] == 'X') break;
            if (d[i][y] == 'B') d[i][y] = '.';
        }
    }

    // 오른방향 메서드
    static void right(int x, int y) {
        for (int i = y + 1; i < n; i++) {
            if (d[x][i] == 'O' || d[x][i] == 'X') break;
            if (d[x][i] == 'B') d[x][i] = '.';
        }
    }

    // 왼방향 메서드
    static void left(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (d[x][i] == 'O' || d[x][i] == 'X') break;
            if (d[x][i] == 'B') d[x][i] = '.';
        }
    }
}
