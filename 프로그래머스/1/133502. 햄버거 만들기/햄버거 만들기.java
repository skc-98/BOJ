class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        // 스택,  재료 수
        int[] stack = new int[ingredient.length];
        int size = 0;

        // 재료를 하나씩 순서대로 확인
        for (int i = 0; i < ingredient.length; i++) {
            // 현재 재료를 스택에 추가
            stack[size++] = ingredient[i];

            // 마지막 4개 재료가 빵-야채-고기-빵인지 확인
            if (size >= 4 && stack[size - 4] == 1 &&
                stack[size - 3] == 2 && stack[size - 2] == 3 &&
                stack[size - 1] == 1) {

                // 재료 4개 제거
                size -= 4;

                // 완성된 햄버거 개수 증가
                answer++;
            }
        }
        return answer;
    }
}