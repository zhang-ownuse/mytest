package com.zhangbin;

import java.util.ArrayList;
import java.util.List;

public class LlevelOrder {

    public static void levelOrder(TreeNode root){
        if (root == null){
            return;
        }
        List<TreeNode> res = new ArrayList<>();

        res.add(root);
        while (res.size() > 0){
            TreeNode treeNode = res.get(0);
            res.remove(0);
            System.out.println(treeNode.val);
            if ( treeNode.left != null){
                res.add(treeNode.left);
            }
            if ( treeNode.right != null){
                res.add(treeNode.right);
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
