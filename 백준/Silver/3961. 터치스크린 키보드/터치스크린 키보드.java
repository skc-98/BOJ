import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 키보드 좌표 매핑
		Map<Character, int[]> pos = new HashMap<>();
		String[] keyRows = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
		for (int r = 0; r < keyRows.length; r++) {
			for (int c = 0; c < keyRows[r].length(); c++) {
				pos.put(keyRows[r].charAt(c), new int[] { r, c });
			}
		}

		// 테스트케이스의 수
		int tcn = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tcn; tc++) {
			// 사용자 입력 단어, 프로그램 단어 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			int n = Integer.parseInt(st.nextToken());

			// 단어 배열
			String[] d = new String[n];

			// 단어 입력
			for (int i = 0; i < n; i++) {
				d[i] = br.readLine();
			}

			// 거리 계산 결과 저장용 리스트
			List<String[]> result = new ArrayList<>();

			// 거리 계산
			for (int i = 0; i < n; i++) {
				String target = d[i];
				int dist = 0;
				for (int j = 0; j < word.length(); j++) {
					char a = word.charAt(j);
					char b = target.charAt(j);
					int[] pa = pos.get(a);
					int[] pb = pos.get(b);
					dist += Math.abs(pa[0] - pb[0]) + Math.abs(pa[1] - pb[1]);
				}
				result.add(new String[] { target, String.valueOf(dist) });
			}

			// 거리순, 사전순 정렬
			Collections.sort(result, new Comparator<String[]>() {
				public int compare(String[] o1, String[] o2) {
					int d1 = Integer.parseInt(o1[1]);
					int d2 = Integer.parseInt(o2[1]);
					if (d1 == d2) {
						return o1[0].compareTo(o2[0]);
					}
					return d1 - d2;
				}
			});

			// 출력
			for (String[] r : result) {
				System.out.println(r[0] + " " + r[1]);
			}
		}
	}
}
