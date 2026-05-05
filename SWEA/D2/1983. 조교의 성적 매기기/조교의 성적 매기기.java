import java.util.*;
import java.io.*;

public class Solution {
    // 등급 배열
    static String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

    public static void main(String[] args) throws Exception {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 수
        int tcn = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= tcn; tc++) {
            // 학생의 수, 학점을 알고 싶은 학생의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int student = Integer.parseInt(st.nextToken());

            // 학생의 평균과 번호를 리스트에 저장
            List<Student> li = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                // 각 학생의 성적을 비율로 변환해서 합쳐두기
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                double score = (a * 0.35) + (b * 0.45) + (c * 0.20);
                li.add(new Student(score, i + 1));
            }

            // 리스트 정렬
            li.sort(new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    return Double.compare(s2.score, s1.score);
                }
            });

            // 정렬 된 리스트에 등급 부여
            int rank = 0;
            for (int i = 0; i < n; i++) {
                if (li.get(i).number == student) {
                    rank = i;
                    break;
                }
            }
            int gradeSize = n / 10;
            int gradeIndex = rank / gradeSize;
            String answer = grade[gradeIndex];

            // 답 출력하기
            System.out.println("#" + tc + " " + answer);
        }
    }

    // 학생 클래스 생성
    static class Student {
        double score;
        int number;

        Student(double score, int number) {
            this.score = score;
            this.number = number;
        }
    }
}