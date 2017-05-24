package com.cmy.controller.test.algorithm;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengyingc on 2017/5/5.
 */
public class LinkListReverse {
    public static TreeNode init(){
        List<TreeNode> list = new ArrayList<>();
        TreeNode node5 = new TreeNode(5);
        TreeNode node4= new TreeNode(4, node5);
        TreeNode node3= new TreeNode(3, node4);
        TreeNode node2= new TreeNode(2, node3);
        TreeNode root = new TreeNode(1,node2);

        TreeNode node = root;
        while(node != null){
            System.out.print(node.getValue() + ">>");
            node = node.getNext();
        }
        System.out.println();
        return root;
    }
    public static void reverse(TreeNode root){
        TreeNode head = root;
        TreeNode pre = null;
        TreeNode cur = head;
        TreeNode next = head.next;

        while (next!= null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;


        TreeNode node = cur;
        while(node != null){
            System.out.print(node.getValue() + ">>");
            node = node.getNext();
        }
        System.out.println();
    }

    private static class TreeNode
    {
        public TreeNode(){

        }
        public TreeNode(int value){
            this.value = value;
            this.next = null;
        }
        public TreeNode(int value, TreeNode next){
            this.value = value;
            this.next = next;
        }
     private  int value;
     private TreeNode next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getNext() {
            return next;
        }

        public void setNext(TreeNode next) {
            this.next = next;
        }
    }
    public static void main(String[] args) {
        TreeNode root =   init();
        reverse(root);
    }
}
