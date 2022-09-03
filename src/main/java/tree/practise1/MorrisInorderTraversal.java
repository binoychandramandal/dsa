package tree.practise1;

public class MorrisInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        root.left = l1;
        TreeNode r1 = new TreeNode(3);
        root.right = r1;
        TreeNode l11 = new TreeNode(4);
        l1.left = l11;
        l11.right = new TreeNode(8);
        TreeNode r11 = new TreeNode(5);
        r1.left = r11;
        r11.right = new TreeNode(6);
        display(root);
        System.out.println();
        morrisInOrder(root);
    }

    private static void morrisInOrder(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode left = cur.left;
            if (left == null) {
                System.out.print(cur.val + " ");
                cur = cur.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, cur);
                if(rightMostNode.right==null){
                    rightMostNode.right=cur;
                    cur=cur.left;
                }else{
                    rightMostNode.right=null;
                    System.out.print(cur.val+" ");
                    cur=cur.right;
                }
            }
        }
    }

    private static TreeNode getRightMostNode(TreeNode left, TreeNode cur) {
        while (left != null && left.right != null && left.right != cur) left = left.right;
        return left;
    }


    private static void display(TreeNode root) {
        if (root == null)
            return;
        display(root.left);
        System.out.print(root.val);
        display(root.right);
    }

}
