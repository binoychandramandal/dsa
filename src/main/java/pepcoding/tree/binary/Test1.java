package pepcoding.tree.binary;

public class Test1 {
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
        Node node = BinaryTreeUtil.constructTree(data);
        BinaryTreeUtil.printLevelOrder(node);
        BinaryTreeUtil.preOrder(node);
        BinaryTreeUtil.printStats(node);
        BinaryTreeUtil.allDfsPrintIterative(node);
        System.out.println(BinaryTreeUtil.findPathFromNodeToRoot(node, 30));
        BinaryTreeUtil.printKLevel(node, 4);
        System.out.println("print k node distance node");
        BinaryTreeUtil.printKNodesFar(node, 50, 1);
        BinaryTreeUtil.printKNodesFar(node, 75, 1);
        System.out.println("\nprint path from root to leaf");
        BinaryTreeUtil.pathToLeafFromRoot(node, "", 0, 1, 500);
        BinaryTreeUtil.pathToLeafFromRoot(node, "", 0, 1, 87);
        System.out.println("\nLeft cloned tree");
        Node leftClonedTree = BinaryTreeUtil.leftClonedTree(node);
        BinaryTreeUtil.allDfsPrintIterative(leftClonedTree);
        System.out.println("\nGet back original fromLeft cloned tree");
        Node leftClonedOriginalTree = BinaryTreeUtil.transformBackFromLeftClonedTree(leftClonedTree);
        BinaryTreeUtil.allDfsPrintIterative(leftClonedOriginalTree);
        System.out.println("Single child");
        BinaryTreeUtil.printSingleChild(node, null);
        System.out.println("Remove child node");
        Node removedLeaveNode=BinaryTreeUtil.removeLeaves(node);
        BinaryTreeUtil.allDfsPrintIterative(removedLeaveNode);

        System.out.println(BinaryTreeUtil.isBal(node).isBal);
        data = new Integer[]{50, 25, 12, null, null,null, null};
        System.out.println(BinaryTreeUtil.isBal(BinaryTreeUtil.constructTree(data)).isBal);
    }
}
