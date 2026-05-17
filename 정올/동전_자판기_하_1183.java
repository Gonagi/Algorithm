import java.io.*;
import java.util.*;

public class Main {
    static class Coin {
        int value, count;

        public Coin(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int W = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Coin[] coin = new Coin[6];
        int[] resultCoin = new int[6];
        coin[0] = new Coin(500, Integer.parseInt(st.nextToken()));
        coin[1] = new Coin(100, Integer.parseInt(st.nextToken()));
        coin[2] = new Coin(50, Integer.parseInt(st.nextToken()));
        coin[3] = new Coin(10, Integer.parseInt(st.nextToken()));
        coin[4] = new Coin(5, Integer.parseInt(st.nextToken()));
        coin[5] = new Coin(1, Integer.parseInt(st.nextToken()));

        int[][] dp = new int[7][W + 1];
        int[][] choice = new int[7][W + 1];

        for (int idx = 0; idx <= 6; idx++) {
            Arrays.fill(dp[idx], Integer.MIN_VALUE);
        }

        dp[0][0] = 0;
        for (int idx = 1; idx <= 6; idx++) {
            Coin curCoin = coin[idx - 1];
            for (int money = 0; money <= W; money++) {
                for (int c = 0; c <= curCoin.count; c++) {
                    int prevMoney = money - curCoin.value * c;
                    if (prevMoney < 0) {
                        break;
                    }
                    if (dp[idx - 1][prevMoney] == Integer.MIN_VALUE) {
                        continue;
                    }

                    int candidate = dp[idx - 1][prevMoney] + c;
                    if (candidate > dp[idx][money]) {
                        dp[idx][money] = candidate;
                        choice[idx][money] = c;
                    }
                }
            }
        }

        int result = dp[6][W];
        int money = W;
        for (int idx = 6; idx >= 1; idx--) {
            int usedCount = choice[idx][money];
            resultCoin[idx - 1] = usedCount;
            money -= coin[idx - 1].value * usedCount;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result).append('\n');
        for (int value : resultCoin) {
            sb.append(value).append(' ');
        }
        System.out.println(sb);

        br.close();
    }
}

