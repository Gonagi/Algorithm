import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();

        for (int n = 0; n < N; n++) {
            String input = br.readLine();
            String[] words = input.split(" ");
            boolean assigned = false;

            for (int i = 0; i < words.length; i++) {
                char firstChar = Character.toLowerCase(words[i].charAt(0));
                if (!set.contains(firstChar)) {
                    set.add(firstChar);
                    int findIdx = 0;
                    for (int j = 0; j < i; j++) {
                        findIdx += words[j].length() + 1;
                    }
                    bw.write(input.substring(0, findIdx) + "[" + words[i].charAt(0) + "]" + input.substring(findIdx + 1)
                            + "\n");
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    if (ch != ' ' && !set.contains(Character.toLowerCase(ch))) {
                        set.add(Character.toLowerCase(ch));
                        bw.write(input.substring(0, i) + "[" + ch + "]" + input.substring(i + 1) + "\n");
                        assigned = true;
                        break;
                    }
                }
            }

            if (!assigned) {
                bw.write(input + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

