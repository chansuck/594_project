package com.example;

public class SinglyLL {
    Node head;
    Node tail; 
    //check true means sort has been called at least once

    //Variables 
    //Initialize a Node object variable
    //implements base class Node

    //2 Constructors
    //Default with no arguments that creates null head object
    //Overload constructor with a Node object argument to use as head
    public SinglyLL(){
        this.head = null;
    }
    
    public SinglyLL(Node n){
        this.head = n;
    }

    public void insertHead(Node n){
        if (this.head == null) {
            this.head = n;
        }
        else {
            n.setNext(this.head);
            this.head = n;
        }
    }

    public void insertTail(Node n){
        if (this.head == null) {
			this.head = n;
		}
		else {	
            Node curr = this.head;
			while (curr.getNext() != null) {
            curr = curr.next;
        }
        curr.next = n;
		}
	}

    public Node sortedInsert(Node headref, Node n){
        if(isSorted() == false) {
                headref = sort(headref);
            }
    
        if (headref == null || headref.getData() >= n.getData()) {  //if you change sorted, to head, it works for inserting the first node but then sort() is broken.
		n.setNext(headref); 
		headref = n;
	    }
	    else {
		/* Locate the node before point of insertion. */
		Node curr = headref;
		while (curr.getNext() != null && curr.getNext().getData() < n.getData()) {	
		curr = curr.getNext(); 
		}
		// if(curr.next.data == n.data){
		// 	System.out.println(n.data + " is already in the list.");
		// } 
		// else {
		n.setNext(curr.getNext());
		curr.setNext(n);
		// }	
	    }
        return headref;
    }

    public Node sort(Node headref){
        Node sorted = null;
        Node curr = headref;
        while (curr != null) {
            Node next = curr.getNext();
            sorted = sortedInsert(sorted, curr);
            //curr = curr.next;
            curr = next;
        }
        headref = sorted;
        return headref;
    }

    public Node search(Node d){
        Node curr = head;
		while (curr != null) {
			if (curr.getData() == d.getData()){
				System.out.println(curr.getData());
				return curr;
			}
			curr = curr.getNext();
		}
		System.out.println("Node is not present in the list.");
		return null;
	}

    public void deleteHead(){
        //sets head to head.next
        this.head = this.head.getNext();
    }

    public void deleteTail(){
        // 1 -->    2-->    null
        // head  head.next   head.next.next
        Node curr = head;
        //Edge case if list is empty
        if(curr == null){
            return;
        }
        //Edge case if there is only one element in list
        if(curr.getNext() == null){
            head = null;
            return;
        }
        //main part
        while(curr.getNext().getNext() != null){
            curr = curr.getNext();   
        }
        curr.setNext(null);
    }

    //delete Node if found in list
    public void delete(Node n){
        Node curr = head;
        //Edge case if list is Empty
        if(curr == null){
            return; 
        }
        //Edge case if head == node
        if(curr.getData() == n.getData()){
            head = head.getNext();
            return;
        }
        //main part
        while(curr.getNext().getData() != n.getData()){
            curr = curr.getNext();
            if(curr == null){
                return;
            }
        }
        //if curr.next does equal n, do this next line.
        curr.setNext(curr.getNext().getNext());        
    }

    //NOT SURE
    public void clear(){
        this.head = null;
    }

    public boolean isSorted() {
        Node current = head;
        

        while(current.getNext() != null) {
        if (current.getNext().getData() > current.getData()) {
            current = current.getNext();
        } else {
            return false;
        }
        }
        return true;
    }

    public void print(){
        //System.out.println("TEST");
        
        Node curr = this.head;
        // if (curr != null) {
            if (isSorted()) {
                System.out.println("Sorted Status: List is sorted");
            } else {
                System.out.println("Sorted Status: List is not sorted");
            }
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
        


        //list length
        //sorted status
        //list content
        //MAKE THIS ALL READABLE
        

    }

   



    

