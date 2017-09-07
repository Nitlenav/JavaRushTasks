package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution{

    public static void main(String[] args) {
//        Integer[] mass = new Integer[] {5, 6, 7, 8, 9, 1, 2, 3, 4, };
//        System.out.println(Arrays.toString(sort(mass)));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        double mediant = array.length % 2 == 0 ?  ((double)array[array.length/2 -1] + (double)array[array.length /2])/2 :  array[array.length / 2];

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer  o1, Integer o2) {
                return (Math.abs(o1 - mediant) - Math.abs(o2 - mediant)) == 0 ? o1 - o2 : (int) (Math.abs(o1 - mediant) - Math.abs(o2 - mediant));
            }
        };
        Arrays.sort(array, comparator);
        return array;
    }
}
