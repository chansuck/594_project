package com.example;

public class SinglyLL {
    Node head;
    Node sorted;
    boolean checkSorted = false;
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
            n.next = this.head;
            this.head = n;
        }
    }

    public void insertTail(Node n){
        if (this.head == null) {
			this.head = n;
		}
		else {	
            Node curr = this.head;
			while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = n;
		}
        
		
	}

    public void sortedInsert(Node n){
        Node current = head;
        if(checkSorted == false){
            while (current.next != null) {
                if (current.next.data > current.data) {
                    current = current.next;
                } else {
                    current = null;
                    sort(head);
                }
            } 
        }
        if(checkSorted == false) {
            sorted = head;
        }
        
        if (sorted == null || sorted.data >= n.data) {
		n.next = sorted;
		sorted = n;
	    }
	    else {
		/* Locate the node before point of insertion. */
		Node curr = sorted;
		while (curr.next != null && curr.next.data < n.data) {	
		curr = curr.next; 
		}
		// if(curr.next.data == n.data){
		// 	System.out.println(n.data + " is already in the list.");
		// } 
		// else {
		n.next = curr.next;
		curr.next = n;
		// }	
	    }
    }


    public void sort(Node headref){
        sorted = null;
        Node curr = headref;
        while (curr != null) {
            Node next = curr.next;
            checkSorted = true;
            sortedInsert(curr);
            //curr = curr.next;
            curr = next;
        }
        head = sorted;
    }

    public Node search(Node d){
        Node curr = head;
		while (curr != null) {
			if (curr.data == d.data){
				System.out.println(curr.data);
				return curr;
			}
			curr = curr.next;
		}
		System.out.println("Node is not present in the list.");
		return null;

	}

    public void deleteHead(){
        //sets head to head.next
        this.head = this.head.next;
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
        if(curr.next == null){
            head = null;
            return;
        }
        //main part
        while(curr.next.next != null){
            curr = curr.next;   
        }
        curr.next = null;

    }

    //delete Node if found in list
    public void delete(Node n){
        Node curr = head;
        //Edge case if list is Empty
        if(curr == null){
            return; 
        }
        //Edge case if head == node
        if(curr.data == n.data){
            head = head.next;
            return;
        }
        //main part
        while(curr.next.data != n.data){
            curr = curr.next;
            if(curr == null){
                return;
            }
        }
        //if curr.next does equal n, do this next line.
        curr.next = curr.next.next;        
    }

    
    //NOT SURE
    public void clear(){
        this.head = null;
    }

    public boolean check() {
        Node current = head;
        

        while(current.next != null) {
        if (current.next.data > current.data) {
            current = current.next;
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
            if (check()) {
                System.out.println("Sorted Status: List is sorted");
            } else {
                System.out.println("Sorted Status: List is not sorted");
            }
        // }else{
        //     System.out.println("Soted Status: List is Empty");
        // }
        int iterator = 0;
        while(curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
            iterator++;
        }
            System.out.println("List length: "+iterator+" elements");
    }
        


        //list length
        //sorted status
        //list content
        //MAKE THIS ALL READABLE
        

    }

   



    

