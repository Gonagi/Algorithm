import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            if (!check1(input) || !check2(input) || !check3(input)) {
                bw.write("<" + input + "> is not acceptable.\n");
            } else {
                bw.write("<" + input + "> is acceptable.\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean check1(String input) {
        if (input.contains("a") || input.contains("e") || input.contains("i")
                || input.contains("o") || input.contains("u")) {
            return true;
        }
        return false;
    }

    private static boolean check2(String input) {
        for (int idx = 0; idx < input.length() - 2; idx++) {
            int count = 0;
            for (int idx2 = idx; idx2 < idx + 3; idx2++) {
                if (input.charAt(idx2) == 'a' || input.charAt(idx2) == 'e' || input.charAt(idx2) == 'i' ||
                        input.charAt(idx2) == 'o' || input.charAt(idx2) == 'u') {
                    count++;
                } else {
                    count--;
                }

                if (count == 3 || count == -3) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean check3(String input) {
        for (int idx = 0; idx < input.length() - 1; idx++) {
            char prev = input.charAt(idx);
            char next = input.charAt(idx + 1);
            if ((prev != 'e' && prev != 'o') && prev == next) {
                return false;
            }
        }
        return true;
    }

}

