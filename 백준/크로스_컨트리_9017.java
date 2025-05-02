import java.io.*;
import java.util.*;

class Main {
    static class Team implements Comparable<Team> {
        int num, sum, count, rankedPlayers, lastRank;

        public Team(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Team o) {
            if (this.sum == o.sum) {
                return this.lastRank - o.lastRank;
            }
            return this.sum - o.sum;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            Team[] teams = new Team[201];
            for (int idx = 0; idx <= 200; idx++) {
                teams[idx] = new Team(idx);
            }
            int N = Integer.parseInt(br.readLine());
            int[] input = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int t = 1; t <= N; t++) {
                input[t] = Integer.parseInt(st.nextToken());
                teams[input[t]].count++;
            }

            int t = 1;
            for (int idx = 1; idx <= N; idx++) {
                int cur = input[idx];
                if (teams[cur].count < 6) {
                    continue;
                }

                if (teams[cur].rankedPlayers < 5) {
                    if (teams[cur].rankedPlayers < 4) {
                        teams[cur].sum += t;
                    }
                    teams[cur].rankedPlayers++;
                    teams[cur].lastRank = t;
                }
                t++;
            }

            Arrays.sort(teams);

            for (int idx = 1; idx <= 200; idx++) {
                if (teams[idx].count < 6) {
                    continue;
                }
                bw.write(teams[idx].num + "\n");
                break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

