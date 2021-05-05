package com.zhangbin;

import java.util.*;

public class TreeNode {
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
//
//    public static boolean hasPathSum(TreeNode root, int sum) {
//
//
//        if (root == null){
//            return false;
//        }
//
//        if (root.left == null && root.right == null && root.val == sum){
//            return true;
//        }
//        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
//    }
//
//    public int pathSum(TreeNode root, int sum) {
//        if (root == null){
//            return 0;
//        }
//        int ret = pathStartWithRoot(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
//        return ret;
//    }
//
//    private int pathStartWithRoot(TreeNode root, int sum) {
//        if (root == null){
//            return 0;
//        }
//        int ret = 0;
//        if (sum == root.val ) ret++;
//        ret += pathStartWithRoot(root.left, sum - root.val) + pathStartWithRoot(root.right, sum - root.val);
//        return ret;
//    }
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        if (s == null){
//            return false;
//        }
//        return toTest(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
//    }
//    public boolean toTest(TreeNode s,TreeNode t){
//        if (s == null && t == null){
//            return true;
//        }
//        if ((s == null && t != null) || (s != null && t == null))
//            return false;
//        return s.val == t.val && toTest(s.left,t.left) && toTest(s.right,t.right);
//    }

//    public static boolean isSubtree(TreeNode s, TreeNode t) {
//        String s1 = serialByPre(s);
//        String s2 = serialByPre(t);
//        //        System.out.println(split[0]);
////        System.out.println(s2);
////        System.out.println(s1);
////        System.out.println(s2);
//        String[] split = s1.split("!");
//        String[] split1 = s2.split("!");
//        for (int i = 0; i < split.length; i++) {
//            System.out.print(split[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < split1.length; i++) {
//            System.out.print(split1[i] + " ");
//        }
////        System.out.println(split[0]);
////        System.out.println(s2);
//        return hasRes(split,split1);
//    }
//
//    //前序序列化二叉树把二颗子树都序列化以后进行kmp算法
//    public static String serialByPre(TreeNode node){
//        if (node == null){
//            return "#!";
//        }
//        String res = node.val + "!";
//        res += serialByPre(node.left);
//        res += serialByPre(node.right);
//        return res;
//    }
//
//    //kmp算法返回是否能够找到最长的子序列
//    public static boolean hasRes(String[] resource,String[] target){
////        char[] chars = resource.toCharArray();
////        System.out.println(chars[0]);
//        int[] next = getNext(target);
////        System.out.println(next);
//        for (int i = 0; i < next.length; i++) {
//            System.out.println(next[i]);
//        }
//        int i1=0;
//        int i2=0;
//        while (i1<resource.length && i2<target.length) {//进行比较
////            System.out.println("resource"+resource[i1]);
////            System.out.println("target"+target[i2]);
//            if (resource[i1].equals(target[i2])){//如果二者相等就都往后推
//
////                System.out.println(resource.charAt(i2));
//                i1++;
//                i2++;
//            }else if (next[i2] == -1){//如果跟头部比较都不相等则大数列往前推
//                i1++;
//            }else {
//                i2 = next[i2];
//            }
//        }
////        System.out.println("从这个位置开始的" + (i1-target.length));
//        return i2 == target.length?true:false;
//    }
//
//    public static int[] getNext(String[] target){
//        if (target.length == 0){
//            return new int[]{-1};
//        }
//        int[] next = new int[target.length];
//        next[0] = -1;
//        next[1] = 0;
//        int i = 2;//从2开始进行查询
//        int cn = 0;//表示我前一个的匹配长度
//        while ( i < target.length){
////            System.out.println(target.charAt(i - 1));
//            if (target[i-1].equals(target[cn])){//如果我的前面的这个值和它所在的最长子串的后面的那个值相等，则这个更长了
//
//                next[i++] = ++cn;
//            }else if ( cn > 0){//如果它还没有回到0的话也就是还没有到达第一个值
//                cn = next[cn];
//            }else {//回到了0
//                next[i++]=0;
//            }
//        }
//        return next;
//    }
//    public static boolean isSymmetric(TreeNode root) {
//        //如果根节点为空
//        if (root == null){
//            return true;
//        }
//        return isSymmetric(root.left,root.right);
//    }
//    public static boolean isSymmetric(TreeNode left,TreeNode right){
//        //二边都为空
//        if (left == null && right == null){
//            return true;
//        }
//        //只有一个为空
//        if (left == null || right ==null){
//            return false;
//        }
//        //二边 都不为空 ，则数值不相等返回false
//        if (left.val != right.val){
//            return false;
//        }
//        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
//    }
//    public static Integer min=Integer.MAX_VALUE;
//    public static int minDepth(TreeNode root) {
//        if (root == null){
//            return 0;
//        }
//        findMin(root,1);
//
//        return min;
//    }
//    public static void findMin(TreeNode node,int heigh){
//        if (node == null){
//            return ;
//        }
//        if (node.left == null && nodeF.right == null){
//            if (heigh < min){
//                min = heigh;
//            }
//            return ;
//        }
//        findMin(node.left,heigh + 1);
//        findMin(node.right,heigh + 1);
//    }

//    public  static  void minDepth(TreeNode head) {
//        if (head != null) {
//            Stack<TreeNode> stack = new Stack<TreeNode>();
//            stack.add(head);
//            while (!stack.isEmpty()) {
//                head = stack.pop();
//                System.out.print(head.val + " ");
//                if (head.right != null) {
//                    stack.push(head.right);
//                }
//                if (head.left != null) {
//                    stack.push(head.left);
//                }
//            }
//        }
//        System.out.println();
//    }

//    public static int sumOfLeftLeaves(TreeNode root) {
//        if (root ==null){
//            return 0;
//        }
//        int sum = 0;
//        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
//        treeNodeQueue.offer(root);
//
//        while(!treeNodeQueue.isEmpty()){//
//            TreeNode poll = treeNodeQueue.poll();//获取第一个节点
//            if (poll.left != null){
//                if (poll.left.left == null && poll.left.right == null) {
//                    sum += poll.left.val;
//                }
//                treeNodeQueue.offer(poll.left);
//            }
//            if (poll.right != null){
//                treeNodeQueue.offer(poll.right);
//            }
//        }
//        return sum;
//    }
//        public static int findSecondMinimumValue(TreeNode root) {
//        if (root == null){
//            return -1;
//        }
//        //如果左右孩子都没有 并且递归到这一点的时候就代表这边没有比根节点大的值
//        if (root.left == null && root.right == null){
//            return -1;
//        }
//
//        int leftVal = root.left.val;
//        int rightVal = root.right.val;
//
//        if (leftVal == root.val){
//            leftVal = findSecondMinimumValue(root.left);
//        }
//        if (rightVal == root.val){
//            rightVal = findSecondMinimumValue(root.right);
//        }
//
//        if (leftVal != -1 && rightVal != -1){
//            return  Math.min(leftVal,rightVal);
//        }
//        if (leftVal == -1){
//            return rightVal;
//        }else {
//            return leftVal;
//        }
//
//        }

//    public static List<Double> averageOfLevels(TreeNode root) {
//        List<Double> result = new ArrayList<>();
//        if (root == null) return result;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        //这里面要保证每次做的操作都是相同的操作
//        while (!queue.isEmpty()){
//            int sum = 0;
//            int cnt = queue.size();
//            for (int i = 0; i < cnt; i++) {
//                TreeNode poll = queue.poll();
//                if (poll.left!= null ){
//                    queue.offer(poll.left);
//                }
//                if (poll.right!= null ){
//                    queue.offer(poll.right);
//                }
//                sum += poll.val;
//                System.out.println(sum);
//            }
//            result.add(sum/(cnt*1.0));
//        }
//        return result;
//    }

//    public int findBottomLeftValue(TreeNode root) {
//        int result = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        //这里面要保证每次做的操作都是相同的操作
//        while (!queue.isEmpty()){
//            result = queue.peek().val;
//            int cnt = queue.size();
//            for (int i = 0; i < cnt; i++) {
//                TreeNode poll = queue.poll();
//                if (poll.left!= null ){
//                    queue.offer(poll.left);
//                }
//                if (poll.right!= null ){
//                    queue.offer(poll.right);
//                }
//
//            }
//        }
//        return result;
//    }
public  static int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        root = queue.poll();
        System.out.println(root.val);
        if (root.right != null) queue.add(root.right);
        if (root.left != null) queue.add(root.left);
    }
//    System.out.println(root.val);
    return root.val;
}
        public static void main(String[] args) {
        TreeNode head = new TreeNode(2);
        head.left = new TreeNode(1);
        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(1);
//        head.left.right = new TreeNode(2);
//        head.left.right.left = new TreeNode(0);
//        head.left.left.left = new TreeNode(11);
//        head.right.left = new TreeNode(5);
//        head.right.right = new TreeNode(7);
//        head.right.left.left = new TreeNode(6);
//        head.right.right = new TreeNode(10);
//        head.right.right.left = new TreeNode(9);
//        head.left.left.left = new TreeNode(7);
//        head.left.left.right = new TreeNode(2);
//        head.right.right.right = new TreeNode(1);
//        head.right.right.right.right = new TreeNode(1);
//        head.right.right.right.right.right = new TreeNode(1);
//        head.right.right.right.right.right.right = new TreeNode(1);
//        head.right.right.right.right.right.right.left = new TreeNode(2);
//        boolean b = hasPathSum(head, 22);
//        System.out.println(b);
//        printTree(head);
//        TreeNode test = new TreeNode();
//        boolean b = hasPathSum(head, 22);
//        String s = serialByPre(head);
        TreeNode two = new TreeNode(1);
//        two.left = new TreeNode(1);
//        two.left.left = new TreeNode(1);
//        two.left.left.r = new TreeNode(1);
        two.right = new TreeNode(1);
        two.right.right = new TreeNode(1);
        two.right.right.left = new TreeNode(2);
//        boolean subtree = isSubtree(head,two);
//        System.out.println(subtree);
//        System.out.println(s);
//        printTree(head);
//        pathSum()
//        System.out.println(b);
//            boolean symmetric = isSymmetric(head);
//            System.out.println(symmetric);
//        int[] next = getNext("abcabd");
//        for (int i = 0; i < next.length; i++) {
//            System.out.println("s" + next[i]);
//        }
//            minDepth(head);
//            int i = minDepth(head);
//            System.out.println(i);
//        String test = "hello";
//            int i = sumOfLeftLeaves(head);
//            List<Double> doubles = averageOfLevels(head);
//            for (int i = 0; i < doubles.size(); i++) {
//                System.out.println(doubles.get(i));
//            }
            int bottomLeftValue = findBottomLeftValue(head);

//        System.out.println(test);
    }
}
