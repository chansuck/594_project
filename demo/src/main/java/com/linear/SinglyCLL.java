package com.linear;

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


    public void insert(Node node, int position){
        //if position is invalid. 0 or negative value
        if(position < 1){
            System.out.println("Invalid Position. Try again.");
        }
        //edge case if position is at head
        else if(position ==1){
            node.setNext(getHead());
            setHead(node);
            //circular part
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
        //normal case
        else{

            Node temp = getHead();
            // loops till the position. if the position is bigger than the size of list, temp is null

            if(position > size()+1){
                System.out.println("Position is greater than size of list.");
            }
            else{
                for(int i = 1; i < position-1; i++){
                    temp = temp.getNext();
                }

                node.setNext(temp.getNext());
                temp.setNext(node);

                //This loop is just to set the last element as tail         
                Node tempTail = getHead();
                int size = size();
                for (int i=1; i<size; i++){
                    tempTail = tempTail.getNext();
                }
                setTail(tempTail); 
            }

        }
  
    }


    @Override
    public void sortedInsert(Node n){
        if(isSorted() == false) {
            //System.out.println("DEFINITELY UNSORTED");
            sort();
        }
    
        //if new data is less than head of list, insert it to head
        if (getSorted() == null || getSorted().getData() >= n.getData()) {  //if you change sorted, to head, it works for inserting the first node but then sort() is broken.
            n.setNext(getSorted()); 
            setSorted(n);
            setHead(n);
            getTail().setNext(getHead());
        }
        //else traverse through to find the spot
        else {
        /* Locate the node before point of insertion. */
            Node curr = getHead();
            while (curr.getNext().getData() != getHead().getData() && curr.getNext().getData() < n.getData()) {	
                curr = curr.getNext(); 
                //System.out.println("YO");
            }
            n.setNext(curr.getNext());
            curr.setNext(n);     
         
        }

        //This loop is just to set the last element as tail
        Node temp = getHead();
        int size = size();
        for (int i = 1; i < size; i++){
            temp = temp.getNext();
        }
        setTail(temp);  
        //Circular part
        getTail().setNext(getHead());


    }

    //THIS IS ONLY USED BY sort().
    @Override
    public void insertSorted(Node newNode)   { 
        //If its head node
        //If its head node
        if (getSorted() == null || getSorted().getData() >= newNode.getData())    { 
            newNode.setNext(getSorted()); 
            setSorted(newNode); 
        } 
        else  { 
            Node current = getSorted(); 
            
            while (current.getNext() != null && current.getNext().getData() < newNode.getData())   { 
                current = current.next; 
            } 
            newNode.setNext(current.getNext());
            current.setNext(newNode); 
        } 
    } 
    

    @Override
    public void sort(){
        setSorted(null);
        Node curr = getHead();
        int size = size();
        for(int i = 0; i < size; i++){
            Node next = curr.getNext();
            insertSorted(curr);
            //curr = curr.next;
            curr = next;

        }
        // headref = sorted;
        // return headref;
        setHead(getSorted());

        //Setting the tail
        Node curr2 = getHead();
        for(int i = 1; i < size; i++){
            curr2 = curr2.getNext();

        }
        setTail(curr2);
        //circular part
        getTail().setNext(getHead());
        
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
        while (curr.getNext() != getHead()) {
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