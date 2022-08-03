package com.example;

public class LLQueue extends SinglyLL{

    //enque
    // inserts at back on list
    // calls super.InsertTail(node)
    public void enque(Node node){
        super.insertTail(node);

    }
    
    //deque
    //takes out at front of list 
    // calls super.DeleteHead(node)
    public Node deque(Node node){
        if (size() == 0) {
            System.out.println("Queue is empty.");
            return null;
        }
        Node temp = this.getHead();
        super.deleteHead();
        return temp;
    }

    public Node peek(){
        if (size() == 0) {
            System.out.println("Queue is empty.");
            return null;
        }
        return this.getHead();
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


    @Override
    public void insertHead(Node n){
        //leave as blank
    }

    @Override
    public void insertTail(Node n) {
        //leave as blank
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        super.clear();
    }

    @Override
    public void delete(Node n) {
        // TODO Auto-generated method stub
        //super.delete(n);
    }

    @Override
    public void deleteTail() {
        // TODO Auto-generated method stub
        //super.deleteTail();
    }

    // @Override
    // public boolean isSorted() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    //GOTTA CHANGE THIS

    @Override
    public Node sort(Node headref) {
        // TODO Auto-generated method stub
        //return super.sort(headref);
        return null;
    }

    @Override
    public Node sortedInsert(Node headref, Node n) {
        // TODO Auto-generated method stub
        //return super.sortedInsert(headref, n);
        return null;
    }
    
    

    
}
