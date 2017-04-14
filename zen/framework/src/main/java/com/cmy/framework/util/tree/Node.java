package com.cmy.framework.util.tree;

/**
 * Created by mengyingc on 2017/4/7.
 */
public class Node<T extends  Comparable<T>>{
    private T value;
    private Node left, right;
    private Node parent;
    private boolean isRed;

    public Node(){
    }

    public Node(T value, boolean color){
        this.value = value;
        this.isRed = color;
    }


    public boolean isRed(){
        return isRed;
    }

    public  boolean isBlack(){
        return !isRed;
    }

    public void makeRed(){
        isRed = true;
    }

    public void makeBlack(){
        isRed = false;
    }
    public boolean isLeaf(){
        return left == null && right == null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                ", parent=" + parent +
                ", isRed=" + isRed +
                '}';
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean getIsRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }
}
