import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int size = (int) (max - min + 1);
        boolean[] check = new boolean[size];

        for (long num = 2; num * num <= max; num++) {
            long pow = num * num;

            long start = min / pow;
            if (min % pow != 0)
                start++;

            for (long val = start * pow; val <= max; val += pow) {
                check[(int) (val - min)] = true;
            }
        }

        long answer = 0;
        for (int i = 0; i < size; i++) {
            if (!check[i])
                answer++;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}

