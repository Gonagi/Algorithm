import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int count = (int) (Math.pow(2, K) - 1);
        sb.append(count).append('\n');
        hanoi(K, 1, 2, 3);
        System.out.println(sb);
        br.close();
    }

    private static void hanoi(int k, int start, int mid, int end) {
        if (k == 1) {
            sb.append(start).append(' ').append(end).append('\n');
            return;
        }
        hanoi(k - 1, start, end, mid);
        sb.append(start).append(' ').append(end).append('\n');
        hanoi(k - 1, mid, start, end);
    }
}

