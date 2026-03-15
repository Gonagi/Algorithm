// HashMap
import java.io.*;
import java.util.*;

public class Main {
    static int T, n, m;
    static int[] A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        A = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= n; idx++) {
            A[idx] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        B = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= m; idx++) {
            B[idx] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int idx = 1; idx <= n; idx++) {
            int sum = 0;
            for (int idx2 = idx; idx2 <= n; idx2++) {
                sum += A[idx2];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int idx = 1; idx <= m; idx++) {
            int sum = 0;
            for (int idx2 = idx; idx2 <= m; idx2++) {
                sum += B[idx2];
                if (map2.containsKey(sum)) {
                    map2.put(sum, map2.get(sum) + 1);
                } else {
                    map2.put(sum, 1);
                }
            }
        }

        long result = 0;
        for (int num : map.keySet()) {
            int target = T - num;
            if (map2.containsKey(target)) {
                result += (long) map.get(num) * map2.get(target);
            }
        }

        System.out.println(result);
        br.close();
    }
}

// 이분탐색
import java.io.*;
import java.util.*;

public class Main {
    static int T, n, m;
    static int[] A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        A = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= n; idx++) {
            A[idx] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        B = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= m; idx++) {
            B[idx] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        List<Integer> list = new ArrayList<>();
        for (int idx = 1; idx <= n; idx++) {
            int sum = 0;
            for (int idx2 = idx; idx2 <= n; idx2++) {
                sum += A[idx2];
                list.add(sum);
            }
        }

        List<Integer> list2 = new ArrayList<>();
        for (int idx = 1; idx <= m; idx++) {
            int sum = 0;
            for (int idx2 = idx; idx2 <= m; idx2++) {
                sum += B[idx2];
                list2.add(sum);
            }
        }

        Collections.sort(list2);

        for (int num : list) {
            int target = T - num;
            int lower = lowerBound(list2, target);
            int upper = upperBound(list2, target);
            result += (long) upper - lower;
        }

        System.out.println(result);

        br.close();
    }

    private static int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int upperBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

// 투 포인터
import java.io.*;
import java.util.*;

public class Main {
    static int T, n, m;
    static int[] A, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        A = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= n; idx++) {
            A[idx] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        B = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= m; idx++) {
            B[idx] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        List<Integer> list = new ArrayList<>();
        for (int idx = 1; idx <= n; idx++) {
            int sum = 0;
            for (int idx2 = idx; idx2 <= n; idx2++) {
                sum += A[idx2];
                list.add(sum);
            }
        }

        List<Integer> list2 = new ArrayList<>();
        for (int idx = 1; idx <= m; idx++) {
            int sum = 0;
            for (int idx2 = idx; idx2 <= m; idx2++) {
                sum += B[idx2];
                list2.add(sum);
            }
        }

        Collections.sort(list);
        Collections.sort(list2);

        int left = 0, right = list2.size() - 1;
        while (left < list.size() && right >= 0) {
            int sum = list.get(left) + list2.get(right);
            if (sum == T) {
                int aValue = list.get(left);
                int bValue = list2.get(right);
                long aCount = 0, bCount = 0;
                while (left < list.size() && list.get(left) == aValue) {
                    aCount++;
                    left++;
                }
                while (right >= 0 && list2.get(right) == bValue) {
                    bCount++;
                    right--;
                }
                result += aCount * bCount;
            } else if (sum < T) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(result);

        br.close();
    }
}

