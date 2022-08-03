package com.example;

public class LLStack extends SinglyLL {

    public void push(Node node) {
        super.insertHead(node);
    }

    public void insertTail(Node n) {
        // empty body
    }

    public Node pop(Node node) {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        Node temp = getHead();
        super.deleteHead();
        return temp;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int searchPosition(Node node) {
        int count = 0;
        Node current = getHead();
        while (current != null) {
            if (current == node) {
                return count;
            }
            current = current.getNext();
            count ++;
        }
        return -1;
    }

    public Node peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return null;
        }
        return getHead();

    }

    @Override
    public void delete(Node n) {
    
    }

    @Override
    public void deleteTail() {
    
    }

    @Override
    public boolean isSorted() {
        return false;
    }

    @Override
    public Node search(Node d) {
        return null;

    }

    @Override
    public Node sort(Node headref) {
        return null;
    }

    @Override
    public Node sortedInsert(Node headref, Node n) {
        return null;
    }
    
    
}
