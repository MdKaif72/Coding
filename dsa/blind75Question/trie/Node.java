package dsa.blind75Question.trie;

public class Node {

        Node links[];
        boolean flag;

    public Node(){
        this.links= new Node[26];
        this.flag=false;


    }

    boolean containsKey(char ch){
        return (links[ch-'a']) !=null;
    }

    Node get (char ch){
        return links[ch-'a'];

    }

    void put(char ch,Node node){
        links[ch-'a'] = node;
    }
    void setEnd(){
        flag=true;
    }
    boolean isEnd(){
        return flag;
    }
}
