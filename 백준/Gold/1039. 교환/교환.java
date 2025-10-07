import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 숫자를 문자열로 변환
		String s = String.valueOf(n);

		// BFS용 큐랑 방문 배열 생성
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[m + 1][1000001];

		// 큐에 시작 상태 삽입, 방문 처리
		q.add(new int[] { n, 0 });
		visit[0][n] = true;

		// 정답 변수
		int ans = -1;

		// BFS 시작
		while (!q.isEmpty()) {
			int num = q.peek()[0];
			int depth = q.peek()[1];
			q.poll();

			// 교환 횟수만큼 했으면 최댓값 갱신
			if (depth == m) {
				ans = Math.max(ans, num);
				continue;
			}

			// 자릿수 분리
			char[] d = String.valueOf(num).toCharArray();

			// 가능한 모든 자릿수 교환
			for (int i = 0; i < d.length - 1; i++) {
				for (int j = i + 1; j < d.length; j++) {
					// 자릿수 교환
					char temp = d[i];
					d[i] = d[j];
					d[j] = temp;

					// 맨 앞이 0이면 원상 복구 후 넘기기
					if (d[0] == '0') {
						char t2 = d[i];
						d[i] = d[j];
						d[j] = t2;
						continue;
					}

					// 새로운 숫자로 변환
					int next = Integer.parseInt(new String(d));

					// 아직 방문 안 했으면 다음 단계로 추가
					if (!visit[depth + 1][next]) {
						visit[depth + 1][next] = true;
						q.add(new int[] { next, depth + 1 });
					}

					// 다음 교환을 위해 swap 원상복구
					char t3 = d[i];
					d[i] = d[j];
					d[j] = t3;
				}
			}
		}

		// 답 출력하기
		System.out.println(ans);
	}
}
