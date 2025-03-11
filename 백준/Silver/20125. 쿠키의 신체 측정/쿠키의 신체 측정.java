import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// 빠른 입력을 위한 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// n의 크기 입력
		int n = Integer.parseInt(br.readLine());

		// 공간의 상태를 저장할 배열
		char[][] d = new char[n][n];

		// n*n의 공간 크기 입력
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				d[i][j] = s.charAt(j);
			}
		}

		// 일단 심장의 위치 찾기
		int heartX = 0, heartY = 0;
		boolean heartFind = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 가장 처음 나오는 *의 아래가 무조건 심장임
				if (d[i][j] == '*') {
					// 심장의 좌표 출력
					System.out.println((i + 2) + " " + (j + 1));
					heartX = i + 1;
					heartY = j;
					heartFind = true;
					break;
				}
			}
			if (heartFind)
				break;
		}

		// 심장을 기준으로 왼팔 길이 구하기
		int count = 0;
		for (int i = heartY - 1; i >= 0; i--) {
			if (d[heartX][i] == '*')
				count++;
			else
				break;
		}
		System.out.print(count + " ");

		// 심장을 기준으로 오른팔 길이 구하기
		count = 0;
		for (int i = heartY + 1; i < n; i++) {
			if (d[heartX][i] == '*')
				count++;
			else
				break;
		}
		System.out.print(count + " ");

		// 왼쪽 다리 시작점과 오른쪽 다리 시작점 구할 변수
		int leftX = 0, leftY = 0, rightX = 0, rightY = 0;

		// 심장을 기준으로 허리 길이 구하기
		count = 0;
		for (int i = heartX + 1; i < n; i++) {
			if (d[i][heartY] == '*')
				count++;
			// 허리가 끝나는 지점에서 다리 시작점 구하기
			else {
				leftX = i;
				leftY = heartY - 1;
				rightX = i;
				rightY = heartY + 1;
				break;
			}
		}
		System.out.print(count + " ");

		// 왼쪽 다리 길이 구하기
		count = 0;
		for (int i = leftX; i < n; i++) {
			if (d[i][leftY] == '*')
				count++;
			else
				break;
		}
		System.out.print(count + " ");

		// 오른쪽 다리 길이 구하기
		count = 0;
		for (int i = rightX; i < n; i++) {
			if (d[i][rightY] == '*')
				count++;
			else
				break;
		}
		System.out.print(count);
	}
}
