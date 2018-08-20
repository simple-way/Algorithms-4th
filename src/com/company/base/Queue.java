package com.company.base;

import java.util.Iterator;

public class Queue<Item> {
    private Node first;//指向最早添加的节点的链接
    private Node last;//指向最晚添加的节点的链接
    private int N;
    private class Node{
        //定义了节点的嵌套类
        Item item;
        Node next;
    }
    public boolean isEmpty(){return first == null;}
    public int size() {return N;}
    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;
    }
    public Iterator<Item> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
