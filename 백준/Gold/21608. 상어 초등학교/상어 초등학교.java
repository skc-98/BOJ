import java.util.*;
import java.io.*;

/**
 * 조건 1: 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다. 조건 2: 1을 만족하는 칸이 여러 개이면,
 * 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다. 조건 3: 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은
 * 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다. ==> 인접한 칸은 상,하,좌,우만 포함된다.
 */

// 단순 구현 시도--> 시간초과 날것같음
public class Main {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 교실의 크기 입력받고 배열로 할당
		int n = Integer.parseInt(br.readLine());
		int[][] d = new int[n][n];

		// 각 학생의 선호도를 저장하기 위해 2차원 arraylist 사용
		List<Integer>[] student = new ArrayList[n * n];
		for (int i = 0; i < n * n; i++) {
			student[i] = new ArrayList<Integer>();
		}
		// 따로 구분 없으니까 0번째 요소가 학생 번호 나머지 요소는 좋아하는 학생 번호

		// 각 학생의 번호와 좋아하는 학생의 번호 입력 처리
		for (int i = 0; i < n * n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				student[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		// 입력 받는데까지는 문제 없음

		// 자리 배치- 입력된 학생 순서대로 자리 배치
		for (int i = 0; i < n * n; i++) {
			// 조건 1번 처리, 2번 동시 처리
			int cond1 = 0; // 1번 조건에 해당하는 방의 수
			int maxCount = 0; // 1번 조건에 해당하는 좋아하는 학생의 수 중에 가장 큰 값

			// 1번 만족하는 칸이 여러개일때 좌표 저장해두기
			List<Integer> xlist = new ArrayList<Integer>();
			List<Integer> ylist = new ArrayList<Integer>();

			// 모든 칸을 돌면서
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					// 비어있는 칸일 경우에
					if (d[j][k] == 0) {
						int nowCount = 0; // 현재 칸에서 좋아하는 학생의 수
						// 4방향 탐색
						for (int a = 0; a < 4; a++) {
							int nx = j + dx[a];
							int ny = k + dy[a];
							if (nx < 0 || nx >= n || ny < 0 || ny >= n)
								continue;
							// 현재 탐색중인 칸이 좋아하는 학생과 일치하는지 판단
							for (int b = 1; b < 5; b++) {
								if (d[nx][ny] == student[i].get(b)) {
									nowCount++;
									break;
								}
							}
						}
						// 현재 칸에서 구한 좋아하는 학생의 수가 가장 많은 칸이면 좌표 저장해두기
						if (nowCount > maxCount) {
							maxCount = nowCount;
							cond1 = 1;
							xlist.clear();
							ylist.clear();
							xlist.add(j);
							ylist.add(k);
						}
						// 가장 많은 칸이 여러개면 해당 좌표도 저장
						else if (nowCount == maxCount) {
							cond1++;
							xlist.add(j);
							ylist.add(k);
						}
					}
				}
			}
			// 조건1번에서 끝낼 수 있으면 배치시키고 continue
			if (cond1 == 1) {
				d[xlist.get(0)][ylist.get(0)] = student[i].get(0);
				continue;
			}

			// 조건 1번에서 구한 xlist와 ylist를 통해 조건 2번 시작
			int cond2 = 0;
			int maxLike = 0;

			// 조건 3을 위해 좌표 저장해둘 배열
			List<Integer> xlist2 = new ArrayList<Integer>();
			List<Integer> ylist2 = new ArrayList<Integer>();
			for (int j = 0; j < xlist.size(); j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = xlist.get(j) + dx[k];
					int ny = ylist.get(j) + dy[k];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;
					if (d[nx][ny] == 0)
						cnt++;
				}
				if (maxLike < cnt) {
					maxLike = cnt;
					cond2 = 1;
					xlist2.clear();
					ylist2.clear();
					xlist2.add(xlist.get(j));
					ylist2.add(ylist.get(j));
				} else if (maxLike == cnt) {
					cond2++;
					xlist2.add(xlist.get(j));
					ylist2.add(ylist.get(j));
				}
			}
			if (cond2 == 1) {
				d[xlist2.get(0)][ylist2.get(0)] = student[i].get(0);
				continue;
			}

			// xlist2, ylist2 pair로 묶어서 정렬해버리기
			// 조건 3번, 정렬 후 가장 앞에있는 값으로 설정하면 된다.
			int minrow = Integer.MAX_VALUE, mincol = Integer.MAX_VALUE;
			for (int j = 0; j < xlist2.size(); j++) {
				if (minrow > xlist2.get(j)) {
			        minrow = xlist2.get(j);
			        mincol = ylist2.get(j);
			    } else if (minrow == xlist2.get(j)) {
			        if (mincol > ylist2.get(j)) {
			            mincol = ylist2.get(j);
			        }
			    }
			}
			d[minrow][mincol] = student[i].get(0);
		}

//		// 현재 자리배치 출력 해보기
//		for (int j = 0; j < n; j++) {
//			for (int k = 0; k < n; k++) {
//				System.out.print(d[j][k] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		// 만족도 구하기: student에 좋아하는 학생정보 들어있음
		// 0이면 학생의 만족도는 0, 1이면 1, 2이면 10, 3이면 100, 4이면 1000이다
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int studentNumber = d[i][j]; // 현재 학생의 번호
				// 현재 학생이 student 리스트에서 몇번째 위치하는지 인덱스 번호구하기
				int idx = 0;
				for (int k = 0; k < n * n; k++) {
					if (student[k].get(0) == studentNumber)
						idx = k;
				}
				int cnt = 0; // 현재 학생 주변의 좋아하는 학생의 숫자를 저장할 변수
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;
					int nowStudent = d[nx][ny]; // 4방 탐색시 인접한 학생의 번호
					for (int l = 1; l < 5; l++) {
						if (student[idx].get(l) == nowStudent)
							cnt++;
					}

				}
				if(cnt==4) ans+=1000;
				else if(cnt==3) ans+=100;
				else if(cnt==2) ans+=10;
				else if(cnt==1) ans+=1;
			}
		}

		// 답 출력
		System.out.println(ans);
	}
}
