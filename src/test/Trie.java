package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by AlexP on 5/28/2018.
 */
public class Trie{

    private Node<Character> root;

    private class Node<T extends Comparable>{
        private HashMap<T,Node> children;
        private T data;

        public Node(T data){
            this.data = data;
            children  = new HashMap<>(128);
        }


        public Node getChild(T data){
            if(children.containsKey(data)){
                return children.get(data);
            }
            return null;
        }

        public Node putChild(T elem){
            Node v = getChild(elem);
            if(v==null){
                children.put(elem,new Node<T>(elem));
            }
            return v;
        }

        public T getData(){
            return data;
        }

        public boolean isLeaf(){
            return children.isEmpty();
        }


    }




}
