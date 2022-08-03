package com.example;

public class DoublyLL extends SinglyLL {

    public DoublyLL() {
        super();
        setTail(null);
    }

    public DoublyLL(Node n)  {
        super();
    }

    public void insertHead(Node n){
        if (getHead() == null) {
            setHead(n);
            setTail(n);
            getHead().setPrev(null);
            getTail().setNext(null);
        }
        else {
            getHead().setPrev(n);
            n.setNext(getHead());
            setHead(n);
        }
    }

    public void insertTail(Node n) {
        if (getHead() == null) {
            setHead(n);
            setTail(n);
            getHead().setPrev(null);
            getTail().setNext(null);
        } else {
            getTail().setNext(n);
            n.setPrev(getTail());
            setTail(n);
            getTail().setNext(null);
        }

    }
        
//     public boolean isSorted() {
        // nothing needs to change.

// }

    public Node sortedInsert(Node headref, Node n){
        if (isSorted() == false) {
           headref = sort(headref);
        }

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
        } else {
            current = headref;

            // find node after the position for the new node
            while (current.getNext() != null && current.getNext().getData() < n.getData()) {
                current = current.getNext();
            }

            n.setNext(current.getNext());

            // if the new node is not inserted at the tail
            if (current.getNext() != null) {
                n.getNext().setPrev(n);
            }

            current.setNext(n);
            n.setPrev(current);
        }

        Node temp = headref;
            while(temp.getNext() != null){
            temp = temp.getNext();
            }
            setTail(temp); 

        return headref;
    }

    public Node sort(Node headref){
        // initialize sorted - a sorted doubly linked list
        Node sorted = null;

        // traverse the initial doubly linked list and insert 
        // the correctly placed nodes in sorted.

        Node current = headref;
        while (current != null) {

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

//     public Node search(Node d){
        // nothing needs to change.

// 	}

    public void deleteHead(){
        if (getHead() == null) {
            return;
        }

        setHead(getHead().getNext());

        if (getHead() == null) {
            setTail(null);
        }
        else {
            getHead().setPrev(null);
        }
    }

    public void deleteTail(){
        if (getHead() == null) {
            return;
        } else {
            // checks if the list doesn't contain only one node
            if (getHead() != getTail()) {
                // previous node to the tail will become new tail
                setTail(getTail().getPrev());
                // node next to curent tail will be made null
                getTail().setNext(null);

            } else {
                // if the list only contains one element
                // delete it and make both head and tail null
                setHead(null);
                setTail(null);
            }
        }
 
    }

        public void delete(Node n){ 
            Node curr = getHead();
            Node temp = getTail();
            //Edge case if list is Empty
            if(curr == null){
                return; 
            }
            //Edge case if head == node
            if(curr.getData() == n.getData()) {
                setHead(getHead().getNext());
                getHead().setPrev(null);
                return;
            }
              //Edge case if tail == node
            if(temp.getData() == n.getData()) {
                //tail = tail.getNext();
                setTail(getTail().getPrev());
                getTail().setNext(null);
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

        public void clear() {
            setHead(null);
            setTail(null);
        }

    //     public void print() {
    //     Node curr = this.head;
    //     // if (curr != null) {
    //         // if (isSorted()) {
    //         //     System.out.println("Sorted Status: List is sorted");
    //         // } else {
    //         //     System.out.println("Sorted Status: List is not sorted");
    //         // }
    //     // }else{
    //     //     System.out.println("Soted Status: List is Empty");
    //     // }
    //     int iterator = 0;
    //     while(curr != null) {
    //         System.out.println(curr.getData());
    //         curr = curr.getNext();
    //         iterator++;
    //     }
    //         System.out.println("List length: "+iterator+" elements");
    // }
}



