package com.cmy.framework.util.tree;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by mengyingc on 2017/4/7.
 * 红黑树结构
 */
public class RedBlackBST<T extends  Comparable<T>> {
//**************************定义*************************************
    private  static final boolean RED = true;
    private  static  final boolean BLACK = false;

    private Node root;
    private AtomicLong size = new AtomicLong(0);//node number

    public RedBlackBST(){
        this.root = new Node();
    }

    //************************操作*****************************************
    //左旋转
    public void leftRotate(Node node){
             if(node != null){
                 //将node的右孩子的左孩子变成node的右孩子
                  Node node_right = node.getRight();
                  if(node_right != null){
                      Node node_right_left = node_right.getLeft();
                      node.setRight(node_right_left);
                      if(node_right_left != null){//注意修改父节点指针
                          node_right_left.setParent(node);
                      }
                  }
                 //将node的父节点的孩子变成node的右孩子
                 Node parent = node.getParent();
                  if(parent == null){
                      root = node_right;
                  }else{
                      if(parent.getLeft() == node){
                          parent.setLeft(node_right);
                      }else{
                          parent.setRight(node_right);
                      }
                  }
                 //将node变成右孩子的左孩子
                 node_right.setLeft(node);
                 node.setParent(node_right);
             }
    }

    //右旋转
    public void rightRotate(Node node){
        if(node != null){
            //将node的左孩子的右孩子变成node的左孩子
            Node node_left = node.getLeft();
            if(node_left != null){
                Node node_left_right = node_left.getRight();
                node.setLeft(node_left_right);
                if(node_left_right != null){//注意修改父节点指针
                    node_left_right.setParent(node);
                }
            }
            //将node的左节点变成node的parent的孩子
            Node parent = node.getParent();
            if(parent == null){
                root = node_left;
            }else{
                if(parent.getLeft() == node){
                    parent.setLeft(node_left);
                }else{
                    parent.setRight(node_left);
                }
            }

            //将node变成左孩子的右孩子
            node_left.setRight(node);
            node.setParent(node_left);
        }
    }

    //颜色转换
    public void changeColor(){

    }

    //TODO 插入节点
    private void insertNode(Node node){
        Node<T> root = this.getRoot();
        while(root != null){
            int compare = root.getValue().compareTo(value);
            if(compare > 0){//root>value
                root = root.getLeft();
            }else if(compare < 0){//root<value
                root = root.getRight();
            }else{
                return root.getValue();
            }
        }//end while
        return null;
    }
    //TODO 修正节点
    private void fixUpNode(Node node){

    }
    //插入节点并修正
    public void insertKeyToTree(T value){
         Node node = new Node();
         node.setRed(RED);
         insertNode(node);
         fixUpNode(node);
    }

    //删除节点
    public T deleteNode(T value){
        Node<T> root = this.getRoot();
        Node<T> parent = root;
        while(root != null){
            int compare = root.getValue().compareTo(value);
            if(compare > 0){//root>value
                parent = root;
                root = root.getLeft();
            }else if(compare < 0){//root<value
                parent = root;
                root = root.getRight();
            }else{
               //TODO 删除当前节点

            }
        }//end while
        return null;
    }

    //查找节点-非递归
    public T searchNode(T value){
        Node<T> root = this.getRoot();
        while(root != null){
            int compare = root.getValue().compareTo(value);
            if(compare > 0){//root>value
                root = root.getLeft();
            }else if(compare < 0){//root<value
                root = root.getRight();
            }else{
                return root.getValue();
            }
        }//end while
        return null;
    }

    public T search(T value){
        Node<T> root = this.getRoot();
        Node<T> node = searchNodeRecursive(value, root);
        return node == null?null:node.getValue();
    }
    //查找节点-递归
    private Node<T> searchNodeRecursive(T value, Node<T> root){
        if(root != null){
            int compare = root.getValue().compareTo(value);
            if(compare > 0){//root>value
                return searchNodeRecursive(value, root.getLeft());
            }else if(compare < 0){//root<value
                return searchNodeRecursive(value, root.getRight());
            }else{
                return root;
            }
        }//end while
        return null;
    }

    //前序遍历节点
    public void preOrder(Node<T> node){
      if(node != null){
          System.out.println("-"+node.getValue()+"["+(node.getIsRed()?"红":"黑")+"]");
      }
    }
    /*********************************************/
    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public AtomicLong getSize() {
        return size;
    }

    public void setSize(AtomicLong size) {
        this.size = size;
    }
}
