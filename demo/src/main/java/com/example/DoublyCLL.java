package com.example;

public class DoublyCLL extends DoublyLL {

    public DoublyCLL() {
        super();
    }

    public DoublyCLL(Node n) {
        super();
        getTail().setNext(getHead());
        getTail().setPrev(getHead());
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public void delete(Node n) {
        Node curr = getHead();
        Node temp = getTail();
        //Edge case if list is Empty
        if(curr == null){
            return; 
        }
        //Edge case if head == node
        if(curr.getData() == n.getData()) {
            setHead(getHead().getNext());
            getHead().setPrev(getTail());
            return;
        }
          //Edge case if tail == node
        if(temp.getData() == n.getData()) {
            //tail = tail.getNext();
            setTail(getTail().getPrev());
            getTail().setNext(getHead());
            //if curr.next does equal n, do this next line.
            return;
        }

        //main part
        while(curr.getNext().getData() != n.getData()){
            curr = curr.getNext();
        }
        //if curr.next does equal n, do this next line.
        curr.setNext(curr.getNext().getNext());
        curr.getNext().setPrev(curr);             
    }
    

    @Override
    public void deleteHead() {
        if (getHead() == null) {
            return;
        }
        //if list is only one element
        if(getHead() == getTail()) {
            setHead(null);
            setTail(null);
            return;
        } else {
        setHead(getHead().getNext());
        getHead().setPrev(getTail());
        getTail().setNext(getHead());
        }
    }

    @Override
    public void deleteTail() {
        if (getHead() == null) {
            return;
        } else {
            // checks if the list doesn't contain only one node
            if (getHead() != getTail()) {
                // previous node to the tail will become new tail
                setTail(getTail().getPrev());
                // node next to curent tail will be made null
                getTail().setNext(getHead());

            } else {
                // if the list only contains one element
                // delete it and make both head and tail null
                setHead(null);
                setTail(null);
            }
        }
    }

    @Override
    public void insertHead(Node n) {
        if (getHead() == null) {
            setHead(n);
            setTail(n);
            getHead().setPrev(getTail());
            getHead().setNext(getTail());
            getTail().setNext(getHead());
            getTail().setPrev(getHead());
        }
        else {
            getHead().setPrev(n);
            n.setNext(getHead());
            setHead(n);
            getTail().setNext(getHead());
            getHead().setPrev(getTail());
        }
    }
    

    @Override
    public void insertTail(Node n) {
        if (getHead() == null) {
            setHead(n);
            setTail(n);
            getHead().setPrev(getTail());
            getHead().setNext(getTail());
            getTail().setNext(getHead());
            getTail().setPrev(getHead());
        } else {
            getTail().setNext(n);
            n.setPrev(getTail());
            setTail(n);
            getTail().setNext(getHead());
            getHead().setPrev(getTail());
        }
    }
    

    @Override
    public Node sort(Node headref) {
         // initialize sorted - a sorted doubly linked list
         Node sorted = null;

         // traverse the initial doubly linked list and insert 
         // the correctly placed nodes in sorted.
        System.out.println(size());
         Node current = headref;
         for (int i = 0; i < 2; i++) {
 
             // store the next node from current
             Node next = current.getNext();
 
             // remove connections from current (make prev and next be null)
             current.setPrev(null);
             current.setNext(null);
 
             // insert current into sorted
 
             sorted = sortedInsert(sorted, current);
 
             current = next;
         }
 
         headref = sorted;
 
         return headref;
 
     }

  

    @Override
    public Node sortedInsert(Node headref, Node n) {
        // if (isSorted() == false) {
        //     headref = sort(headref);
        //  }
 
         Node current;
 
         // if list is empty
         if (headref == null) {
             headref = n;
         }
 
         // if the node is inserted at head
 
         else if (headref.getData() >= n.getData()) {
             n.setNext(headref);
             n.getNext().setPrev(n);
             headref = n;
             //headref.setPrev(getTail());

         } else {
             current = headref;
             System.out.println(current.getData());
 
             // find node after the position for the new node
             int count = 0;
            //  while (current.getNext() != null && current.getNext().getData() < n.getData()) {
             do {
                if (current.getNext().getData() < n.getData()) {
                    current = current.getNext();
                    count ++;
                }
            } while (current.getNext() != getHead() && current.getNext().getData() < n.getData());
            //  }
            //  while (current.getNext() != null && current.getNext().getData() < n.getData()) {
            //      current = current.getNext();
            //  }
 
             n.setNext(current.getNext());
 
             // if the new node is not inserted at the tail
            do {
            // if (current.getNext() != null) {
                 n.getNext().setPrev(n);
             } while(current.getNext()!= getHead());
 
             current.setNext(n);
             n.setPrev(current);
         }
 
        //  Node temp = headref;
        //      while(temp.getNext() != null){
        //      temp = temp.getNext();
        //      }
        //      setTail(temp); 
 
         return headref;
     }
        
    

    // @Override
    // public Node search(Node d) {
        
    // }

    // @Override
    // public boolean isSorted() {

    // }

    @Override
    public int size() {
        int iterator = 0;
        if (getHead() == null) {
            return iterator;
        }
        //Regular case
        Node curr = getHead();
        while (curr != getTail()) {
            curr = curr.getNext();
            iterator++;
        }
        curr = curr.getNext();
        iterator++;
        return iterator;
    }


    @Override
    public void print(){
        //System.out.println("TEST");
        
        //Node curr = getHead();
        // if (curr != null) {
        if (isSorted()) {
            System.out.println("Sorted Status: List is sorted");
        } else {
            System.out.println("Sorted Status: List is not sorted");
        }
        // }else{
        //     System.out.println("Soted Status: List is Empty");
        // }
        Node current = getHead();
        for (int i = 0; i < size(); i++){
            
            System.out.println(current.getData());
            current = current.getNext();
        }
        int iterator = size();
            System.out.println("List length: "+iterator+" elements");
    }
    
}
