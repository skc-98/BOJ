// 아이디어
// 반복문은 해봤더니 시간초과라 수식 하나로 정리해야 합니다.
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] ans= {1,2,3,4,5,4,3,2};
		System.out.println(ans[(n-1)%8]);
	}

}
