package neetcode.tree;

import sun.reflect.generics.tree.Tree;

public class GenerateBinaryTree {
    public static void main(String[] args) {
        GenerateBinaryTree gbt = new GenerateBinaryTree();
        TreeNode root = gbt.constructBinaryTree(new Integer[]{2, null, 4, 10, 8, null, null, 4}, 0);
        System.out.println(root);
    }
    public TreeNode constructBinaryTree(Integer[] arr, int index){
        if(index>=arr.length || arr[index] == null){
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        root.left = constructBinaryTree(arr, 2*index+1);
        root.right = constructBinaryTree(arr, 2*index+2);
        return root;
    }
}
