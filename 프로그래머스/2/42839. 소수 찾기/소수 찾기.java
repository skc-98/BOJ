import java.util.*;

class Solution {
    // 전역변수 선언부
    static char[] num;
    static int answer=0;
    static boolean[] visit;
    static Set<Integer> set=new HashSet<>();
    
    public int solution(String numbers) {
        // 배열에 한글자씩 저장해두기
        num=new char[numbers.length()];
        visit=new boolean[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            num[i]=numbers.charAt(i);
        }
        
        // 순열 구하고 소수인지 판별하기
        permutation("",0);
        
        // 답 반환하기
        return set.size();
    }
    
    // 순열 메서드
    static void permutation(String now, int depth){
        if (!now.equals("")) {
            int val = Integer.parseInt(now);
            if (isPrime(val)) {
                set.add(val);
            }
        }
        
        // 탐색 끝나면 리턴
        if(depth==num.length) return;
        
        // 모든 수 탐색
        for (int i = 0; i < num.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                permutation(now + num[i], depth + 1);
                visit[i] = false;
            }
        }
    }
    
    // 소수 판별하는 메서드
    static boolean isPrime(int val){
        if(val<2) return false;
        for(int i=2; i*i<=val; i++){
            if(val%i==0) return false;
        }
        return true;
    }
}