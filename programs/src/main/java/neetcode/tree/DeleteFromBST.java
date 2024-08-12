package neetcode.tree;

public class DeleteFromBST {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        node1.left = new TreeNode(4);
        node1.right = new TreeNode(6);
        InsertBST insertBST = new InsertBST();
        insertBST.insertIntoBST(node1, 0);
        System.out.println(new DeleteFromBST().findMinNode(node1).val);
    }

    public TreeNode deleteNode(TreeNode root, int key){
        if(root==null)
            return null;
        if(root.val > key)
            root.left = deleteNode(root.left, key);
        else if (root.val < key)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            } else{
                TreeNode min = findMinNode(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }
        return root;
    }

    public TreeNode findMinNode(TreeNode root) {
        while (root!=null && root.left!=null)
            root = root.left;
        return root;
    }
}

