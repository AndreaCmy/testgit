package com.cmy.controller.test.algorithm;

/**
 * 判断给定数组是否是树的后序遍历:
 * 最后一个节点是根节点，所有比跟根节点小的元素是左子树，比根节点打的元素是右子树
 * Created by mengyingc on 2017/4/28.
 */
public class IsPostOrderTraverse {

    public static boolean isPostOrderTraverse(int[] order) {
        boolean postOrder = true;
        if (order == null) {
            return false;
        }
        postOrder = isTree(order,  0 , order.length - 1);
        return postOrder;
    }

    public static boolean isTree(int[] order,int from, int to) {
        boolean isTree = true;
        int rootVal = order[to];
        if (order == null) {
            return false;
        }
        int split = 0;
        for(split= from ; split<to-1; split++){
            if(order[split] < rootVal){
                continue;
            }else{
                break;
            }
        }
        if(split < to){
            for(int i = split; i < to-1; i++){
                if(order[i] > rootVal){
                    continue;
                }else{
                    isTree = false;
                    break;
                }
            }
        }
        if (isTree && split > from) {
            isTree = isTree(order, from, split - 1);
        }
        if (isTree &&  split < to) {
            isTree = isTree(order, split, to - 1);
        }
        return isTree;
    }

    private static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] postOrder = new int[]{5, 3, 8, 10};
        System.out.println(isPostOrderTraverse(postOrder));

        int[] NotpostOrder = new int[]{7,4,6,5};
        System.out.println(isPostOrderTraverse(NotpostOrder));

    }
}
