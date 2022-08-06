package pepcoding.tree.generic;

public class Test1 {
    public static void main(String[] args) {
        Node node=GenericTreeUtil.constructGenericTree(new int[]{10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1});
        //GenericTreeUtil.displayGenericTree(node);
        //System.out.println(GenericTreeUtil.size(node));
        //System.out.println(GenericTreeUtil.findMax(node));
        //System.out.println(GenericTreeUtil.height(node));
       // GenericTreeUtil.treePattern(node);
        //GenericTreeUtil.levelOrder(node);
       // GenericTreeUtil.levelOrderLineByLine(node);

        Node node1=GenericTreeUtil.constructGenericTree(new int[]{10,40,60,-1,70,-1,-1,50,80,-1,-1,-1});
        //GenericTreeUtil.zigzagPrint(node1);
        //GenericTreeUtil.levelOrderLineByLineDelimiterApproach(node1);
        //GenericTreeUtil.levelOrder( GenericTreeUtil.removeLeaves(node1));
        Node node2=GenericTreeUtil.constructGenericTree(new int[]{10,20,-1,30,-1,-1});
       // GenericTreeUtil.linearize(node2);
        GenericTreeUtil.linearize2(node2);
        GenericTreeUtil.levelOrderLineByLine(node2);
        System.out.println(GenericTreeUtil.find(node2,30));
        System.out.println(GenericTreeUtil.find(node2,300));
        System.out.println(GenericTreeUtil.nodeToPath(node2,30));
        System.out.println(GenericTreeUtil.nodeToPath(node2,10));
        System.out.println(GenericTreeUtil.nodeToPath(node2,100));
        System.out.println(GenericTreeUtil.findLeastCommonAncestor(node1,60,70));
        System.out.println(GenericTreeUtil.distanceBetweenTwoNode(node1,60,70));
        System.out.println(GenericTreeUtil.isSimilarShape(node1,node1));
        System.out.println(GenericTreeUtil.isSimilarShape(node1,node2));
        Node node3=GenericTreeUtil.constructGenericTree(new int[]{10,20,-1,30,-1,-1});
        Node node4=GenericTreeUtil.constructGenericTree(new int[]{10,30,-1,20,-1,-1});
        Node node5=GenericTreeUtil.constructGenericTree(new int[]{10,30,40,-1,-1,20,-1,-1});
        System.out.println(GenericTreeUtil.areMirror(node3,node4));
        System.out.println(GenericTreeUtil.areMirror(node3,node5));
        System.out.println(GenericTreeUtil.isSymmetric(node3));
        System.out.println(GenericTreeUtil.isSymmetric(node5));
        GenericTreeUtil.printStats(node5);
        GenericTreeUtil.printPredecessorAndSuccessor(node5,30);
        GenericTreeUtil.printFloorAndCeil(node5,30);
    }
}
