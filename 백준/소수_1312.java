import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int remainder = A % B;
        for (int idx = 0; idx < N - 1; idx++) {
            remainder *= 10;
            remainder %= B;
        }

        remainder *= 10;
        System.out.println(remainder / B);
        br.close();
    }
}

