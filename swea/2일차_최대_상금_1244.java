import java.util.Scanner;

public class Solution {
    static final Scanner sc = new Scanner(System.in);
    static int N;
    static int result;
    static char[] nums;

    public static void main(String[] args) throws Exception {
	int T = sc.nextInt();

	for (int testCase = 1; testCase <= T; testCase++) {
	    input();
	    dfs(0, 0);
	    System.out.printf("#%d %d\n", testCase, result);
	}
    }

    private static void input() {
	nums = sc.next().toCharArray();
	N = sc.nextInt();
	result = 0;
    }

    public static void dfs(final int start, final int depth) {
	if (depth == N) {
	    int value = Integer.parseInt(new String(nums));
	    result = Math.max(result, value);
	    return;
	}

	for (int idx = start; idx < nums.length; idx++) {
	    for (int idx2 = idx + 1; idx2 < nums.length; idx2++) {
		swap(idx, idx2);
		dfs(idx, depth + 1);
		swap(idx, idx2);
	    }
	}
    }

    public static void swap(final int i, final int j) {
	char temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
    }
}
