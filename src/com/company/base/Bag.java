package com.company.base;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first;//链表首节点

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node{
        Item item;
        Node next;
    }
    public void add(Item item){
        //和Stack的push()方法完全相同
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
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
