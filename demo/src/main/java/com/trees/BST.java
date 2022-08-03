package com.trees;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import com.nodes.TNode;

public class BST {

    private TNode root;

    public BST() {
        this.root = null;
    }

    // review:
    public BST(TNode obj) {
        this.root = obj;
    }

    // IS THIS CORRECT?!
    public BST(int val) {
        TNode test = new TNode();
        test.setData(val);
        this.root = test;
    }

    public TNode getRoot() {
        return this.root;
    }

    public void setRoot(TNode root) {
        this.root = root;
    }


    //Search
    //Searches for the node and returns the node.
    //returns null if not found
    public TNode search(int val){
        
        TNode current = getRoot();
        //Go through the tree from root to leaves
        while (current != null) {
            //go right or left
            if (val > current.getData()){
                current = current.getRight();

            }
            
            else if (val < current.getData()){
                current = current.getLeft();
            }

            //if found, return current
            else{
                return current; // if the key is found return 1

            }
        
        }
        //return null if not found
        return null;
        
    }

    public void insert(TNode node_to_insert) {
        TNode current = root, parent = null;
        while (current != null) {
            parent = current;
            if (node_to_insert.getData() > current.getData()) {
                current = current.getRight(); }
            else {
                current = current.getLeft(); 
            }
        }
        if (root == null) {
            root = node_to_insert;
        } else if (node_to_insert.getData() > (parent.getData())) {
            parent.setRight(node_to_insert);
        } else {
            parent.setLeft(node_to_insert);
        }
        }

    // Not sure if this works
    public void insert(int val) {
        TNode current = root, parent = null;
        while (current != null) {
            parent = current;
            if (val > current.getData()) {
                current = current.getRight(); }
            else {
                current = current.getLeft(); 
            }
        }
        TNode newNode = new TNode();
        newNode.setData(val);
        if (root == null) {
            root = newNode;
        } else if (val > (parent.getData())) {
            parent.setRight(newNode);
        } else {
            parent.setLeft(newNode);
        }
        }


    // not sure if this works
    public void delete(int val) {
        deleteRec(root, val);
    }

    //Used in delete() method
    public TNode deleteRec(TNode root, int data) {
        if (root == null) {
            return root; 
        }
        if (data < root.getData()) {
            root.setLeft(deleteRec(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(deleteRec(root.getRight(), data));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            root.setData(minValue (root.getRight()));
            root.setRight(deleteRec(root.getRight(),root.getData()));
        }
        return root;

    }

    //Used for delete()
    public int minValue (TNode root) {
        int minv = root.getData();
        while (root.getLeft() != null){
            minv = root.getLeft().getData();
            root = root.getLeft();
        }
        return minv;

    }
    public void printInOrder() {
        printInOrder(getRoot());
    }

    public void printInOrder(TNode root_node) {
        try {
            FileWriter fileName = new FileWriter("output1.txt"); 
            BufferedWriter bw = new BufferedWriter(fileName);
            write(root_node, bw);  
            bw.close();  
        }   
        catch(Exception ex) {
            System.out.print("An error occured try again ");
        }
    }

    //Used for printInOrder()
    public void write(TNode Node, BufferedWriter bw) throws IOException {   
        if (Node == null) { 
            return;
        }
        write(Node.getLeft(), bw); // calls recursively
        bw.write(Node+"\n");
        write(Node.getRight(), bw); // calls recursively
    }

    public void printBF() {
        printBF(getRoot());
    }

    public void printBF(TNode root_node) {
        try {
            FileWriter fileName = new FileWriter("outputfile2.txt"); 
            BufferedWriter bw = new BufferedWriter(fileName);
            writequeue(root_node, bw);  
            bw.close();  
        }   
        catch(Exception ex) {
            System.out.print("An error occured try again ");
        }
    }

    //Used for printBF()
    public void writequeue(TNode node, BufferedWriter bw) throws IOException {  
        Queue<TNode> queue = new LinkedList<TNode>();
        if (node == null) {
            return;
        } 
        queue.clear();
        queue.add(node);
        while (!queue.isEmpty()) {
            TNode n = (TNode)queue.remove();
            bw.write(n.toString()+"\n");
            if (n.getLeft() != null) {
                queue.add(n.getLeft());
            }
            if (n.getRight() != null) {
                queue.add(n.getRight());
            }    
        }
    }



}