import java.util.Iterator;
import java.util.TreeSet;

class UserSolution {
    static class Player implements Comparable<Player> {
        int ability, id;

        public Player(int ability, int id) {
            this.ability = ability;
            this.id = id;
        }

        @Override
        public int compareTo(Player o) {
            if (this.ability == o.ability) {
                return Integer.compare(this.id, o.id);
            }
            return Integer.compare(o.ability, this.ability);
        }
    }

    TreeSet<Player>[] players;
    int N, L, size;

    void init(int N, int L, int mAbility[]) {
        this.N = N;
        this.L = L;
        this.size = N / L;
        this.players = new TreeSet[L];
        for (int idx = 0; idx < L; idx++) {
            players[idx] = new TreeSet<>();
        }

        for (int idx = 0; idx < N; idx++) {
            int playersIdx = idx / size;
            players[playersIdx].add(new Player(mAbility[idx], idx));
        }
    }

    int move() {
        int sum = 0;
        Player[] left = new Player[L - 1];
        Player[] right = new Player[L - 1];

        for (int idx = 0; idx < L - 1; idx++) {
            left[idx] = players[idx].last();
            right[idx] = players[idx + 1].first();
        }

        for (int idx = 0; idx < L - 1; idx++) {
            players[idx].remove(left[idx]);
            players[idx + 1].remove(right[idx]);
            players[idx + 1].add(left[idx]);
            players[idx].add(right[idx]);
            sum += (left[idx].id + right[idx].id);
        }

        return sum;
    }

    int trade() {
        int sum = 0;
        Player[] left = new Player[L - 1];
        Player[] right = new Player[L - 1];

        for (int idx = 0; idx < L - 1; idx++) {
            left[idx] = getMiddle(idx);
            right[idx] = players[idx + 1].first();
        }

        for (int idx = 0; idx < L - 1; idx++) {
            players[idx].remove(left[idx]);
            players[idx + 1].remove(right[idx]);
            players[idx + 1].add(left[idx]);
            players[idx].add(right[idx]);
            sum += (left[idx].id + right[idx].id);
        }

        return sum;
    }

    Player getMiddle(int idx) {
        Iterator<Player> p = players[idx].iterator();
        int s = (size + 1) / 2 - 1;
        for (int i = 0; i < s; i++) {
            p.next();
        }
        return p.next();
    }
}

