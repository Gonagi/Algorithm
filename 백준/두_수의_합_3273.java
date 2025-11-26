import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        Set<Integer> set = new HashSet<>();
        boolean[] check = new boolean[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < n; idx++) {
            input[idx] = Integer.parseInt(st.nextToken());
            set.add(input[idx]);
        }

        int x = Integer.parseInt(br.readLine());

        int count = 0;
        for (int idx = 0; idx < n; idx++) {
            if (!check[input[idx]]) {
                int find = x - input[idx];
                if (find == input[idx]) {
                    continue;
                }
                if (set.contains(find)) {
                    count++;
                    check[input[idx]] = true;
                    check[find] = true;
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

