import java.io.*;
import java.util.*;

class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> words = new HashMap<>();

        for (int idx = 0; idx < N; idx++) {
            String word = br.readLine();

            if (word.length() < M) {
                continue;
            }
            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList<>(words.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (words.get(o1) != words.get(o2)) {
                    return Integer.compare(words.get(o2), words.get(o1));
                }
                if (o1.length() != o2.length()) {
                    return Integer.compare(o2.length(), o1.length());
                }
                return o1.compareTo(o2);
            }

        });

        for (String word : list) {
            bw.write(word + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}

