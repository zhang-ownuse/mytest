package com.zhangbin;

import java.util.Stack;

public class LevelOrder3 {
    public static void levelOrder(TreeNode root){
        if (root == null){
            return ;
        }
        Stack<TreeNode> A = new Stack<>();
        Stack<TreeNode> B = new Stack<>();
        int cheng = 0;
        int num = 1;
        int count = 0;
        int nextCount = 0;
        A.add(root);
        while (!A.isEmpty()|| !B.isEmpty()){
            if (cheng % 2 ==0){
                TreeNode pop = A.pop();
                count++;
                System.out.println(pop.val);
                if (pop.left != null){
                    B.add(pop.left);
                    nextCount++;
                }
                if (pop.right != null){
                    B.add(pop.right);
                    nextCount++;
                }
            }
            if (cheng % 2 == 1){
                TreeNode pop = B.pop();
                count++;
                System.out.println(pop.val);
                if (pop.right != null){
                    A.add(pop.right);
                    nextCount++;
                }
                if (pop.left != null){
                    A.add(pop.left);
                    nextCount++;
                }
            }
            if (count == num){
                num = nextCount;
                count = 0;
                nextCount = 0;
                cheng++;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left =  b;
        a.right = c;
        b.left = d;
        b.right = e;
        levelOrder(a);
    }

}
