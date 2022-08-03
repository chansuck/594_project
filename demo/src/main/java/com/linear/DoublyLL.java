package com.linear;

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

    public void insert(Node node, int position){
        //if position is invalid. 0 or negative value
        if(position < 1){
            System.out.println("Invalid Position. Try again.");
        }
        //edge case if position is at head
        else if(position ==1){
            
            node.setNext(getHead()); //sets node next to head
            node.setPrev(getHead().getPrev()); //sets nodes prev to null
            node.getNext().setPrev(node); // sets heads prev to node
            setHead(node); //sets new head to node
        }
        //normal case
        else{

            Node temp = getHead();
            // loops till the position. if the position is bigger than the size of list, temp is null
            for(int i = 1; i < position-1; i++){
                if(temp != null){
                    temp = temp.getNext();
                }
            }

            //If position is actually found in list
            if(temp != null){
                node.setNext(temp.getNext()); //sets node's next to temp's next //temp->node->node.next
                if(temp.getNext() != null){
                    temp.getNext().setPrev(node);
                }
                temp.setNext(node);
                node.setPrev(temp);

                //This loop is just to set the last element as tail         
                Node tempTail = getHead();
                while(tempTail.getNext() != null){
                    tempTail = tempTail.getNext();
                }
                setTail(tempTail);  


            }else{
                System.out.println("Position is greater than size of list.");
            }

        }
  
    }




    
        
//     public boolean isSorted() {
        // nothing needs to change.

// }

    public void sortedInsert(Node n){
        if (isSorted() == false) {
          
           sort();
        }

        if (getSorted() == null || getSorted().getData() >= n.getData())    { 
            System.out.println("THIS THING HAPPENED");
            n.setNext(getSorted()); 
            n.setPrev(null);
            if(getSorted() != null){
                n.getNext().setPrev(n);
            }
            setSorted(n); 
            setHead(n);
        } 
        else  { 
            Node current = getHead(); 
            
            while (current.getNext() != null && current.getNext().getData() < n.getData())   { 
                current = current.getNext(); 
            } 
            n.setNext(current.getNext());

            n.setPrev(current);
            if(current.getNext() != null){
                n.getNext().setPrev(n);
            }
            current.setNext(n); 
        } 

        Node temp = getHead();
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        setTail(temp);  
        //return headref;



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

    public void sort(){
        // initialize sorted - a sorted doubly linked list
        setSorted(null);
   
        Node current = getHead();
        while (current != null) {

            // store the next node from current
            Node next = current.getNext();
            // insert current into sorted
            insertSorted(current);
            current = next;
        }
        setHead(getSorted());

        //Setting the tail
        Node curr2 = getHead();
        while(curr2.getNext() != null){
            curr2 = curr2.getNext();
        }
        setTail(curr2);


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



