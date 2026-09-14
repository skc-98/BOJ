class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        // 직원별로 일주일 출근 기록 확인
        for (int i = 0; i < schedules.length; i++) {
            boolean success = true;

            // 출근 희망 시각을 분 단위로 변환하고 10분 추가
            int scheduleHour = schedules[i] / 100;
            int scheduleMinute = schedules[i] % 100;
            int limitTime = scheduleHour * 60 + scheduleMinute + 10;

            for (int j = 0; j < 7; j++) {
                // 현재 요일 계산
                int day = (startday - 1 + j) % 7 + 1;

                // 토요일, 일요일은 스킵
                if (day == 6 || day == 7) {
                    continue;
                }

                // 실제 출근 시각을 분 단위로 변환
                int logHour = timelogs[i][j] / 100;
                int logMinute = timelogs[i][j] % 100;
                int logTime = logHour * 60 + logMinute;

                // 평일 중 한 번이라도 지각하면 상품 대상 제외
                if (logTime > limitTime) {
                    success = false;
                    break;
                }
            }

            // 모든 평일에 정상 출근한 경우 카운트
            if (success) {
                answer++;
            }
        }
        return answer;
    }
}