import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            char[] input = br.readLine().toCharArray();
            sb.append(find(input)).append('\n');
        }

        System.out.println(sb);
        br.close();
    }

    private static int find(char[] input) {
        int length = input.length;
        int left = 0, right = length - 1;
        while (left < right) {
            if (input[left] == input[right]) {
                left++;
                right--;
            } else {
                if (isPalindrome(input, left + 1, right) ||
                        isPalindrome(input, left, right - 1)) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    private static boolean isPalindrome(char[] input, int left, int right) {
        while (left < right) {
            if (input[left] == input[right]) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}

