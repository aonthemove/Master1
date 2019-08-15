package com.company;

public class ArrayFunReverseIt {

    public static void main(String[] args) {

        int[] startArr = {1, 2, 3, 4, 5};

        int length = startArr.length;

        int[] reversedArr = new int[length];

        for (int i = 0; i < length; i++) {
            reversedArr[i] = startArr[length - i - 1];
        }

        System.out.println("Original Array");

        for(int num : startArr) {
            System.out.println(num);
        }

        System.out.println("-----------------------");

        System.out.println("Reversed Array");

        for(int num : reversedArr) {
            System.out.println(num);
        }
    }
}
