import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] lines = new int[3];
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[0] = Integer.parseInt(st.nextToken());
            lines[1] = Integer.parseInt(st.nextToken());
            lines[2] = Integer.parseInt(st.nextToken());
            if (lines[0] == 0 && lines[1] == 0 && lines[2] == 0) {
                break;
            }
            Arrays.sort(lines);
            if (lines[2] >= lines[0] + lines[1]) {
                bw.write("Invalid\n");
            } else if (lines[0] == lines[1] && lines[1] == lines[2]) {
                bw.write("Equilateral\n");
            } else if (lines[0] != lines[1] && lines[0] != lines[1] && lines[1] != lines[2]) {
                bw.write("Scalene\n");
            } else {
                bw.write("Isosceles\n");
            }
        }

        br.close();
        bw.close();
    }
}

