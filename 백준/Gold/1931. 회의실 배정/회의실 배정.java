import java.util.*;
import java.io.*;

// 아이디어
// 회의를 종료 시간이 빠른 순서로 정렬하고, 종료 시간이 같다면 시작 시간이 빠른 순서로 정렬하고
// 정렬된 순서대로 탐색하면서 회의를 정하면 최적의 해를 구할 수 있습니다.
// 시간제한: 2초, 메모리제한: 128MB
public class Main {
	public static void main(String args[]) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 회의의 수 n 입력
		int n = Integer.parseInt(br.readLine());

		// n개의 회의 정보 입력해서 리스트에 저장
		List<Meeting> li = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Meeting m = new Meeting(a, b);
			li.add(m);
		}

		// 시작시간이 빠르고, 같다면 종료시간이 빠른 순서로 리스트 정렬
		Collections.sort(li, (m1, m2) -> {
			if (m1.end == m2.end) {
				return Integer.compare(m1.start, m2.start);
			}
			return Integer.compare(m1.end, m2.end);
		});

		// 이제 순서대로 탐색하면서 회의 정하기
		int current = li.get(0).end; // 첫 회의의 종료시간
		int count = 1; // 첫 회의를 선택했으니 1로 초기화
		for (int i = 1; i < n; i++) {
			// 회의를 선택할 수 있으면 선택
			if (current <= li.get(i).start) {
				count++;
				current = li.get(i).end; // 선택한 회의의 종료 시간으로 초기화
			}
		}

		// 답 출력하기
		System.out.print(count);
	}
}

// 회의 정보를 클래스로 만들어서 관리했습니다.
class Meeting {
	int start;
	int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
}