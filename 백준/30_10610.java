import java.io.*;

public class Main {
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        count = new int[10];
        int check = 0;
        for (int idx = 0; idx < N.length(); idx++) {
            check += N.charAt(idx) - '0';
            count[N.charAt(idx) - '0']++;
        }

        if (check % 3 != 0 || count[0] == 0) {
            bw.write("-1\n");
        } else {
            for (int num = 9; num >= 0; num--) {
                while (count[num] > 0) {
                    bw.write(num + "");
                    count[num]--;
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

