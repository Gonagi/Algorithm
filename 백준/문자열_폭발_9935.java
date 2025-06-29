import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String explosion = br.readLine();

        int explosionSize = explosion.length();
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; idx < str.length(); idx++) {
            sb.append(str.charAt(idx));

            if (sb.length() >= explosionSize &&
                    sb.substring(sb.length() - explosionSize).equals(explosion)) {
                sb.delete(sb.length() - explosionSize, sb.length());
            }
        }

        bw.write(sb.length() == 0 ? "FRULA" : sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}

