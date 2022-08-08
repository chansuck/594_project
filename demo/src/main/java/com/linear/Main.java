package com.linear;

public class Main {

    public static void main(String[] args) {

        System.out.println("*********************SINGLY LL Testing ***********************");
        //SINGLYLL TESTING:
        SinglyLL testList = new SinglyLL();
        testList.insertTail(new Node (5));
        testList.insertTail(new Node (6));
        testList.insertTail(new Node (7));
        testList.sortedInsert(new Node (1));
        testList.print();

        //DoublyLL TESTING:
        System.out.println("****************DOUBLY LL TEST **********************");
        DoublyLL testdub = new DoublyLL();
    
        // testdub.insertHead(new Node (1));
        // testdub.insertHead(new Node (90));
        // testdub.insertHead(new Node (50));
        // testdub.insertHead(new Node (60));
        // testdub.insertHead(new Node (70));
    
        testdub.insertHead(new Node (2));
        testdub.insertHead(new Node (6));
        testdub.insertHead(new Node (5));
        testdub.insertHead(new Node (3));
        testdub.insert(new Node (99), 4);
        testdub.print();

        System.out.println("*******************DOUBLY CIRCULAR LL Test*********************");
        DoublyCLL testcirc = new DoublyCLL();
        testcirc.insertTail(new Node(10));
        testcirc.insertTail(new Node(2));
        testcirc.insertTail(new Node(8));
        testcirc.insertTail(new Node(5));

        testcirc.insert(new Node(99), 5);
 
        testcirc.print();
       

        System.out.println("***********************SINGLY CIRCULAR LL TEST********************");
        SinglyCLL testSinglyCLL = new SinglyCLL();
        testSinglyCLL.insertTail(new Node(500));
        testSinglyCLL.insertTail(new Node(2));
        testSinglyCLL.insertTail(new Node(100));
        testSinglyCLL.insertTail(new Node(5));
        testSinglyCLL.insertTail((new Node(10)));
        testSinglyCLL.insertTail((new Node(1000)));
        testSinglyCLL.insertTail((new Node(10)));
        testSinglyCLL.insertTail((new Node(1)));
        testSinglyCLL.insertTail((new Node(30)));
        
        testSinglyCLL.print();

        System.out.println("*******************STACK LL TEST*********************");
        LLStack stack = new LLStack();
        stack.push(new Node(10));
        stack.push(new Node(11));
        stack.push(new Node(30));
        stack.push(new Node(19));

        //stack.clear();
        stack.print();

        System.out.println("*******************QUEUE LL TEST*********************");
        LLQueue queue = new LLQueue();
        queue.enque(new Node(1));
        queue.enque(new Node(2));
        queue.enque(new Node(3));
        queue.deque(new Node(1));
        queue.print();


        
        
    }

}
