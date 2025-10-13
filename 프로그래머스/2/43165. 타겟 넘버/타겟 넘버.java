class Solution {
    static int answer=0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    static void dfs(int sum, int now, int[] nums, int target){
        if(now==nums.length){
            if(sum==target) answer++;
            return;
        }
        dfs(sum+nums[now], now+1, nums, target);
        dfs(sum-nums[now], now+1, nums, target);
    }
}