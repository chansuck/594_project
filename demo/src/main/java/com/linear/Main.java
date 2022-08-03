package com.linear;

public class Main {

    public static void main(String[] args) {
        //SINGLYLL TESTING:
        SinglyLL testList = new SinglyLL();
        // testList.insertTail(new Node (120));
        // testList.insertTail(new Node (140));
        // testList.insertTail(new Node (100));
        // testList.insertTail(new Node (10));
        // testList.insertTail(new Node (1));
        testList.insertTail(new Node (10));
        testList.insertTail(new Node (50));
        testList.insertTail(new Node (3));
        testList.insert(new Node(5), 4);

        testList.print();
        System.out.println("test");
        //testList.setHead(testList.sortedInsert(testList.getHead(),new Node(0))); //doesn't work when node is smallest?!
        //testList.setHead(testList.sort(testList.getHead()));
        //testList.sort();
        System.out.println("THIS PART FOR TAIL");
        System.out.println(testList.getTail().getData()); //answer should be 3
        System.out.println("END OF TAIL PART");
        testList.print();

        System.out.println("SORTED INSERT PART****");
        testList.sortedInsert(new Node (55));
        testList.print();
        System.out.println();

        //DoublyLL TESTING:
        System.out.println("****************DOUBLY LINKED LIST TEST **********************");
        DoublyLL testdub = new DoublyLL();
    
        // testdub.insertHead(new Node (1));
        // testdub.insertHead(new Node (90));
        // testdub.insertHead(new Node (50));
        // testdub.insertHead(new Node (60));
        // testdub.insertHead(new Node (70));
        Node tester = new Node(7);
        testdub.insertHead(new Node (2));
        testdub.insertHead(new Node (6));
        testdub.insertHead(new Node (5));
        testdub.insertHead(new Node (3));
        testdub.insertHead(tester);

        testdub.insert(new Node (99), 6);
        
        //testdub.sortedInsert(new Node(1));
        //testdub.sort();

        
        //testdub.delete(new Node (5));
        System.out.println(testdub.getTail().getPrev().getData());
        testdub.print();
        System.out.println("THE HEAD: ");
        System.out.println(testdub.getHead().getData());
        System.out.println("THE TAIL: ");
        System.out.println(testdub.getTail().getData());
        System.out.println();

        System.out.println("*******************DoublyCLL Test*********************");
        DoublyCLL testcirc = new DoublyCLL();
        testcirc.insertTail(new Node(10));
        testcirc.insertTail(new Node(2));
        testcirc.insertTail(new Node(8));
        testcirc.insertTail(new Node(5));
        testcirc.print();


        testcirc.insert(new Node(99), 5);
     

        //testcirc.sort();
        //testcirc.sortedInsert(new Node(0));

        System.out.println("HEAD IS : ");
        System.out.println(testcirc.getHead().getData());
        System.out.println("TAIL IS : ");
        System.out.println(testcirc.getTail().getData());


        testcirc.print();
       
    
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

        System.out.println("***********************SinglyCLL TEST********************");
        SinglyCLL testSinglyCLL = new SinglyCLL();
        // testSinglyCLL.insertHead(new Node(50));
        // testSinglyCLL.insertHead(new Node(100));
        // testSinglyCLL.insertTail(new Node(99));
        // testSinglyCLL.insertTail(new Node(1));
        // testSinglyCLL.insertHead(new Node(200));
        testSinglyCLL.insertTail(new Node(500));
        testSinglyCLL.insertTail(new Node(2));
        testSinglyCLL.insertTail(new Node(100));
        testSinglyCLL.insertTail(new Node(5));

        testSinglyCLL.insert(new Node(99), 4);
        //testSinglyCLL.delete(new Node(100));
        //testSinglyCLL.sortedInsert(new Node(300));
        //testSinglyCLL.sort();

        // System.out.println(testSinglyCLL.getTail().getData());

        // //testSinglyCLL.setHead(testSinglyCLL.sort(testSinglyCLL.getHead()));
        // testSinglyCLL.setHead(testSinglyCLL.sortedInsert(testSinglyCLL.getHead(), new Node(60)));
        testSinglyCLL.print();
        System.out.println("HEAD is:");
        System.out.println(testSinglyCLL.getHead().getData());
        System.out.println("Tail is: ");
        System.out.println(testSinglyCLL.getTail().getData());

        System.out.println();
        System.out.println(testSinglyCLL.getHead().getNext().getData());

        // System.out.println("IS IT SORTED?");
        // System.out.println(testSinglyCLL.isSorted());


        
        
    }

}
