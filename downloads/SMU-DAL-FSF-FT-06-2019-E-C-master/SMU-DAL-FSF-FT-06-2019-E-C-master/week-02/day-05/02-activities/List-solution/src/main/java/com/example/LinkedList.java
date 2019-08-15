package com.example;

public class LinkedList implements List {

    private int listSize = 0;
    private Node head;

    /**
     * This method adds String elements to the first available space in the ArrayList
     * @param el - a String element to be added to the ArrayList
     */
    public void add(String el){
        Node newNode = new Node();
        newNode.setValue(el);

        if (this.head == null) {
            head = newNode;
        } else {
            Node last = this.head;
            while(last.getNext() != null) {
                last = last.getNext();
            }

            last.setNext(newNode);
        }

        this.listSize++;
    }

    /**
     * Removes the specified element and shifts subsequent elements accordingly
     * @param index - an int representing the index of the element to remove
     */
    public void remove(int index){

        if(index == 0) {
            this.head.setNext( this.head.getNext() );
        } else {
            int currIndex = 1;
            Node currNode = this.head;
            while(currIndex < index) {
                currNode = currNode.getNext();
                currIndex++;
            }

            currNode.setNext( currNode.getNext().getNext());
        }

        this.listSize--;


    }


    /**
     * Gets the element at the specified index
     * @param index -  an int representing the index of the element to return
     * @return - The String element
     */
    public String get(int index){
        Node currNode = this.head;
        int currIndex = 0;

        while(currIndex < index) {
            currNode = currNode.getNext();
            currIndex++;
        }

        return currNode.getValue();
    }

    /**
     * A getter for listSize
     * @return - an int representing the current ArrayList size
     */
    public int size(){
        return this.listSize;
    }
}
