import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        boolean[] check = new boolean[input.length()];
        int zeroCount = 0, oneCount = 0;

        for (int idx = 0; idx < input.length(); idx++) {
            if (input.charAt(idx) == '0') {
                zeroCount++;
            } else {
                oneCount++;
            }
        }
        zeroCount /= 2;
        oneCount /= 2;

        for (int idx = 0; idx < input.length(); idx++) {
            if (input.charAt(idx) == '1' && oneCount-- > 0) {
                check[idx] = true;
            }
        }

        for (int idx = input.length() - 1; idx >= 0; idx--) {
            if (input.charAt(idx) == '0' && zeroCount-- > 0) {
                check[idx] = true;
            }
        }

        for (int idx = 0; idx < input.length(); idx++) {
            if (!check[idx]) {
                bw.write(input.charAt(idx));
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}

