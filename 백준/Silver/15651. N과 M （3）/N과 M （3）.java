import java.io.*;

public class Main {
    static int n, m;
    static int[] numbers;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n과 m 입력
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        numbers = new int[m]; // 선택한 숫자를 저장할 배열

        backTracking(0);
        bw.flush();  // 출력 버퍼 비우기
        bw.close();
    }

    static void backTracking(int depth) throws IOException {
        if (depth == m) { // m개의 숫자를 선택했을 때 출력
            for (int i = 0; i < m; i++) {
                bw.write(numbers[i] + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= n; i++) {
            numbers[depth] = i; // 숫자 선택
            backTracking(depth + 1); // 다음 깊이 탐색
        }
    }
}
