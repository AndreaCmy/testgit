package com.cmy.controller.test.algorithm;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 树的层次遍历-使用双向队列dequeue
 * 根节点从头部出队，然后将子节点从尾部压入队列
 * Created by mengyingc on 2017/4/28.
 */
public class TreeLevelTraverse {

    public static void traverse(TreeNode root){
        if(root == null) return;
        Deque<TreeNode> deque =  new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            System.out.print(node.getValue() + " ");
            if (node.getLeft() != null) {
                deque.addLast(node.getLeft());
            }
            if (node.getRight() != null) {
                deque.addLast(node.getRight());
            }
        }//end while

    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(5, null, null);
        TreeNode right = new TreeNode(8, null, new TreeNode(3,null, null));
        TreeNode root = new TreeNode(10, left, right);
        traverse(root);
        //预期输出 10 5 8 3
    }

    private static class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(){

        }

        public TreeNode(int value, TreeNode left, TreeNode right){
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
}
