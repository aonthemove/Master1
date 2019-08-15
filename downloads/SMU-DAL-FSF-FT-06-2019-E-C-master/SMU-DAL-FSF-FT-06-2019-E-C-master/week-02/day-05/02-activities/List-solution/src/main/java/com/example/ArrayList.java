package com.example;

import java.util.Arrays;


public class ArrayList implements List{
    private int listSize = 0;
    private String[] data = new String[10];

    /**
     * This method adds String elements to the first available space in the ArrayList
     * @param el - a String element to be added to the ArrayList
     */
    public void add(String el){
        if (this.listSize == data.length){
            data = Arrays.copyOf(data, data.length * 2);
        }

        data[this.listSize] = el;
        this.listSize++;
    }

    /**
     * Removes the specified element and shifts subsequent elements accordingly
     * @param index - an int representing the index of the element to remove
     */
    public void remove(int index){
        for (int i = index; i < this.listSize - 1; i++){
            data[i] = data [i + 1];
        }

        data[this.listSize - 1] = null;
        this.listSize--;
    }


    /**
     * Gets the element at the specified index
     * @param index -  an int representing the index of the element to return
     * @return - The String element
     */
    public String get(int index){
        return data[index];
    }

    /**
     * A getter for listSize
     * @return - an int representing the current ArrayList size
     */
    public int size(){
        return this.listSize;
    }
}
