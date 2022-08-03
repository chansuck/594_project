package com.nodes;


public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;
    private int height;

    public TNode() {
        setData(0);
        setBalance(0);
        setHeight(0);
        setLeft(null);
        setRight(null);
        setParent(null);
    }

    public TNode(int data, int balance, TNode P, TNode L, TNode R)  {
        setData(data);
        setBalance(balance);
        setLeft(L);
        setRight(R);
        setParent(P);
    }

    public TNode(int data, int balance, int height, TNode P, TNode L, TNode R)  {
        setData(data);
        setBalance(balance);
        setHeight(height);
        setLeft(L);
        setRight(R);
        setParent(P);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public TNode getLeft() {
        return left;
    }
    public void setLeft(TNode left) {
        this.left = left;
    }
    public TNode getRight() {
        return right;
    }
    public void setRight(TNode right) {
        this.right = right;
    }
    public TNode getParent() {
        return parent;
    }
    public void setParent(TNode parent) {
        this.parent = parent;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void print() {
        System.out.println("Data: " + data);
        System.out.println("Balance: "+balance);
        System.out.println("Height: "+height);
        System.out.println("Parent Node: "+parent);
        System.out.println("Left Node: "+left);
        System.out.println("Right Node: "+right);
    }

    public String toString() {
        return data + "";

    }



    


}