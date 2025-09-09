import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int idx = 0; idx < T; idx++) {
            ArrayDeque<String> deque = new ArrayDeque<>();
            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            input = input.substring(1, input.length() - 1);

            String[] num = new String[n];
            num = input.split(",");

            for (int i = 0; i < n; i++) {
                deque.addLast(num[i]);
            }

            boolean isReverse = false;
            boolean isError = false;
            int size = function.length();
            for (int i = 0; i < size; i++) {
                char cur = function.charAt(i);
                if (cur == 'R') {
                    isReverse = !isReverse;
                    continue;
                }
                if (deque.size() == 0) {
                    bw.write("error\n");
                    isError = true;
                    break;
                }
                if (isReverse) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }

            if (!isError) {

                bw.write("[");

                if (!isReverse) {
                    String cur = null;
                    while ((cur = deque.pollFirst()) != null) {
                        if (deque.isEmpty()) {
                            bw.write(cur);
                            continue;
                        }
                        bw.write(cur + ",");
                    }
                } else {
                    String cur = null;
                    while ((cur = deque.pollLast()) != null) {
                        if (deque.isEmpty()) {
                            bw.write(cur);
                            continue;
                        }
                        bw.write(cur + ",");
                    }
                }
                bw.write("]\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

