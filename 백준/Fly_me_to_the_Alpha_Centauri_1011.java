import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long distance = y - x;
            int sqrtDist = (int) Math.sqrt(distance);

            if (distance == sqrtDist * sqrtDist) {
                bw.write((2 * sqrtDist - 1) + "\n");
            } else if (distance <= sqrtDist * sqrtDist + sqrtDist) {
                bw.write((2 * sqrtDist) + "\n");
            } else {
                bw.write((2 * sqrtDist + 1) + "\n");
            }

        }

        bw.flush();
        br.close();
        bw.close();
    }
}

