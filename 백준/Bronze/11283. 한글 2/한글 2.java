import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        String s = br.readLine();

        // 첫 번째 문자만 사용
        char ch = s.charAt(0);

        // 시작 문자 유니코드 값
        char start = '가';
        int ans = ch - start + 1;

        // 답 출력하기
        System.out.println(ans);
    }
}