import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = num / 5;
        System.out.println(num % 5 == 0 ? count : count + 1);
        br.close();
    }
}

