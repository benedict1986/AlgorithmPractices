/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise;

/**
 *
 * @author Admin
 */
public class InvertBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public static void main(String[] args)
    {
        InvertBinaryTree ibt = new InvertBinaryTree();
        int[] list = {4,2,7};
        TreeNode head = null;
        TreeNode pointer = null;
        for(int i : list)
        {
            if (head == null)
            {
                head = new TreeNode(i);
                pointer = head;
            }
            else
            {
                if (pointer.left == null)
                    pointer.left = new TreeNode(i);
                else if (pointer.right == null)
                    pointer.right = new TreeNode(i);
            }
        }
        
        System.out.println(ibt.invertTree(head));
    }
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        
        if (leftNode == null  && rightNode == null)
            return root;
        
        if (leftNode != null)
            root.left = invertTree(leftNode); 
        if (rightNode != null)
            root.right = invertTree(rightNode);
            
        TreeNode temp = root;
        root.right = temp.left;
        root.left = temp.right;
        
        return root;
    }
}
