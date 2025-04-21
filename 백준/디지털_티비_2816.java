import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int kbs1 = 0, kbs2 = 0;
        String[] channels = new String[N];
        for (int idx = 0; idx < N; idx++) {
            channels[idx] = br.readLine();
            if (channels[idx].equals("KBS1")) {
                kbs1 = idx;
            }
        }

        int cur = 0;
        for (int idx = 0; idx < kbs1; idx++) {
            bw.write("1");
            cur++;
        }

        while (cur > 0) {
            String temp = channels[cur - 1];
            channels[cur - 1] = channels[cur];
            channels[cur] = temp;
            bw.write("4");
            cur--;
        }

        for (int idx = 0; idx < N; idx++) {
            if (channels[idx].equals("KBS2")) {
                kbs2 = idx;
            }
        }

        for (int idx = cur; idx < kbs2; idx++) {
            bw.write("1");
            cur++;
        }

        while (cur > 1) {
            String temp = channels[cur - 1];
            channels[cur - 1] = channels[cur];
            channels[cur] = temp;
            bw.write("4");
            cur--;
        }

        bw.flush();
        br.close();
        bw.close();
    }

}

