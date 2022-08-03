package com.linear;

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

    public void insert(Node node, int position){
        //if position is invalid. 0 or negative value
        if(position < 1){
            System.out.println("Invalid Position. Try again.");
        }
        //edge case if position is at head
        else if(position ==1){
            node.setNext(getHead());
            getHead().setPrev(node);
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
                if(temp.getNext() != null){
                    temp.getNext().setPrev(node);
                }
                temp.setNext(node);
                node.setPrev(temp);

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

    //THIS IS ONLY USED BY sort().
    public void insertSorted(Node newNode)   { 
        //If its head node
        if (getSorted() == null || getSorted().getData() >= newNode.getData())    { 
            newNode.setNext(getSorted()); 
            newNode.setPrev(null);
            if(getSorted() != null){
                newNode.getNext().setPrev(newNode);
            }
            setSorted(newNode); 
        } 
        else  { 
            Node current = getSorted(); 
            
            while (current.getNext() != null && current.getNext().getData() < newNode.getData())   { 
                current = current.next; 
            } 
            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            if(getSorted() != null){
                newNode.getNext().setPrev(newNode);
            }
            current.setNext(newNode); 
        } 
    } 
    
    @Override
    public void sort() {
         // initialize sorted - a sorted doubly linked list
         setSorted(null);

         // traverse the initial doubly linked list and insert 
         // the correctly placed nodes in sorted.
       
         Node current = getHead();
         int size = size();
         for (int i = 0; i < size; i++) {
             // store the next node from current
             Node next = current.getNext();
             // insert current into sorted
             insertSorted(current);
             current = next;
         }
         setHead(getSorted());
 
        //Setting the tail
        Node curr2 = getHead();
        for(int i = 1; i < size; i++){
            curr2 = curr2.getNext();
        }
        setTail(curr2);
        //circular part
        getTail().setNext(getHead());
        getHead().setPrev(getTail());
 
     }

  

    @Override
    public void sortedInsert(Node n) {
        if (isSorted() == false) {
            sort();
        }
        if (getSorted() == null || getSorted().getData() >= n.getData())    { 
            n.setNext(getSorted()); 
            n.setPrev(getTail());
            if(getSorted() != null){
                n.getNext().setPrev(n);
            }
            setSorted(n); 
            setHead(n);
            getTail().setNext(getHead());;
        } 
        else  { 
            Node current = getHead(); 

            while (current.getNext().getData() != getHead().getData() && current.getNext().getData() < n.getData())   { 

                current = current.getNext();
  
            } 
            n.setNext(current.getNext());
            n.setPrev(current);
            if(getSorted() != null){
                //System.out.println("sorted is not null");
                n.getNext().setPrev(n);
            }
            current.setNext(n); 
         
        
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
        //iterator++;
   
        while (curr.getNext() != getHead()) {
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
