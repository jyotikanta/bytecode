package neetcode.tree;

import java.util.TreeMap;

class FindGoodNodes {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(4);
        node1.right=node2;
        node2.left = node3;
        node2.right = node4;
        node4.left=node5;
        System.out.println(new FindGoodNodes().goodNodes(node1));
    }
    private int goodNodes = 1;
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    public int countGoodNodes(TreeNode root, int max) {
        if(root==null){
            return 0;
        }
        int maxLeft = max;
        int maxRight = max;

        if(root.left!=null){

            if(root.left.val>=max){
                goodNodes++;
                maxLeft = root.left.val;
            }
            countGoodNodes(root.left, maxLeft);
        }

        if(root.right!=null){
            if(root.right.val>=max){
                goodNodes++;
                maxRight = root.right.val;
            }
            countGoodNodes(root.right, maxRight);
        }

        return goodNodes;
    }
}
