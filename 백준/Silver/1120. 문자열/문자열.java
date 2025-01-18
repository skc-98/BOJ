import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String a= st.nextToken(); // 첫 번째 문자열 입력
        String b= st.nextToken(); // 두 번째 문자열 입력
		
        int dist=b.length()-a.length(); // 두 문자열 길이 차이를 저장
        
        int ans=Integer.MAX_VALUE; // ans: 죄종 출력값, INT 최댓값으로 초기화
        for(int i=0; i<=dist; i++) { // 문자열 길이 차이만큼 반복하면서
        	int cnt=a.length(); // 두 문자열간 길이 차이가 최대일 것이라고 생각하고 시작
        	for(int j=i; j<i+a.length(); j++) { // 이제 a와 b문자열의 구간을 반복해서 비교
        		if(a.charAt(j-i)==b.charAt(j)) cnt--; // 문자열 차이를 계산해야 하기 때문에 같을때 cnt값 감소
        	}
        	if(cnt<ans) ans=cnt; // 현재까지 계산한 최솟값보다 작으면 갱신
        }
        System.out.print(ans); // 정답 출력
	}
}