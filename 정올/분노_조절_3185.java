import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long[] score = new long[n];
        for (int idx = 0; idx < n; idx++) {
            score[idx] = Long.parseLong(br.readLine());
        }
        Arrays.sort(score);

        long sum = 0, anger = 0;
        for (int idx = 0; idx < k; idx++) {
            anger += score[idx] * idx - sum;
            sum += score[idx];
        }

        long answer = anger;
        for (int left = 0; left + k < n; left++) {
            int right = left + k - 1;
            long out = score[left];
            long in = score[right + 1];

            sum -= out;
            long middleSum = sum;
            anger -= middleSum - out * (k - 1);
            anger += in * (k - 1) - middleSum;
            sum += in;

            answer = Math.min(answer, anger);
        }

        System.out.println(answer);
        br.close();
    }
}

