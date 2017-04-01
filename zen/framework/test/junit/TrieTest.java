package junit;

import com.cmy.framework.util.trie.Trie;
import org.junit.Test;

/**
 * Created by mengyingc on 2017/4/1.
 */

public class TrieTest
{
    @Test
    public void testFindWord(){
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("hi");
        trie.insert("hello");

        System.out.println( trie.findWord("hello"));
        System.out.println( trie.findWord("you"));
    }

    @Test
    public void testInsert(){
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("hi");
        trie.preTraverse(trie.getRoot());
    }

    @Test
    public void testOccurCount(){
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("hi");
        trie.insert("hello");
        trie.occurCount("hello");
    }

    @Test
    public void testPrintPrefix(){
        Trie trie = new Trie();
        trie.insert("world");
        trie.insert("hi");
        trie.insert("hello");
        trie.printPrefix("h");
    }
}
