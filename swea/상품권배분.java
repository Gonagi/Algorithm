import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class UserSolution {
    static class Node {
        int id, num, total;
        Node parent;
        List<Node> children = new ArrayList<>(3);

        public Node(int id, int num) {
            this.id = id;
            this.num = num;
            this.total = num;
        }
    }

    List<Node> roots;
    HashMap<Integer, Node> map;
    int N;

    public void init(int N, int mId[], int mNum[]) {
        this.N = N;
        roots = new ArrayList<>(N);
        map = new HashMap<>();
        for (int idx = 0; idx < N; idx++) {
            Node node = new Node(mId[idx], mNum[idx]);
            roots.add(node);
            map.put(mId[idx], node);
        }
    }

    public int add(int mId, int mNum, int mParent) {
        Node parentNode = map.get(mParent);
        if (parentNode == null || parentNode.children.size() == 3) {
            return -1;
        }

        Node newNode = new Node(mId, mNum);
        newNode.parent = parentNode;
        parentNode.children.add(newNode);
        map.put(mId, newNode);

        Node cur = parentNode;
        while (cur != null) {
            cur.total += mNum;
            cur = cur.parent;
        }

        Node root = parentNode;
        while (root.parent != null) {
            root = root.parent;
        }

        return parentNode.total;
    }

    public int remove(int mId) {
        Node node = map.get(mId);
        if (node == null) {
            return -1;
        }

        int removeTotal = node.total;

        Node parentNode = node.parent;
        if (parentNode != null) {
            parentNode.children.remove(node);
        }

        Node cur = parentNode;
        while (cur != null) {
            cur.total -= removeTotal;
            cur = cur.parent;
        }

        removeChildNode(node);

        return removeTotal;
    }

    public int distribute(int K) {
        int sum = 0;
        List<Integer> totals = new ArrayList<>();
        for (Node root : roots) {
            totals.add(root.total);
            sum += root.total;
        }

        if (sum <= K) {
            int max = 0;
            for (int t : totals) {
                max = Math.max(max, t);
            }
            return max;
        }

        int left = 1;
        int right = 0;
        for (int t : totals) {
            right = Math.max(right, t);
        }

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int allocated = 0;

            for (int t : totals) {
                allocated += Math.min(mid, t);
            }
            if (allocated <= K) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public void removeChildNode(Node node) {
        map.remove(node.id);

        for (Node n : node.children) {
            removeChildNode(n);
        }
    }
}

