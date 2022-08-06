package tree.practice.generictree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeUtil {
    private final static int[] tree1 = {10, 20, 50, -1, 60, -1, -1, 30, 70, 110, -1, 120, -1, -1, 80, -1, -1, 40, 90, -1, 100, -1, -1, -1};

    public static Node generateTree() {
        return generateTree(tree1);
    }

    public static Node generateTree(int[] a) {
        Node root = null;
        Stack<Node> s = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                s.pop();
            } else {
                Node newNode = new Node(a[i]);
                if (s.isEmpty()) {
                    root = newNode;
                } else {
                    s.peek().getChild().add(newNode);
                }
                s.push(newNode);
            }

        }
        return root;
    }

    public static void dfs(Node root) {
        if (root == null)
            return;
        String str = root.getData() + " . ";
        for (Node child : root.getChild()) {
            str += child.getData() + " . ";
        }
        System.out.println(str);
        for (Node child : root.getChild()) {
            dfs(child);
        }
    }

    public static void bfs(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node t = q.poll();
                System.out.print(t.getData() + " ");
                for (Node n : t.getChild()) {
                    q.offer(n);
                }
            }
            System.out.println();
        }
    }

    public static int sizeUsingBFS(Node root) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                count++;
                Node t = q.poll();
                System.out.print(t.getData() + " ");
                for (Node n : t.getChild()) {
                    q.offer(n);
                }
            }
            System.out.println();
        }
        return count;
    }

    public static int sizeUsingDFS(Node root) {
        if (root == null)
            return 0;
        int count = 0;
        for (Node n : root.getChild()) {
            count += sizeUsingDFS(n);
        }
        return count + 1;
    }

    public static int max(Node root) {
        if (root == null)
            return 0;
        int max = root.getData();
        for (Node child : root.getChild()) {
            max = Math.max(max, max(child));
        }
        return max;
    }

    public static int maxUsingBFS(Node root) {
        if (root == null)
            return 0;
        int max = root.getData();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node tm = q.poll();
            max = Math.max(max, tm.getData());
            for (Node child : tm.getChild()) {
                q.offer(child);
            }
        }
        return max;
    }

    public static int height(Node root) {
        int max = -1;
        for (Node child : root.getChild()) {
           int h=height(child);
            max = Math.max(max, h);
        }
        return 1 + max;
    }

}
