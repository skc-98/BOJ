import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] name = new String[n];
		for (int i = 0; i < n; i++) {
			name[i] = br.readLine();
		}

		long ans = 0;

		int[] nameLen = new int[25];
		// 최초 m만큼 이름 길이 해당하는 카운트 수 증가
		for (int i = 0; i <= m; i++) {
			nameLen[name[i].length()]++;
		}
		// 첫 index 쌍 추가
		ans += (nameLen[name[0].length()] - 1);
		// 첫 index 제거
		nameLen[name[0].length()]--;
		
		int end=m;
		// 슬라이딩 윈도우
		for (int i = 1; i < n; i++) {
			// 뒤에 값 추가가 가능한지
			if(end+1<n) {
				end++;
				nameLen[name[end].length()]++;
			}
			
			ans += (nameLen[name[i].length()] - 1);
			
			// 반복이 종료될 때 항상 제일 앞의 값 버리기
			nameLen[name[i].length()]--;
		}
		System.out.println(ans);
	}
}