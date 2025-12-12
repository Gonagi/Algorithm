import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String input = st.nextToken();
                long num = Long.parseLong(st.nextToken());
                if (input.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (!map.isEmpty()) {
                        if (num == 1) {
                            long key = map.lastEntry().getKey();
                            int count = map.get(key);
                            if (count == 1) {
                                map.remove(key);
                            } else {
                                map.put(key, count - 1);
                            }
                        } else {
                            long key = map.firstEntry().getKey();
                            int count = map.get(key);
                            if (count == 1) {
                                map.remove(key);
                            } else {
                                map.put(key, count - 1);
                            }
                        }
                    }
                }
            }

            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(String.valueOf(map.lastEntry().getKey()));
                bw.write(" ");
                bw.write(String.valueOf(map.firstEntry().getKey()));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

