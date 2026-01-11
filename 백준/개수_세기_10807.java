import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int find = Integer.parseInt(br.readLine());
        if (map.containsKey(find)) {
            bw.write(String.valueOf(map.get(find)));
        } else {
            bw.write("0\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

