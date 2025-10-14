import java.util.*;

class Solution {
    static int nidx=0;
    
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        int idx=0;
        List<int[]> li=new ArrayList<>();
        if(ext.equals("code")){
            idx=0;
        }
        else if(ext.equals("date")){
            idx=1;
        }
        else if(ext.equals("maximum")){
            idx=2;
        }
        else if(ext.equals("remain")){
            idx=3;
        }
        
        for(int i=0; i<data.length; i++){
            if(data[i][idx]<val_ext){
                li.add(new int[] {data[i][0], data[i][1], data[i][2], data[i][3]});
            }
        }
        
        if(sort_by.equals("code")){
            nidx=0;
        }
        else if(sort_by.equals("date")){
            nidx=1;
        }
        else if(sort_by.equals("maximum")){
            nidx=2;
        }
        else if(sort_by.equals("remain")){
            nidx=3;
        }
        
        Collections.sort(li, (a, b) -> a[nidx] - b[nidx]);
        
        return li;
    }
}