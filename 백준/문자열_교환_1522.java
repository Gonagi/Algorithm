import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();

        int aCount = 0;
        for (int idx = 0; idx < input.length; idx++) {
            if (input[idx] == 'a') {
                aCount++;
            }
        }

        int curCount = 0, result = Integer.MAX_VALUE;
        for (int idx = 0; idx < aCount; idx++) {
            if (input[idx] != 'a') {
                curCount++;
            }
        }

        for (int idx = 0; idx < input.length; idx++) {
            int prevIdx = idx;
            int curIdx = (idx + aCount) >= input.length ? (idx + aCount) - input.length : (idx + aCount);

            if (input[prevIdx] == 'b') {
                curCount--;
            }
            if (input[curIdx] == 'b') {
                curCount++;
            }

            result = Math.min(result, curCount);
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

