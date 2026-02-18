import java.io.*;
import java.util.*;

public class Main {
    static class Flower implements Comparable<Flower> {
        int sMonth, sDay, eMonth, eDay;

        public Flower(int sMonth, int sDay, int eMonth, int eDay) {
            this.sMonth = sMonth;
            this.sDay = sDay;
            this.eMonth = eMonth;
            this.eDay = eDay;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.sMonth == o.sMonth) {
                if (this.sDay == o.sDay) {
                    if (this.eMonth == o.eMonth) {
                        return Integer.compare(o.eDay, this.eDay);
                    }
                    return Integer.compare(this.eMonth, o.eMonth);
                }
                return Integer.compare(this.sDay, o.sDay);
            }
            return Integer.compare(this.sMonth, o.sMonth);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            flowers[i] = new Flower(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        Arrays.sort(flowers);

        int result = 0, curMonth = 3, curDay = 1, idx = 0;
        while (true) {
            int maxMonth = curMonth;
            int maxDay = curDay;
            boolean found = false;
            while (idx < N &&
                    (flowers[idx].sMonth < curMonth ||
                            (flowers[idx].sMonth == curMonth && flowers[idx].sDay <= curDay))) {
                if (flowers[idx].eMonth > maxMonth ||
                        (flowers[idx].eMonth == maxMonth && flowers[idx].eDay > maxDay)) {
                    maxMonth = flowers[idx].eMonth;
                    maxDay = flowers[idx].eDay;
                }
                idx++;
                found = true;
            }

            if (!found) {
                System.out.println(0);
                return;
            }

            result++;
            curMonth = maxMonth;
            curDay = maxDay;
            if (curMonth > 11 || (curMonth == 11 && curDay > 30)) {
                System.out.println(result);
                return;
            }
        }
    }
}

