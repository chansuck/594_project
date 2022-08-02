package com.example;

public class Main {

    public static void main(String[] args) {
        //SINGLYLL TESTING:
        SinglyLL testList = new SinglyLL();
        // testList.insertTail(new Node (120));
        // testList.insertTail(new Node (140));
        // testList.insertTail(new Node (100));
        // testList.insertTail(new Node (10));
        // testList.insertTail(new Node (1));
        testList.insertTail(new Node (1));
        testList.insertTail(new Node (2));
        testList.insertTail(new Node (3));

        testList.print();
        System.out.println("test");
        testList.head = testList.sortedInsert(testList.head,new Node(0)); //doesn't work when node is smallest?!
        testList.print();
        System.out.println();

        //DoublyLL TESTING:
        // DoublyLL testdub = new DoublyLL();
    
        // testdub.insertHead(new Node (1));
        // testdub.insertHead(new Node (90));
        // testdub.insertHead(new Node (50));
        // testdub.insertHead(new Node (60));
        // testdub.insertHead(new Node (70));

        // // testdub.insertHead(new Node (9));
        // // testdub.insertHead(new Node (6));
        // // testdub.insertHead(new Node (5));
        // // testdub.insertHead(new Node (3));
        // // testdub.insertHead(new Node (1));
        
        
        // testdub.print();
        // System.out.println();
        
    
        // //testdub.head = testdub.sorted(testdub.head);
        // testdub.head = testdub.sortedInsert(testdub.head, new Node (100));
        // testdub.print();   

        // //testList.search(new Node(55));
        // //testList.insertHead(new Node(44));
        // // testList.insertHead(new Node(22));
        // //testList.sort(testList.head);
        // testList.sortedInsert(new Node(66));
        // testList.sortedInsert(new Node(75));
        //testList.deleteHead();
        // testList.deleteTail();
        //testList.delete(new Node(55));
        //testList.clear();
        
        //testList.search(new Node(67));
        
    }

}
