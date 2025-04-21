import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = 0L;

        int M = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < M; idx++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            if (operator.equals("add")) {
                S |= 1 << Integer.parseInt(st.nextToken());
            } else if (operator.equals("remove")) {
                S &= ~(1 << Integer.parseInt(st.nextToken()));
            } else if (operator.equals("check")) {
                if ((S & 1 << Integer.parseInt(st.nextToken())) != 0) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (operator.equals("toggle")) {
                int num = Integer.parseInt(st.nextToken());
                S ^= 1 << num;
            } else if (operator.equals("all")) {
                S = (1 << 21) - 1;
            } else if (operator.equals("empty")) {
                S = 0;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

