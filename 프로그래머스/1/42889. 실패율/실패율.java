class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer=new int[N];
        int[] cnt=new int[N+2];
        double[] rate=new double[N+1];
        int total=stages.length;
        for(int i=0;i<stages.length;i++) {
            cnt[stages[i]]++;
        }
        for(int i=0;i<N;i++) {
            answer[i]=i+1;
            if(total>0) {
                rate[i+1]=(double)cnt[i+1]/total;
            }
            total-=cnt[i+1];
        }
        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++) {
                if(rate[answer[i]]<rate[answer[j]]||(rate[answer[i]]==rate[answer[j]]&&answer[i]>answer[j])) {
                    int k=answer[i];
                    answer[i]=answer[j];
                    answer[j]=k;
                }
            }
        }
        return answer;
    }
}