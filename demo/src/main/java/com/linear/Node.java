package com.linear;

//Basic Node Class

 public class Node {
    public int data;
    public Node next;
    public Node prev;

    //Constructor for Node class
    Node(int d){
        setData(d);
        setNext(null);
        setPrev(null);
    }

    public int getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setData(int d) {
        this.data = d;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return this.prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    
    
}
