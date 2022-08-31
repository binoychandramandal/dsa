package pepcoding.tree.generic;

import java.util.*;

public class GenericTreeUtil {
    private GenericTreeUtil() {
    }

    /**
     * Construct the tree using eluar array
     *
     * @param a Eulular tree element
     * @return constructed tree
     */
    public static Node constructGenericTree(int[] a) {
        Node root = null;
        Deque<Node> stack = new ArrayDeque<>();
        for (int val : a) {
            if (val == -1) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                Node newNode = new Node(val);
                if (!stack.isEmpty()) {
                    stack.peek().children.add(newNode);
                } else {
                    root = newNode;
                }
                stack.push(newNode);
            }
        }
        return root;
    }

    /**
     * Print tree
     *
     * @param node generic tree
     */
    public static void displayGenericTree(Node node) {

        String data = node.data + " : ";
        for (Node n : node.children) {
            data += n.data + "-> ";
        }
        data += ".";
        System.out.println(data);
        for (Node n : node.children) {
            displayGenericTree(n);
        }
    }

    /**
     * Size of generic tree
     *
     * @param root
     * @return size of tree
     */
    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        int s = 0;
        for (Node n : root.children) {
            s += size(n);
        }
        s += 1;
        return s;
    }

    /**
     * Find max item
     *
     * @param root
     * @return max item
     */
    public static int findMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, findMax(root.children.get(i)));
        }
        return Math.max(max, root.data);
    }

    /**
     * Height of a tree in term of edges
     *
     * @param root tree
     * @return height or depth of a tree
     */
    public static int height(Node root) {
        int height = -1; // edge
        for (Node child : root.children) {
            height = Math.max(height(child), height);
        }
        return height + 1;
    }

    /**
     * Identify before call, after call child and pre and post of root
     *
     * @param root tree
     */
    public static void treePattern(Node root) {
        //area1 pre  on the way to euler path
        System.out.println("Node Pre " + root.data);
        for (Node child : root.children) {
            System.out.println("Edge Pre " + root.data + "--" + child.data);
            treePattern(child);
            System.out.println("Edge Post " + root.data + "--" + child.data);
        }
        //area2 post  on the way to euler path
        System.out.println("Node Post " + root.data);
    }

    /**
     * Level order traversal
     *
     * @param root
     */
    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node t = q.poll();
            System.out.print(t.data + ",");
            for (Node child : t.children) {
                q.offer(child);
            }
        }
        System.out.println(".");
    }

    /**
     * Level order traversal line by line
     * count approach
     *
     * @param root
     */
    public static void levelOrderLineByLine(Node root) {
        Deque<Node> q = new ArrayDeque<>();
        q.push(root);
        while (!q.isEmpty()) {

            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node t = q.pop();
                System.out.print(t.data + ",");
                for (Node child :
                        t.children) {
                    q.push(child);
                }
            }
            System.out.println(".");
        }
    }

    /**
     * Level order traversal line by line
     * delimiter approach
     *
     * @param root
     */
    public static void levelOrderLineByLineDelimiterApproach(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            Node t = q.poll();
            if (t != null) {
                System.out.print(t.data + " ");
                for (Node child : t.children) {
                    q.offer(child);
                }
            } else {
                if (!q.isEmpty()) {
                    q.offer(null);
                    System.out.println();
                }
            }
        }
    }

    /**
     * Print tree in zigzag fashion
     *
     * @param root tree
     */
    public static void zigzagPrint(Node root) {
        Stack<Node> ms = new Stack<>();
        ms.push(root);
        Stack<Node> cs = new Stack<>();
        int level = 1;
        while (!ms.isEmpty()) {
            Node r = ms.pop();
            System.out.print(r.data + " ");
            if (level % 2 == 1) {
                for (int i = 0; i < r.children.size(); i++) {
                    Node c = r.children.get(i);
                    cs.push(c);
                }
            } else {
                for (int i = r.children.size() - 1; i >= 0; i--) {
                    Node c = r.children.get(i);
                    cs.push(c);
                }
            }
            if (ms.size() == 0) {
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println("");
            }
        }
    }

    /**
     * Remove leaf node from given tree
     *
     * @param root tree
     * @return root node after remove leave node
     */
    public static Node removeLeaves(Node root) {
        if (root == null || root.children.isEmpty()) {
            return null;
        }
        int size = root.children.size();
        //due to array deletion will shift value so starting from end site
        for (int i = size - 1; i >= 0; i--) {
            Node child = root.children.get(i);
            if (child.children.isEmpty()) {
                if (!root.children.isEmpty())
                    root.children.remove(child);
            }
        }
        for (Node child : root.children) {
            removeLeaves(child);
        }
        return root;
    }

    /**
     * Make generic tree linearize which having one child at a time.
     *
     * @param node tree
     * @return linearize tree
     */
    public static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }
        while (node.children.size() > 1) {
            Node lc = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node slt = getTail(sl);
            slt.children.add(lc);
        }
    }

    /**
     * Make generic tree linearize which having one child at a time.
     * optimized
     *
     * @param node tree
     * @return linearize tree
     */
    public static Node linearize2(Node node) {
        if (node.children.size() == 0) {
            return node;
        }
        Node lkt = linearize2(node.children.get(node.children.size() - 1));
        while (node.children.size() > 1) {
            Node last = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node slkt = linearize2(sl);
            slkt.children.add(last);
        }
        return lkt;
    }

    /**
     * Get tail from a node
     *
     * @param node tree
     * @return tail node
     */
    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }

    /**
     * Find a key in tree
     *
     * @param node tree
     * @param k    key to exists
     * @return true if present else false
     */
    public static boolean find(Node node, int k) {
        if (node == null) return false;
        if (node.data == k) {
            return true;
        }
        for (Node child : node.children) {
            if (find(child, k)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find path from node to path
     *
     * @param node tree
     * @param k    key
     * @return list of node in the path
     */
    public static ArrayList<Integer> nodeToPath(Node node, int k) {
        if (node.data == k) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(node.data);
            return result;
        }
        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToPath(child, k);
            if (!ptc.isEmpty()) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    /**
     * Find common ancestor
     *
     * @param node
     * @param d1
     * @param d2
     * @return
     */
    public static int findLeastCommonAncestor(Node node, int d1, int d2) {
        ArrayList<Integer> d = nodeToPath(node, d1);
        ArrayList<Integer> dd = nodeToPath(node, d2);
        int i = d.size() - 1;
        int j = dd.size() - 1;
        while (i >= 0 && j >= 0 && d.get(i) == dd.get(j)) {
            j--;
            i--;
        }
        i++;
        j++;
        return d.get(i);
    }

    /**
     * Distance between two node
     *
     * @param node
     * @param d1
     * @param d2
     * @return
     */
    public static int distanceBetweenTwoNode(Node node, int d1, int d2) {
        ArrayList<Integer> d = nodeToPath(node, d1);
        ArrayList<Integer> dd = nodeToPath(node, d2);
        int i = d.size() - 1;
        int j = dd.size() - 1;
        while (i >= 0 && j >= 0 && d.get(i) == dd.get(j)) {
            j--;
            i--;
        }
        i++;
        j++;
        return i + j;
    }

    /**
     * If two given tree are similar shape or not. here data may or may not be same.
     *
     * @param t1 tree 1
     * @param t2 tree 2
     * @return true if similar shape
     */
    public static boolean isSimilarShape(Node t1, Node t2) {
        if (t1.children.size() != t2.children.size()) {
            return false;
        }
        for (int i = 0; i < t1.children.size(); i++) {
            Node child1 = t1.children.get(i);
            Node child2 = t2.children.get(i);
            if (!isSimilarShape(child1, child2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * If two tree mirror image or not. if left side of tree1 equals with tree2 right
     *
     * @param n1
     * @param n2
     * @return
     */
    public static boolean areMirror(Node n1, Node n2) {
        if (n1.children.size() != n2.children.size()) {
            return false;
        }
        for (int i = 0; i < n1.children.size(); i++) {
            int j = n1.children.size() - 1 - i;
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(j);
            if (!areMirror(c1, c2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * If a tree is mirror of itself then it a symmetric tree
     *
     * @param node
     * @return
     */
    public static boolean isSymmetric(Node node) {
        return areMirror(node, node);
    }

    /**
     * Print size,sum,min,max,height in one method
     *
     * @param node
     */
    public static void printStats(Node node) {
        Node.Stats stats = new Node.Stats();
        printStats(node, 0, stats);
        System.out.println(stats);
    }

    private static void printStats(Node node, int depth, Node.Stats stats) {
        stats.size = stats.size + 1;
        stats.sum = stats.sum + node.data;
        stats.max = Math.max(stats.max, node.data);
        stats.min = Math.min(stats.min, node.data);
        stats.height = Math.max(stats.height, depth);
        for (Node child : node.children) {
            printStats(child, depth + 1, stats);
        }
    }

    /**
     * Node's pre order adjacent elements
     *
     * @param node
     * @param k
     */
    public static void printPredecessorAndSuccessor(Node node, int k) {
        Node.PreAndSuc preAndSuc = new Node.PreAndSuc();
        printPredecessorAndSuccessor(node, k, preAndSuc);
        System.out.println(preAndSuc);

    }

    public static void printPredecessorAndSuccessor(Node node, int k, Node.PreAndSuc preAndSuc) {
        if (preAndSuc.state == 0) {
            if (node.data == k) {
                preAndSuc.state = 1;
            } else {
                preAndSuc.predecessor = node;
            }
        } else if (preAndSuc.state == 1) {
            preAndSuc.successor = node;
            preAndSuc.state = 2;
        }

        for (Node child : node.children) {
            printPredecessorAndSuccessor(child, k, preAndSuc);
        }

    }

    /**
     * find floor and ciel of a given value
     * int floor=Integer.MIN_VALUE; //largest among smaller
     * int ceil=Integer.MAX_VALUE;//smallest among larger
     *
     * @param node
     * @param data
     */
    public static void printFloorAndCeil(Node node, int data) {
        Node.FloorAndCeil floorAndCeil = new Node.FloorAndCeil();
        printFloorAndCeil(node, data, floorAndCeil);
        System.out.println(floorAndCeil);
    }

    private static void printFloorAndCeil(Node node, int data, Node.FloorAndCeil floorAndCeil) {
        if (node.data > data) {
            if (node.data < floorAndCeil.ceil) {
                floorAndCeil.ceil = node.data;
            }
        }

        if (node.data < data) {
            if (node.data > floorAndCeil.floor) {
                floorAndCeil.floor = node.data;
            }
        }

        for (Node child : node.children) {
            printFloorAndCeil(child, data, floorAndCeil);
        }
    }

}


