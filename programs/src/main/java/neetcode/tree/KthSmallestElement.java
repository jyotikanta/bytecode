package neetcode.tree;

public class KthSmallestElement {
    public static void main(String[] args) {
        GenerateBinaryTree gbt = new GenerateBinaryTree();
        TreeNode root = gbt.constructBinaryTree(new Integer[]{5,3,6,2,4,null,null,1}, 0);
        System.out.println(kthSmallest(root,1));
    }

    static int count = 0;
    static int res = 0;
    public static int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root,k);
        return res;
    }

    public static void inorderTraversal(TreeNode root, int k){
        if(root==null){
            return;
        }
        inorderTraversal(root.left, k);
        count++;
        if(count == k){
            res = root.val;
            return;
        }
        inorderTraversal(root.right, k);
    }
}
