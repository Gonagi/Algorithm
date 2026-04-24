import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        int num = 1, count = 0;
        long sum = 0;
        while (true) {
            if (sum > S) {
                break;
            }
            sum += num;
            num++;
            count++;
        }
        System.out.println(count - 1);
        br.close();
    }
}

