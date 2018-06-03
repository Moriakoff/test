package model;

import java.util.Arrays;
import java.util.Comparator;

public class Finder<T extends Comparable<? super T>> {
    private T[] res;
    private int count = 0;

    public T[] findInRange(T[] arr, T min, T max, Comparator<? super T> comparator) {
        // create storage for result
        res = arr;
        //compute the size of the new array and fill the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(min) >= 0 && arr[i].compareTo(max) <= 0){
                res[count] = arr[i];
                count++;
            }
        }
        res = Arrays.copyOf(res,count); // create a new array with correct result and size
        Arrays.sort(res,comparator);
        return res;
    }
}

