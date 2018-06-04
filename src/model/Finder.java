package model;

import java.util.Arrays;
import java.util.Comparator;

public class Finder<T extends Comparable<? super T>> {

    private int minRes = 0;
    private int maxRes = 0;

    public T[] findInRange(T[] arr, T min, T max, Comparator<? super T> comp) {

        Arrays.sort(arr,comp);

        minRes =Arrays.binarySearch(arr,min,comp);
        maxRes =Arrays.binarySearch(arr,max,comp);

        if (minRes < 0)
            minRes = -minRes -1;
        if (maxRes < 0)
            maxRes = -maxRes - 1;

        return Arrays.copyOfRange(arr,minRes,maxRes);



    }
}

