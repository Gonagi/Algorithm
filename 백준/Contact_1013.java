import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String pattern = "^(100+1+|01)+$";
        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            if (input.matches(pattern)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}

