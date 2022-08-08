package com.Heap;

import java.util.Vector;

public class MinH {
    private Vector<Integer> elements;

    //Default constructor, no size, 10 cap
    public MinH(){
        elements = new Vector<>();
    }

    //Constructor with capacity passed in
    public MinH(int size){
        elements = new Vector<>(size);
    }

    //Constructor that takes in array and creates heap
    //DO THIS

    //Returns size
    public int getSize(){
        int count = 0;
        for(Integer x : elements){
            count++;
        }
        return count;
    }

    //check if empty 
    public boolean isEmpty(){
        if (getSize() == 0){
            return true;
        }else{
            return false;
        }
    }

    //clears vector
    public void clear(){
        for (int i = 0; i < getSize(); i++){
            elements.set(i,null);
        }
            
    }

    //Tries to find i in vector. 
    //Outputs index or -1 if not found
    public int contains(Integer i){
        for (int index = 0; index < getSize(); index++){
            if(i == elements.get(index)){
                return index;
            }
        return -1;
        }
    }

    //insert(Integer key) method

    //delete(Integer key) method

    //sort() method

    public void print(){
        for (int i = 0; i < getSize(); i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < getSize(); i++){
            System.out.print(elements.get(i) + " ");
        }

        
}
    }






    
}
