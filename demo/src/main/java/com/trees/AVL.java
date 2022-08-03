package com.trees;

import java.util.LinkedList;
import java.util.Queue;

import com.nodes.TNode;

public class AVL extends BST {

    private TNode root;

    public AVL() {
        super();
    }

    public AVL(int val) {
        TNode test = new TNode();
        test.setData(val);
        this.root = test;
    }
    
    //BONUS PART
    public AVL(BST tree) {
        AVL treeBonus = new AVL(tree.getRoot());
        this.root = treeBonus.getRoot();
    }

    public AVL(TNode obj) {
        //if obj has no children, just simply make root = obj
        //if obj has children, you must iteratively insert nodes from the obj
        //tree and and balance the AVL tree
        if(obj.getLeft() == null && obj.getRight() == null){
            //theres no children
            this.root = obj;
        }
        else {
            breadthQueue(obj);
               
        }
    }

    private void breadthQueue(TNode root){

        Queue<TNode> q = new LinkedList<TNode>();
        if(root == null){
            return;
        }
        q.add(root);
        while(!q.isEmpty()){
            TNode n = (TNode) q.remove();
            //bw.write(" " + n.toString());
            //bw.write(n.toString()+"\n");
            //Do whatever here
            insert(n.getData());
            if(n.getLeft() != null){
                q.add(n.getLeft());
            }
            if (n.getRight() != null){
                q.add(n.getRight());
            }
        }
    }

    

    public TNode getRoot() {
        return this.root;
    }

    // check if node has childeren?
    public void setRoot(TNode root) {
        this.root = root;
    }

    public void insert(int val) {
        setRoot(insert(getRoot(), val));
    }

    public TNode insert(TNode node, int val) {
        TNode newNode = new TNode();
        newNode.setData(val);
        if (node == null) {
            return newNode;
        } else if (node.getData() > (newNode.getData())) {
            node.setLeft(insert(node.getLeft(), newNode.getData()));
        } else if (node.getData() < (newNode.getData())) {
            node.setRight(insert(node.getRight(), newNode.getData()));
        }
        return rebalance(node);
    }

    public void insert(TNode newNode) {
        setRoot(insert(getRoot(), newNode));
    }

    public TNode insert(TNode node, TNode newNode) {
        if (node == null) {
            return newNode;
        } else if (node.getData() > (newNode.getData())) {
            node.setLeft(insert(node.getLeft(), newNode));
        } else if (node.getData() < (newNode.getData())) {
            node.setRight(insert(node.getRight(), newNode));
        }
        return rebalance(node);
    }

    public TNode rebalance(TNode z) {
        updateHeight(z);
        z.setBalance(updateBalance(z));
        if (z.getBalance() > 1) {
            if (height(z.getRight().getRight()) > height(z.getRight().getLeft())) {
                z = rotateLeft(z);
            } else {
                z.setRight(rotateRight(z.getRight()));
                z = rotateLeft(z);
            }
        } else if (z.getBalance() < -1) {
            if(height(z.getLeft().getLeft()) > height(z.getLeft().getRight())) {
                z = rotateRight(z);
            } else {
                z.setLeft(rotateLeft(z.getLeft()));
                z = rotateRight(z);
            }
        }
        return z;
    }

    public int height(TNode node) {
        if (node == null) {
            return -1;
        } else {
            return node.getHeight();
        }
    }

    public void updateHeight(TNode node) {
        int new_height = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        node.setHeight(new_height);
    }

    public int updateBalance(TNode node) {
        if (node == null) {
            return 0;
        } else {
            return height(node.getRight()) - height(node.getLeft());
        }
    }

    public TNode rotateRight(TNode y) {
        TNode x = y.getLeft();
        TNode z = x.getRight();
        x.setRight(y);
        y.setLeft(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    public TNode rotateLeft(TNode y) {
        TNode x = y.getRight();
        TNode z = x.getLeft();
        x.setLeft(y);
        y.setRight(z);
        updateHeight(y);
        updateHeight(x);
        return x;
    }  

    public void delete(int val) {
        setRoot(deleteRec(getRoot(), val));
    }

    public TNode deleteRec(TNode node, int val) {
        // base case 
        if (node == null) {
            return node;
        // first, find the node to delete
        // if node data > node to delete data --> then node to delete belongs on the left side of the tree
        } else if (node.getData() > val) {
            node.setLeft(deleteRec(node.getLeft(), val));
        // if node data < node to delete data --> then node to delete belongs on the right side of the tree
        } else if (node.getData() < val) {
            node.setRight(deleteRec(node.getRight(), val));
        } else { // if node == node_to_delete (node to delete is found)
            // if the node only has one child (either on left side or right side) or no child.
            if (node.getLeft() == null || node.getRight() == null) {
                // if node has no left child
                if (node.getLeft() == null) {
                    node = node.getRight();
                // if node has no right child
                } else {
                    node = node.getLeft();
                }
            } else { // if node to delete has two child nodes
                //use minValue to get the successor node (smallest on the right-tree will be the successor node).
                TNode minvalue = miniValue(node.getRight());
                // set node data to be that of the successor node
                node.setData(minvalue.getData());
                // delete the node on the right (successor node).
                node.setRight(deleteRec(node.getRight(), node.getData()));
            }
        }
        // rebalance tree if node != null
        if (node != null) {
            node = rebalance(node);
        }
        // return the root node
        return node;
    }
 
    // method used for the delete method
    public TNode miniValue (TNode node) {
        TNode minv = node;
        // search for the smallest node on the left
        while (minv.getLeft() != null){
            minv = minv.getLeft();
        }
        return minv;
    }      
    

   //Search
    //Searches for the node and returns the node.
    //returns null if not found
    public TNode search(int val){
        return super.search(val);
        
    }

    public void printInOrder() {
        super.printInOrder();

    }

    public void printBF() {
        super.printBF();
    }

}