package com.example;

public class SinglyCLL extends SinglyLL{

    public SinglyCLL(){
        super();
    }


    public SinglyCLL(Node node){
        super();
        this.setTail(getHead());
        this.getTail().setNext(this.getHead());
    }

    @Override
    public void insertHead(Node n){
        if (getHead() == null) {
            setHead(n);
            setTail(getHead());
            getTail().setNext(getHead());
        }
        else {
            n.setNext(getHead());
            setHead(n);
            getTail().setNext(getHead());
        }
    }

    @Override
    public void insertTail(Node n){
        if (getHead() == null) {
            setHead(n);
            setTail(n);
            getTail().setNext(getHead());
        }
        else {	
            getTail().setNext(n);
            setTail(n);
            getTail().setNext(getHead());
        }
    }

    @Override
    public Node sortedInsert(Node headref, Node n){

        Node current2 = headref;
    
        // If the list is empty
        if (current2 == null)
        {
            n.next = n;
            headref = n;
        }
    
        // If the node to be inserted is the smallest
        // then it has to be the new head
        else if (current2.data >= n.data)
        {
    
            // Find the last node of the list as it
            // will be pointing to the head
            while (current2.next != headref)
                current2 = current2.next;
            current2.next = n;
            n.next = headref;
            headref = n;
        } else
        {
            // Locate the node before the point of insertion
            while (current2.next != headref &&
                current2.next.data < n.data)
            {
                current2 = current2.next;
            }
            n.next = current2.next;
            current2.next = n;
        }
    
        // Return the new head
        return headref;
  
    }

    @Override
    public Node sort(Node headref){
        Node sorted = null;
        Node currentSort = headref;
        //loop until curr equals tail
        //System.out.println(curr.getData());
        for(int i = 0; i < size(); i++ ){
            System.out.println("yo");
            System.out.println(currentSort.getNext().getData());
            System.out.println("yo end");
            //Node next = curr.getNext();
            sorted = sortedInsert(sorted, currentSort);
            System.out.println("PRINTING SORTED VARIABLE ...");
            System.out.println(sorted.getData());
            currentSort = currentSort.next;
            System.out.println("YOOO HERE AFTER CURR NEXT");
            //curr = next;
        }

        headref = sorted;
        return headref;
    }

    @Override
    public void deleteHead(){
        //When list is empty 
        if(getHead() == null){
            return;
        }

        //2nd edge case if one element
        if(getHead().getNext() == getHead()){
            setHead(null);
            setTail(null);
            return;
        }
        
        //points head to head.next
        this.setHead(getHead().getNext());
        getTail().setNext(getHead());
     
    }

    @Override
    public void deleteTail(){
        // 1 -->    2-->    null
        // head  head.next   head.next.next
        Node curr = getHead();
        //Edge case if list is empty
        if(curr == null){
            return;
        }
        //Edge case if there is only one element in list
        if(curr.getNext() == getHead()){
            setHead(null);
            setTail(null);
            return;
        }
        //main part
        while(curr.getNext().getNext() != getHead()){
            curr = curr.getNext();   
        }
        curr.setNext(getHead());
        setTail(curr);
        getTail().setNext(getHead());
    }

    @Override
    public void delete(Node n){
        Node curr = getHead();
        Node temp = getTail();
        //Edge case if list is Empty
        if(curr == null){
            return; 
        }
        //Edge case if head == node
        if(curr.getData() == n.getData()){
            setHead(getHead().getNext());
            return;
        }
        //Edge case if tail == node
        if(temp.getData() == n.getData()) {
            //tail = tail.getNext();
            while(curr.getNext().getData() != n.getData()){
                curr = curr.getNext();
            }
            //if curr.next does equal n, do this next line.
            setTail(curr);
            
            curr.setNext(curr.getNext().getNext()); //which will be null for this edge case 
            getTail().setNext(getHead());
            return;
        }

        //main part
        while(curr.getNext().getData() != n.getData()){
            curr = curr.getNext();
            if(curr == getHead()){
                return;
            }
        }
        //if curr.next does equal n, do this next line.
        curr.setNext(curr.getNext().getNext());             
    }

    @Override
    public int size() {
        int iterator = 0;
        if (getHead() == null) {
            return iterator;
        }

        //Regular case
        Node curr = getHead();
        while (curr != getTail()) {
            System.out.println("Start of loop");
            System.out.println(curr.getData());
            System.out.println(getTail().getData());
            System.out.println("End of loop");
            curr = curr.getNext();
            iterator++;
        }
        curr = curr.getNext();
        iterator++;
        return iterator;
    }

    @Override
    public boolean isSorted() {
        Node current = getHead();
        //Edge case: list of one element
        if(current.getNext() == getHead()){
            return true;
        }
        
        //Regular case
        while(current.getNext() != getTail()) {
            if (current.getNext().getData() > current.getData()) {
                current = current.getNext();
            } else {
                return false;
            }
        }
        //Once more for tail comparison
        if(current.getNext().getData() > current.getData()){
            return true;

        }else{
            return false;
        }
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