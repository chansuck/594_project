package com.example;

public class DoublyLL extends SinglyLL {

    public DoublyLL() {
        super();
        this.tail = null;
    }

    public DoublyLL(Node n)  {
        super();
        this.tail = n;
    }

    public void insertHead(Node n){
        if (this.head == null) {
            this.head = n;
            this.tail = n;
            head.setPrev(null);
            tail.setNext(null);
        }
        else {
            this.head.setPrev(n);
            n.setNext(this.head);
            this.head = n;
        }
    }

    public void insertTail(Node n) {
        if (head == null) {
            this.head = n;
            this.tail = n;
            head.setPrev(null);
            tail.setNext(null);
        } else {
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
            tail.setNext(null);
        }

    }
        
//     public boolean isSorted() {
        // nothing needs to change.

// }

    public Node sortedInsert(Node headref, Node n){
        if (isSorted() == false) {
           headref = sorted(headref);
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

        return headref;
    }

    public Node sorted(Node headref){
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
        this.head = this.head.getNext();
        if (this.head != null) {
            this.head.setPrev(null);
        }
    }

    public void deleteTail(){
        if (head == null) {
            return;
        } else {
            // checks if the list contains only one node
            if (head != tail) {
                // previous node to the nail will become new tail
                tail = tail.getPrev();
                // node next to curent tail will be made null
                tail.setNext(null);

            } else {
                // if the list only contains one element
                // delete it and make both head and tail null
                head = null;
                tail = null;
            }
        }
 
    }

        public void delete(Node n){ 
            // base case (no node to delete)
            if (head == null || n == null) {
                return;
            }
            
            // if node to be deleted is head node
            if (head == n) {
                head = n.getNext();
            }

            // update next only if node to be deleted is NOT
            // the tail node
            if (n.getNext() != null) {
                n.getNext().setPrev(n.getPrev());
            }

            // update next only if node to be deleted is NOT
            // the head node
            if (n.getPrev() != null) {
                n.getPrev().setNext(n.getNext());
            }

            return;

        }

        //NOT SURE
        public void clear() {
            this.head = null;
            this.tail = null;
        }

        public void print() {
        Node curr = this.head;
        // if (curr != null) {
            // if (isSorted()) {
            //     System.out.println("Sorted Status: List is sorted");
            // } else {
            //     System.out.println("Sorted Status: List is not sorted");
            // }
        // }else{
        //     System.out.println("Soted Status: List is Empty");
        // }
        int iterator = 0;
        while(curr != null) {
            System.out.println(curr.getData());
            curr = curr.getNext();
            iterator++;
        }
            System.out.println("List length: "+iterator+" elements");
    }
}



