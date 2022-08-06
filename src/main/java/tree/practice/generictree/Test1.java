package tree.practice.generictree;

public class Test1 {
    public static void main(String[] args) {
        Node root = TreeUtil.generateTree();
        TreeUtil.dfs(root);
        TreeUtil.bfs(root);
        System.out.println(TreeUtil.sizeUsingBFS(root));
        System.out.println(TreeUtil.sizeUsingDFS(root));
        System.out.println(TreeUtil.max(root));
        System.out.println(TreeUtil.maxUsingBFS(root));
        System.out.println(TreeUtil.height(root));
    }


}
