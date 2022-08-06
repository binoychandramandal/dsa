package pepcoding.tree.binary;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        Integer[] data = new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        /**
         *         50
         *       /   \
         *     25     75
         *    / \     / \
         *  12   37  62  87
         *       /    \
         *      30     70
         */
        Node root = BinaryTreeUtil.constructTree(data);
        //printKLevelDown(root, 2, root.right.right);

        // System.out.println(getPath(root, 62));
        // printKFar(root,30,1);
       // printAllPath(root, "", new ArrayList<>());
        printSingleNode(root,null);
    }

    static void printSingleNode(Node node,Node parent) {
        if (node == null) {
            return;
        }
        if(parent!=null && parent.left==node && parent.right==null){
            System.out.println(node.val);
        }else if(parent!=null && parent.right==node && parent.left==null){
            System.out.println(node.val);
        }

        printSingleNode(node.left,node);
        printSingleNode(node.right,node);

    }

    static void printAllPath(Node node, String psf, ArrayList<Node> paths) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.println(psf + " " + node.val);
            paths.add(node);
            System.out.println(paths);
            return;
        }
        ArrayList<Node> lc = new ArrayList<>(paths);
        lc.add(node);
        printAllPath(node.left, psf + node.val + "-> ", lc);
        ArrayList<Node> rc = new ArrayList<>(paths);
        rc.add(node);
        printAllPath(node.right, psf + node.val + "-> ", rc);
    }

    static void printKFar(Node node, int data, int k) {
        ArrayList<Node> paths = getPath(node, data);
        for (int i = 0; i < paths.size() && i <= k; i++) {
            printKLevelDown(paths.get(i), k - i, i == 0 ? null : paths.get(i - 1));
        }
    }


    static ArrayList<Node> getPath(Node node, int data) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.val == data) {
            ArrayList<Node> path = new ArrayList<>();
            path.add(node);
            return path;
        }
        ArrayList<Node> lp = getPath(node.left, data);
        if (!lp.isEmpty()) {
            lp.add(node);
            return lp;
        }
        ArrayList<Node> rp = getPath(node.right, data);
        if (!rp.isEmpty()) {
            rp.add(node);
            return rp;
        }

        return new ArrayList<>();
    }


    static void printKLevelDown(Node node, int k, Node blocker) {
        if (node == null || k < 0 || node == blocker) {
            return;
        }
        if (k == 0) {
            System.out.print(node.val + " ");
        }
        printKLevelDown(node.left, k - 1, blocker);
        printKLevelDown(node.right, k - 1, blocker);
    }
}
