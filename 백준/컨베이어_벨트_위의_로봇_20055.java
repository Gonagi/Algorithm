import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int durability;
        boolean isRobot;

        public Node(int durability) {
            this.durability = durability;
            this.isRobot = false;
        }
    }

    static int N, K;
    static Node[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new Node[2 * N];
        st = new StringTokenizer(br.readLine());

        for (int idx = 0; idx < 2 * N; idx++) {
            arr[idx] = new Node(Integer.parseInt(st.nextToken()));
        }

        int step = 0;
        while (true) {
            step++;
            rotateBelt();
            moveRobots();
            putRobot();
            if (countZeroDurability() >= K) {
                break;
            }
        }

        bw.write(step + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void rotateBelt() {
        Node last = arr[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;

        arr[N - 1].isRobot = false;
    }

    static void moveRobots() {
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i].isRobot && !arr[i + 1].isRobot && arr[i + 1].durability > 0) {
                arr[i].isRobot = false;
                arr[i + 1].isRobot = true;
                arr[i + 1].durability--;

                if (i + 1 == N - 1) {
                    arr[i + 1].isRobot = false;
                }
            }
        }
    }

    static void putRobot() {
        if (!arr[0].isRobot && arr[0].durability > 0) {
            arr[0].isRobot = true;
            arr[0].durability--;
        }
    }

    static int countZeroDurability() {
        int count = 0;
        for (int i = 0; i < 2 * N; i++) {
            if (arr[i].durability == 0) {
                count++;
            }
        }
        return count;
    }
}

