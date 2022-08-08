package com.trees;


import com.nodes.TNode;

public class App {
    public static void main(String[] args) {

        // TESTNODE 1
        TNode testNode1 = new TNode( 50, 2, 0, new TNode(), null, null);

        // BST TESTING:
        BST myBST = new BST();
        myBST.insert(5);
        myBST.insert(6);
        myBST.insert(7);
        myBST.insert(8);
        myBST.insert(9);
        myBST.insert(10);
        myBST.insert(2);
        myBST.insert(testNode1);
        myBST.delete(9);

        myBST.printInOrder();
        myBST.printBF();

        System.out.println(myBST.search(50));

        // AVL TESTING:
        AVL myTree = new AVL();
        myTree.insert(5);
        myTree.insert(6);
        myTree.insert(7);
        myTree.insert(8);
        myTree.insert(9);
        myTree.insert(10);
        myTree.insert(2);

        System.out.println(myTree.search(2));


        //int data, int balance, int height, TNode P, TNode L, TNode R
        TNode testNode3 = new TNode( 15, 2, 0, new TNode(), null, null);

        TNode testNode2 = new TNode( 10, 2, 0, new TNode(),null, testNode3);

        //Node testNode1 = new TNode( 5, 2, 0, new TNode(), null, testNode2);

        //Pass in a TNode Obj with children
        AVL myTree2 = new AVL(myBST.getRoot());
        AVL avlTest = new AVL();
        avlTest.insert(5);
        avlTest.insert(testNode1);
        //avlTest.printBF();

    




    }

    
}
