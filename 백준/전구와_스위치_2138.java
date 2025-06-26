import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String from = br.readLine();
        String to = br.readLine();

        char[] start = from.toCharArray();
        char[] start2 = from.toCharArray();
        char[] end = to.toCharArray();

        int count1 = 0;
        start[0] = start[0] == '0' ? '1' : '0';
        start[1] = start[1] == '0' ? '1' : '0';
        count1++;
        for (int idx = 1; idx < N; idx++) {
            if (start[idx - 1] != end[idx - 1]) {
                start[idx - 1] = end[idx - 1];
                start[idx] = start[idx] == '0' ? '1' : '0';
                if (idx < N - 1) {
                    start[idx + 1] = start[idx + 1] == '0' ? '1' : '0';
                }
                count1++;
            }
        }

        int count2 = 0;
        for (int idx = 1; idx < N; idx++) {
            if (start2[idx - 1] != end[idx - 1]) {
                start2[idx - 1] = end[idx - 1];
                start2[idx] = start2[idx] == '0' ? '1' : '0';
                if (idx < N - 1) {
                    start2[idx + 1] = start2[idx + 1] == '0' ? '1' : '0';
                }
                count2++;
            }
        }

        for (int idx = 0; idx < N; idx++) {
            if (start[idx] != end[idx]) {
                count1 = -1;
                break;
            }
        }

        for (int idx = 0; idx < N; idx++) {
            if (start2[idx] != end[idx]) {
                count2 = -1;
                break;
            }
        }

        if (count1 == -1 && count2 == -1) {
            bw.write("-1\n");
        } else if (count1 == -1) {
            bw.write(count2 + "\n");
        } else if (count2 == -1) {
            bw.write(count1 + "\n");
        } else {
            bw.write(Math.min(count1, count2) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

