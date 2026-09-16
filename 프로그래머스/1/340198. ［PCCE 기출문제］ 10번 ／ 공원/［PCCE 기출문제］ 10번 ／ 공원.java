import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 정렬
        int answer = 0;
        Arrays.sort(mats);

        // 큰 돗자리부터 확인
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];

            for (int j = 0; j <= park.length - size; j++) {
                for (int k = 0; k <= park[0].length - size; k++) {
                    boolean possible = true;
                    for (int l = j; l < j + size; l++) {
                        for (int m = k; m < k + size; m++) {
                            if (!park[l][m].equals("-1")) {
                                possible = false;
                                break;
                            }
                        }

                        if (!possible) {
                            break;
                        }
                    }

                    if (possible) {
                        answer = size;
                        return answer;
                    }
                }
            }
        }

        return -1;
    }
}