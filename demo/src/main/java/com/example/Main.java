package com.example;

public class Main {

    public static void main(String[] args) {
        //SinglyLL testList = new SinglyLL(new Node (33));
        SinglyLL testList = new SinglyLL();
        // testList.insertTail(new Node (55));
        // testList.insertTail(new Node (66));
        // testList.insertTail(new Node (100));
        // testList.insertTail(new Node (125));
        //testList.insertTail(new Node (101));
        // testList.insertTail(new Node (77));
        // testList.sort(testList.head);
        System.out.println("test");

        //testList.sort(testList.head);

        
        testList.sortedInsert(new Node(60));

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
        testList.print();
    }

}
