package com.zhangbin;

import java.util.Map;

public class TreeToLetCode {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
//    private  static boolean result = true;
//
//    public  static boolean  isBalanced(TreeNode root) {
//        maxDepth(root);
//        return result;
//    }
//
//    public static int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        int l = maxDepth(root.left);
//        int r = maxDepth(root.right);
//        if (Math.abs(l - r) > 1) result = false;
//        return 1 + Math.max(l, r);
//    }
//    public static int max = 0;
//    public static  int diameterOfBinaryTree(TreeNode root) {
//        depth(root);
//        return max;
//    }
//
//    public static int depth(TreeNode root){
//        if (root == null){
//            return 0;
//        }
//        int leftDepth = depth(root.left);//找左边的最大深度
//        int rightDepth = depth(root.right);//找右边的最大深度m
//        max = Math.max(max,leftDepth + rightDepth);
//        return Math.max(leftDepth,rightDepth) + 1;
//    }

//    public static TreeNode invertTree(TreeNode root) {
//        invert(root);
//        return root;
//    }
//
//    public static void invert(TreeNode root){
//        if (root == null){
//            return;
//        }
//        invert(root.left);
//        invert(root.right);
//        TreeNode t = root.left;
//        root.left = root.right;
//        root.right = t;
//    }


    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }


    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null){
                return null;
            }
            if (t1 == null){
                return t2;
            }
            if (t2 == null){
                return t1;
            }
            TreeNode treeNode = new TreeNode(t1.val+t2.val);
            treeNode.left = mergeTrees(t1.left,t2.left);
            treeNode.right = mergeTrees(t1.right,t2.right);
            return treeNode;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(3);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(4);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        TreeNode two = new TreeNode(2);
        two.left = new TreeNode(1);
        two.right = new TreeNode(3);
//        two.left.left = new TreeNode(2);
        two.left.right = new TreeNode(4);
//        two.left.left.left = new TreeNode(1);
//        two.right.left = new TreeNode(7);
//        two.right.left.left = new TreeNode(6);
        two.right.right = new TreeNode(7);
//        two.right.right.left = new TreeNode(9);
//        two.right.right.right = new TreeNode(11);
//        boolean balanced = isBalanced(head);
//        System.out.println(balanced);
//        int i = diameterOfBinaryTree(head);
//        System.out.println(i);

//        TreeNode treeNode = invertTree(head);
        TreeNode treeNode = mergeTrees(head, two);
        printTree(treeNode);
    }
}
