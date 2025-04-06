import java.util.*;
import java.io.*;

// 아이디어
// 유니온 파인드로 같은 파티에서 만나는 사람들을 한 묶음으로 묶은 다음
// 진실을 아는 사람과 같은 집합에 속한 사람이 있는 파티를 제외한 파티의 수가 답임
public class Main {
	// 각 사람의 부모를 저장할 배열
	static int[] parents;

	// 집합 만드는 메서드
	static void make(int n) {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}

	// 배열을 합치는 메서드
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			parents[b] = a;
	}

	// 부모가 누구인지 찾는 메서드
	static int find(int n) {
		if (parents[n] == n)
			return n;
		return parents[n] = find(parents[n]);
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람의 수, 파티의 수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 부모 배열 초기화 인덱스는 1부터 시작
		parents = new int[n + 1];

		// 진실을 아는 사람의 수와 번호 입력
		st = new StringTokenizer(br.readLine());
		int people = Integer.parseInt(st.nextToken());
		int[] d = new int[people];
		for (int i = 0; i < people; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 각 파티에 오는 사람의 수와 번호를 입력할 리스트 생성
		List<List<Integer>> party = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			party.add(new ArrayList<>());
		}

		// 각 파티에 오는 사람의 수와 번호 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				party.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		// 부모 배열 초기화
		make(n);

		// 사람을 파티 그룹으로 묶기
		for (int i = 0; i < party.size(); i++) {
			// 파티에 참석한 사람이 한명이면 그냥 넘어가기
			if (party.get(i).size() <= 1)
				continue;

			int front = party.get(i).get(0);
			for (int j = 1; j < party.get(i).size(); j++) {
				union(front, party.get(i).get(j));
			}
		}

		// 답을 저장할 변수
		int ans = 0;

		// 거짓말 가능한 파티인지 확인하기
		for (int i = 0; i < party.size(); i++) {
			boolean check = true;
			for (int j = 0; j < party.get(i).size(); j++) {
				// 현재 파티의 인원과
				int now = find(party.get(i).get(j));

				// 진실을 아는 인원의 부모가 같으면 같은 파티라 거짓말 못함
				for (int k = 0; k < people; k++) {
					int truth = find(d[k]);
					if (now == truth) {
						check = false;
						break;
					}
				}
				// 현재 파티에서 거짓말 불가능하니까 그만 탐색해도 됨
				if (!check)
					break;
			}
			// 거짓말 가능한 파티면 답 증가
			if (check)
				ans++;
		}

		// 답 출력하기
		System.out.print(ans);
	}
}
