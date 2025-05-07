import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        int curIdx = 0, result = 0;
        while (result++ <= Integer.MAX_VALUE) {
            String temp = Integer.toString(result);

            for (int idx = 0; idx < temp.length(); idx++) {
                if (input.charAt(curIdx) == temp.charAt(idx)) {
                    curIdx++;
                }

                if (curIdx == input.length()) {
                    System.out.println(result);
                    return;
                }
            }
        }
    }
}

