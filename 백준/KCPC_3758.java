import java.io.*;
import java.util.*;

class Main {
    static class Team implements Comparable<Team> {
        int id, sum, submit, last;
        int[] scores;

        public Team(int id, int size, int sum, int submit, int last) {
            this.id = id;
            this.sum = sum;
            this.submit = submit;
            this.last = last;
            this.scores = new int[size];
        }

        @Override
        public int compareTo(Team o) {
            if (this.sum == o.sum) {
                if (this.submit == o.submit) {
                    return this.last - o.last;
                }
                return this.submit - o.submit;
            }
            return o.sum - this.sum;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n];
            for (int idx = 0; idx < n; idx++) {
                teams[idx] = new Team(idx + 1, k, 0, 0, 0);
            }

            for (int idx = 0; idx < m; idx++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken()) - 1;
                int j = Integer.parseInt(st.nextToken()) - 1;
                int s = Integer.parseInt(st.nextToken());
                if (teams[i].scores[j] <= s) {
                    teams[i].sum -= teams[i].scores[j];
                    teams[i].scores[j] = s;
                    teams[i].sum += s;
                }
                teams[i].submit++;
                teams[i].last = idx;
            }

            Arrays.sort(teams);

            for (int idx = 0; idx < n; idx++) {
                if (teams[idx].id == t) {
                    bw.write((idx + 1) + "\n");
                    break;
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

