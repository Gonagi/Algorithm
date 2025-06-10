import java.io.*;

public class Main {
    static String from, to;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        from = br.readLine();
        to = br.readLine();

        if (DFS(to)) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static private boolean DFS(String str) {
        if (str.length() == from.length()) {
            if (str.equals(from)) {
                return true;
            }
            return false;
        }

        if (str.startsWith("B")) {
            StringBuffer sb = new StringBuffer(str.substring(1));
            if (DFS(sb.reverse().toString())) {
                return true;
            }
        }

        if (str.endsWith("A")) {
            if (DFS(str.substring(0, str.length() - 1))) {
                return true;
            }
        }

        return false;
    }
}

