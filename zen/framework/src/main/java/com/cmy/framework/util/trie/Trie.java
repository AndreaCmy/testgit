package com.cmy.framework.util.trie;

import java.util.*;

/**
 * Created by mengyingc on 2017/3/30.
 */
public class Trie {
    private static final char BASE = 'a';
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }


    //1.建立字典树
     public void insert(String str){//在字典树中插入一个单词
         if(str == null || str.trim().equals("")){
             return ;
         }
         TrieNode node = root;
         char[] chars = str.trim().toLowerCase().toCharArray();//不区分大小写
         for(int i=0; i<chars.length; i++){
             TrieNode[] children = node.getNext();
             char c = chars[i];
             TrieNode target = children[c-BASE];
             if(target != null){
                 target.setOccurCount(target.getOccurCount());
             }else{

                 target = new TrieNode();
                 target.setNodeValue(c);
             }
             node.getNext()[c-BASE] = target;
             node.setLeaf(false);
             node = target;
         }
         node.setLeaf(true);
     }

    //2.计算单词前缀的数量
    public int occurCount(String prefix){
        if(prefix != null & !prefix.trim().equals("")){
            char[] chars = prefix.toCharArray();
            TrieNode p = this.root;
            for(char c :chars){
                TrieNode[] children = p.getNext();
                TrieNode target = children[c-BASE];
                if(target != null && target.getNodeValue() == c){
                    p = target;
                }else{
                   return 0;//不匹配
                }
            }
            return p.getOccurCount();
        }else{
            return 0;
        }
    }
    //3.打印指定前缀的单词
    public void printPrefix(String prefix){
        if(prefix != null & !prefix.trim().equals("")){
            char[] chars = prefix.toCharArray();
            TrieNode p = this.root;
            for(char c :chars){
                TrieNode[] children = p.getNext();
                TrieNode target = children[c-BASE];
                if(target != null){
                    p = target;
                }else{
                    return;
                }
            }
           traverseWords(p, prefix);
        }
    }
    //4.遍历经过此节点的单词
    public void traverseWords(TrieNode node, String prefix){
            if(!node.isLeaf()){
                TrieNode[] children = node.getNext();
                for(TrieNode c:children){
                    if(c != null){
                        traverseWords(c, prefix+node.getNodeValue());
                    }
                }
                return;
            }else{
                prefix = prefix+node.getNodeValue();
                prefix = prefix.substring(1);
            }
            System.out.println(prefix);
    }
    //5.在字典树种查找一个完全匹配的单词
     public boolean findWord(String word){
         if(word != null & !word.trim().equals("")){
             char[] chars = word.trim().toLowerCase().toCharArray();
             TrieNode p = this.root;
             for(char c:chars){
               TrieNode[] children =  p.getNext();
               TrieNode target = children[c-BASE];
               if(target == null || target.getNodeValue() == '0'){
                   return false;
               }else{
                   p = target;
               }
             }
             if(p.isLeaf()){
                 return true;
             }else{
                 return false;
             }
         }
         return false;
     }

    //6.前序遍历字典树
    public void preTraverse(TrieNode node){
        if(node != null){
            System.out.printf(""+node.getNodeValue()+"-");
            for(TrieNode c :node.getNext()){
                preTraverse(c);
            }

        }
    }

    public TrieNode getRoot() {
        return this.root;
    }

    public void setRoot() {
        this.root = root;
    }

    public static void main(String[]args)
    {
        Trie tree=new Trie();
        String[]strs= {"banana","band","bee","absolute","acm",};
        String[]prefix= {"ba","b","band","abc",};
        for(String str:strs)
        {
            tree.insert(str);
        }
        System.out.println(tree.findWord("abc"));
        tree.preTraverse(tree.getRoot());
        System.out.println();
        //tree.printAllWords();
        for(String pre:prefix)
        {
            int num=tree.occurCount(pre);
            System.out.println(pre+"数量:"+num);
        }
        TrieNode b = tree.getRoot().getNext()['b'-BASE];
        tree.traverseWords(b, "b");
    }
}
