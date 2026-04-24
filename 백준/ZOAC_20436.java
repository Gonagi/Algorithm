import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        Map<String, Node> map = new HashMap<>();
        String str1 = "qwertyuiop";
        String str2 = "asdfghjkl";
        String str3 = "zxcvbnm";
        for (int idx = 0; idx < str1.length(); idx++) {
            map.put(String.valueOf(str1.charAt(idx)), new Node(0, idx));
        }
        for (int idx = 0; idx < str2.length(); idx++) {
            map.put(String.valueOf(str2.charAt(idx)), new Node(1, idx));
        }
        for (int idx = 0; idx < str3.length(); idx++) {
            map.put(String.valueOf(str3.charAt(idx)), new Node(2, idx));
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String left = st.nextToken();
        String right = st.nextToken();

        String leftHangul = "qwertasdfgzxcv";
        String rightHangul = "yuiophjklbnm";
        String input = br.readLine();
        int time = 0;
        for (int idx = 0; idx < input.length(); idx++) {
            String cur = String.valueOf(input.charAt(idx));
            Node curNode = map.get(cur);
            Node leftNode = map.get(left);
            Node rightNode = map.get(right);

            if (leftHangul.contains(cur)) {
                time += Math.abs(leftNode.y - curNode.y) + Math.abs(leftNode.x - curNode.x);
                left = cur;
            } else {
                time += Math.abs(rightNode.y - curNode.y) + Math.abs(rightNode.x - curNode.x);
                right = cur;
            }
            time++;
        }

        System.out.println(time);
        br.close();
    }
}

