package com.example;

public class App {
    public static void main(String[] args){

        List list = new ArrayList();

        list.add("Hey");
        list.add("Hi");
        list.add("Howdy");
        list.add("Heya");

        System.out.println(list.size());
        System.out.println(list.get(2));

        list.remove(2);
        System.out.println(list.size());
        System.out.println(list.get(2));
    }
}
