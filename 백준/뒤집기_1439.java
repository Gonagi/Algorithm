import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int length = S.length();
        int count1 = 0, count2 = 0;

        if (S.charAt(0) == '0') {
            count1++;
        } else {
            count2++;
        }

        for (int idx = 1; idx < length; idx++) {
            if (S.charAt(idx) != S.charAt(idx - 1)) {
                if (S.charAt(idx) == '0') {
                    count1++;
                } else {
                    count2++;
                }
            }
        }

        System.out.print(Math.min(count1, count2));
        br.close();
    }
}

