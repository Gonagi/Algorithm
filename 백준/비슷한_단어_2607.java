import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        int[] standard = new int[26];

        String input = br.readLine();
        for (int idx = 0; idx < input.length(); idx++) {
            standard[input.charAt(idx) - 'A']++;
        }

        int result = 0;
        for (int idx = 1; idx < count; idx++) {
            int[] compare = new int[26];
            String input2 = br.readLine();
            for (int idx2 = 0; idx2 < input2.length(); idx2++) {
                compare[input2.charAt(idx2) - 'A']++;
            }

            int diff = 0;

            for (int s = 0; s < 26; s++) {
                diff += Math.abs(standard[s] - compare[s]);
            }

            if (diff == 0 || diff == 1 || (diff == 2 && input.length() == input2.length())) {
                result++;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

