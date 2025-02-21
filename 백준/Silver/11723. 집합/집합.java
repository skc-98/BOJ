import java.util.*;
import java.io.*;

// 아이디어
// 비트연산으로 구현하기
// 메모리 제한: 448MB, 시간 제한: 1.5초
public class Main {
	public static void main(String args[]) throws IOException {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// int형 32비트 사용
		int space = 0;
		// 명령이 들어올 시 입력할 숫자
		int num;

		// 명령의 수 n
		int n = Integer.parseInt(br.readLine());

		// 빠른 출력을 위한 StringBuilder
		StringBuilder sb=new StringBuilder();
		
		// 명령 입력받기
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();

			// 해당하는 명령을 switch-case를 통해 처리
			switch (order) {
			case "add":
				// 수 입력받기
				num = Integer.parseInt(st.nextToken());

				// space에 해당 위치가 이미 1이면 무시, 아니면 1
				space = space | (1 << num - 1);
				break;

			case "remove":
				// 수 입력받기
				num = Integer.parseInt(st.nextToken());

				// space에 해당 위치가 이미 0이면 무시, 아니면 0
				if ((space & (1 << num - 1)) != 0)
					space = space ^ (1 << num - 1);
				break;

			case "check":
				// 수 입력받기
				num = Integer.parseInt(st.nextToken());

				// space에 입력받은 수 위치 비트 출력
				if ((space & (1 << num - 1)) != 0)
					sb.append(1+"\n");
				else
					sb.append(0+"\n");
				break;

			case "toggle":
				// 수 입력받기
				num = Integer.parseInt(st.nextToken());

				// 입력받은 위치 값 toggle
				space = space ^ (1 << num - 1);
				break;

			case "all":
				// 전체 비트 1로 세팅
				space = Integer.MAX_VALUE;
				break;
			case "empty":
				// 전체 비트 0으로 세팅
				space = 0;
				break;
			}

		}
		System.out.print(sb);
	}
}
