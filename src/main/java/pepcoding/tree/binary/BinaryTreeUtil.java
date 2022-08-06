package pepcoding.tree.binary;

import java.util.*;

public class BinaryTreeUtil {
    /**
     * Construct tree from euler path
     *
     * @param data
     * @return
     */
    public static Node constructTree(Integer[] data) {
        Stack<Pair<Node, Integer>> s = new Stack<>();
        Node root = new Node(data[0]);
        s.push(Pair.of(root, 1));
        int idx = 0;
        while (s.size() > 0) {
            Pair<Node, Integer> top = s.peek();
            if (top.getRight() == 1) {
                idx++;
                if (data[idx] != null) {
                    Node tmp = new Node(data[idx]);
                    top.getLeft().left = tmp;
                    s.push(Pair.of(tmp, 1));
                }
                top.setRight(top.getRight() + 1);
            } else if (top.getRight() == 2) {
                idx++;
                if (data[idx] != null) {
                    Node tmp = new Node(data[idx]);
                    top.getLeft().right = tmp;
                    s.push(Pair.of(tmp, 1));
                }
                top.setRight(top.getRight() + 1);
            } else {
                if (!s.isEmpty()) {
                    s.pop();
                }
            }
        }
        return root;
    }

    /**
     * Level order traversal wise line by line
     *
     * @param node
     */
    public static void printLevelOrder(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node tmp = q.poll();
                System.out.print(tmp.val + " ");
                if (tmp.left != null) {
                    q.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q.offer(tmp.right);
                }
            }
            System.out.println();
        }
    }

    /**
     * Pre order recursive
     *
     * @param node
     */
    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        String str = node.left == null ? "." : node.left.val + "";
        str += "<-" + node.val + "->";
        str += node.right == null ? "." : node.right.val + "";
        System.out.println(str);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Size of tree
     *
     * @param node
     * @return
     */
    public static int size(Node node) {
        return node == null ? 0 : 1 + size(node.left) + size(node.right);
    }

    /**
     * Sum of whole tree
     *
     * @param node
     * @return
     */
    public static int sum(Node node) {
        return node == null ? 0 : node.val + sum(node.left) + sum(node.right);
    }

    /**
     * Min of tree
     *
     * @param node
     * @return
     */
    public static int min(Node node) {
        return node == null ? Integer.MAX_VALUE : Math.min(node.val, Math.min(min(node.left), min(node.right)));
    }

    /**
     * max of tree
     *
     * @param node
     * @return
     */
    public static int max(Node node) {
        return node == null ? Integer.MIN_VALUE : Math.max(node.val, Math.max(max(node.left), max(node.right)));
    }

    /**
     * Height of tree
     *
     * @param node
     * @return
     */
    public static int height(Node node) {
        return node == null ? -1 : 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * Call all method in single method
     *
     * @param node
     */
    public static void printStats(Node node) {
        System.out.println("Size -> " + size(node));
        System.out.println("Sum -> " + sum(node));
        System.out.println("Min -> " + min(node));
        System.out.println("Max -> " + max(node));
        System.out.println("Height -> " + height(node));
    }

    /**
     * Pre ,post and in order iterative traversal of a tree
     *
     * @param node
     */
    public static void allDfsPrintIterative(Node node) {
        if (node == null) return;
        Stack<Pair<Node, Integer>> s = new Stack<>();
        s.push(Pair.of(node, 1));
        String pre = "";
        String in = "";
        String post = "";
        while (!s.isEmpty()) {
            Pair<Node, Integer> top = s.peek();
            if (top.getRight() == 1) {
                pre += top.getLeft().val + " ";
                top.setRight(top.getRight() + 1);
                if (top.getLeft().left != null) {
                    s.push(Pair.of(top.getLeft().left, 1));
                }
            } else if (top.getRight() == 2) {
                in += top.getLeft().val + " ";
                top.setRight(top.getRight() + 1);
                if (top.getLeft().right != null) {
                    s.push(Pair.of(top.getLeft().right, 1));
                }
            } else {
                post += top.getLeft().val + " ";
                if (!s.isEmpty()) {
                    s.pop();
                }
            }
        }

        System.out.println("Pre oder-> " + pre);
        System.out.println("In oder-> " + in);
        System.out.println("Post oder-> " + post);
    }

    /**
     * Find a node and return path from node to root
     *
     * @param node
     * @param data
     * @return
     */
    public static ArrayList<Integer> findPathFromNodeToRoot(Node node, int data) {
        ArrayList<Integer> list = new ArrayList<>();
        findPathFromNodeToRoot(node, data, list);
        return list;
    }

    private static boolean findPathFromNodeToRoot(Node node, int data, ArrayList<Integer> list) {
        if (node == null) {
            return false;
        }
        if (node.val == data) {
            list.add(node.val);
            return true;
        }
        if (findPathFromNodeToRoot(node.left, data, list) || findPathFromNodeToRoot(node.right, data, list)) {
            list.add(node.val);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Find path from node to root node
     *
     * @param node
     * @param data
     * @param list
     * @return
     */
    private static boolean findPathFromNodeToRootNodes(Node node, int data, ArrayList<Node> list) {
        if (node == null) {
            return false;
        }
        if (node.val == data) {
            list.add(node);
            return true;
        }
        if (findPathFromNodeToRootNodes(node.left, data, list) || findPathFromNodeToRootNodes(node.right, data, list)) {
            list.add(node);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Print k level down value
     *
     * @param node
     * @param k
     */
    public static void printKLevel(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.print(node.val + " ");
        }
        printKLevel(node.left, k - 1);
        printKLevel(node.right, k - 1);
    }

    /**
     * Print k level down value
     *
     * @param node
     * @param k
     */
    public static void printKLevel(Node node, int k, Node blocker) {
        if (node == null || k < 0 || node == blocker) {
            return;
        }
        if (k == 0) {
            System.out.print(node.val + " ");
        }
        printKLevel(node.left, k - 1);
        printKLevel(node.right, k - 1);
    }

    /**
     * Print k node far distance node of a given node.
     *
     * @param node whole tree
     * @param data from which node of tree
     * @param k    distance from data node
     */
    public static void printKNodesFar(Node node, int data, int k) {
        ArrayList<Node> path = new ArrayList<>();
        findPathFromNodeToRootNodes(node, data, path);
        for (int i = 0; i < path.size(); i++) {
            printKLevel(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
        }
    }

    /**
     * Print root to leaf which sum lies on lo and hi
     *
     * @param node tree
     * @param path which path
     * @param sum  sum of path
     * @param lo   low value
     * @param hi   high value
     */
    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sum += node.val;
            if (sum >= lo && sum <= hi) {
                System.out.println(path + " -> " + node.val);
            }
            return;
        }
        pathToLeafFromRoot(node.left, path + " -> " + node.val, sum + node.val, lo, hi);
        pathToLeafFromRoot(node.right, path + " -> " + node.val, sum + node.val, lo, hi);
    }

    /**
     * Left node cloned tree
     *
     * @param node
     * @return
     */
    public static Node leftClonedTree(Node node) {
        if (node == null)
            return null;
        Node lcr = leftClonedTree(node.left);
        Node rcr = leftClonedTree(node.right);
        Node nn = new Node(lcr, node.val, null);
        node.left = nn;
        node.right = rcr;
        return node;
    }

    /**
     * Transform from left cloned tree to original form
     *
     * @param node
     * @return original tree
     */
    public static Node transformBackFromLeftClonedTree(Node node) {
        if (node == null)
            return null;
        Node lnn = transformBackFromLeftClonedTree(node.left.left);
        Node rnn = transformBackFromLeftClonedTree(node.right);
        node.left = lnn;
        node.right = rnn;
        return node;
    }

    /**
     * Print single child node
     *
     * @param node
     * @param parent
     */
    public static void printSingleChild(Node node, Node parent) {
        if (node == null) {
            return;
        }
        if (parent != null && parent.left == node && parent.right == null) {
            System.out.println(node.val);
        } else if (parent != null && parent.right == node && parent.left == null) {
            System.out.println(node.val);
        }
        printSingleChild(node.left, node);
        printSingleChild(node.right, node);
    }

    /**
     * Remove leaves from node
     *
     * @param node
     * @return
     */
    public static Node removeLeaves(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return null;
        }
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node;
    }

    /**
     * find diameter of a tree. diameter of tree mean any two node which is having
     *
     * @param node
     * @return
     */
    public static int diameter(Node node) {
        if (node == null) {
            return 0;
        }
        int ld = diameter(node.left);
        int rd = diameter(node.right);
        return Math.max(height(node.left) + height(node.right) + 2, Math.max(ld, rd));
    }

    /**
     * Optimized
     *
     * @param node
     * @return
     */
    public static DiaPair diameterOptimized(Node node) {
        if (node == null) {
            DiaPair newDiaPair = new DiaPair();
            newDiaPair.ht = -1;
            newDiaPair.dia = 0;
            return newDiaPair;
        }
        DiaPair lp = diameterOptimized(node.left);
        DiaPair rp = diameterOptimized(node.right);
        DiaPair newDiaPair = new DiaPair();
        newDiaPair.ht = Math.max(lp.ht, rp.ht) + 1;
        int fes = lp.ht + rp.ht + 2;
        newDiaPair.dia = Math.max(fes, Math.max(lp.dia, rp.dia));
        return newDiaPair;
    }

    static class DiaPair {
        int ht;
        int dia;

    }

    static int tilt = 0;

    /**
     * Find tilt
     *
     * @param node
     * @return
     */
    public static int tilt(Node node) {
        if (node == null) {
            return 0;
        }
        int lt = tilt(node.left);
        int rt = tilt(node.right);
        int localTilt = Math.abs(lt - rt);
        tilt += localTilt;
        int sum = lt + rt + node.val;
        return sum;
    }

    static class BSTPair {
        int min;
        int max;
        boolean isBST;
    }

    /**
     * Check is tree is bst or not
     *
     * @param node
     * @return
     */
    public static BSTPair isBst(Node node) {
        if (node == null) {
            BSTPair mp = new BSTPair();
            mp.min = Integer.MAX_VALUE;
            mp.max = Integer.MIN_VALUE;
            mp.isBST = true;
        }
        BSTPair lp = isBst(node.left);
        BSTPair rp = isBst(node.right);
        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (node.val >= lp.max && node.val <= rp.min);
        mp.min = Math.min(node.val, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.val, Math.min(lp.max, rp.max));
        return mp;
    }

    static class BalPair {
        int ht;
        boolean isBal;
    }

    /**
     * If tree is balanced or not
     *
     * @param node
     * @return
     */
    public static BalPair isBal(Node node) {
        if (node == null) {
            BalPair mp = new BalPair();
            mp.ht = 0;
            mp.isBal = true;
            return mp;

        }
        BalPair lp = isBal(node.left);
        BalPair rp = isBal(node.right);
        BalPair mp = new BalPair();
        mp.isBal = Math.abs(lp.ht - rp.ht) <= 1 && lp.isBal && rp.isBal;
        mp.ht = Math.max(lp.ht, rp.ht) + 1;
        return mp;
    }


    static class MaxBSTPair {
        int min;
        int max;
        boolean isBST;
        Node root;
        int size;
    }
    /**
     * Find max bst from a given tree.
     *
     * @param node
     * @return
     */
    public static MaxBSTPair maxBst(Node node) {
        if (node == null) {
            MaxBSTPair mp = new MaxBSTPair();
            mp.min = Integer.MAX_VALUE;
            mp.max = Integer.MIN_VALUE;
            mp.size=0;
            mp.root=null;
            mp.isBST = true;
        }
        MaxBSTPair lp = maxBst(node.left);
        MaxBSTPair rp = maxBst(node.right);
        MaxBSTPair mp = new MaxBSTPair();
        mp.isBST = lp.isBST && rp.isBST && (node.val >= lp.max && node.val <= rp.min);
        mp.min = Math.min(node.val, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.val, Math.min(lp.max, rp.max));
        if(mp.isBST){
            mp.root=node;
            mp.size= lp.size+ rp.size+1;
        }else if(lp.size>rp.size){
            mp.root= lp.root;
            mp.size=lp.size;
        }else{
            mp.root= rp.root;
            mp.size=rp.size;
        }
        return mp;
    }
}
