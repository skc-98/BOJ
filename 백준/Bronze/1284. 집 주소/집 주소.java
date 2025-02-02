import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			int n=sc.nextInt();
			if(n==0) break;
			
			int ans=0;
			String s=String.valueOf(n);
			ans+=(s.length())+1;
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i)=='0') ans+=4;
				else if(s.charAt(i)=='1') ans+=2;
				else ans+=3;
			}
			System.out.println(ans);
		}
	}

}
