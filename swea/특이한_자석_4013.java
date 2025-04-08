import java.io.*;
import java.util.*;
 
class Solution {
    static int[][] cogwheels;
    static int[] pointer;  
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            cogwheels = new int[4][8];
            pointer = new int[4];
 
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    cogwheels[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int gear = Integer.parseInt(st.nextToken()) - 1;
                int direction = Integer.parseInt(st.nextToken());
                int[] rotate = new int[4];
                rotate[gear] = direction;
                 
                for (int i = gear - 1; i >= 0; i--) {
                    int rightIdx = (pointer[i] + 2) % 8;
                    int leftIdx = (pointer[i + 1] + 6) % 8;
                    if (cogwheels[i][rightIdx] != cogwheels[i + 1][leftIdx]) {
                        rotate[i] = -rotate[i + 1];
                    } else {
                        break;
                    }
                }
                 
                for (int i = gear + 1; i < 4; i++) {
                    int leftIdx = (pointer[i] + 6) % 8;
                    int rightIdx = (pointer[i - 1] + 2) % 8;
                    if (cogwheels[i - 1][rightIdx] != cogwheels[i][leftIdx]) {
                        rotate[i] = -rotate[i - 1];
                    } else {
                        break;
                    }
                }
 
                for (int i = 0; i < 4; i++) {
                    if (rotate[i] == 1) {
                        pointer[i] = (pointer[i] + 7) % 8;
                    } else if (rotate[i] == -1) {
                        pointer[i] = (pointer[i] + 1) % 8;
                    }
                }
            }
             
            int score = 0;
            for (int i = 0; i < 4; i++) {
                if (cogwheels[i][pointer[i]] == 1) {
                    score += (1 << i);
                }
            }
             
            bw.write("#" + testCase + " " + score + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

