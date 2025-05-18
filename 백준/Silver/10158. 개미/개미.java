import java.util.*;
import java.io.*;

// t가 2억이니까 단순 시뮬로 불가능, 좀 그리디 하게 풀어야 함
public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 격자의 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		// 초기 위치 좌표 입력
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		// 개미가 움직일 시간 t 입력
		int t = Integer.parseInt(br.readLine());

		// x 축 위치 계산
        int x = (p + t) % (2 * w);
        if (x > w) x = 2 * w - x;

        // y 축 위치 계산
        int y = (q + t) % (2 * h);
        if (y > h) y = 2 * h - y;
        
        // 답 출력하기
        System.out.println(x+ " " + y);
	}
}
