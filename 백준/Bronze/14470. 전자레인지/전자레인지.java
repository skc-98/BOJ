import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int time = 0;

        if (a < 0) {
            time += (-a) * c;
            time += d;
            time += b * e;
        } else {
            time += (b - a) * e;
        }

        System.out.println(time);
    }
}
