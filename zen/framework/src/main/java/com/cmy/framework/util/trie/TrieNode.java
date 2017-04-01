package com.cmy.framework.util.trie;

/**
 *
 * Created by mengyingc on 2017/3/30.
 */
public class TrieNode {
    private static final int CHARACTER_SIZE = 26;
    private char nodeValue ;
    private TrieNode[] next;//最多26个子节点
    private boolean isLeaf;//是否叶子节点，此节点为止可以构成单词
    private int occurCount;//前缀出现的次数

    public TrieNode(){
       this.isLeaf = false;
       this.nodeValue = '0';
       this.occurCount = 1;
       this.next = new TrieNode[CHARACTER_SIZE];
    }

    public TrieNode(char nodeValue, boolean isLeaf, int occurCount){
        this.nodeValue = nodeValue;
        this.isLeaf = isLeaf;
        this.occurCount = occurCount;
        this.next = new TrieNode[CHARACTER_SIZE];
    }

    public TrieNode[] getNext() {
        return next;
    }

    public void setNext(TrieNode[] next) {
        this.next = next;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public int getOccurCount() {
        return occurCount;
    }

    public void setOccurCount(int occurCount) {
        this.occurCount = occurCount;
    }

    public char getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(char nodeValue) {
        this.nodeValue = nodeValue;
    }
}
