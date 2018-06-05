package model;

import java.util.Arrays;
import java.util.Comparator;

public class Finder<T extends Comparable<? super T>> {

    private int minRes = 0;
    private int maxRes = 0;

    public T[] findInRange(T[] arr, T min, T max, Comparator<? super T> comp) {
        minRes =Arrays.binarySearch(arr,min,comp);
        maxRes =Arrays.binarySearch(arr,max,comp);

        if (minRes < 0)
            minRes = -minRes -1;
        else for (int i = minRes-1; i >=0; i--) {
            if (comp.compare(arr[i],arr[minRes])<0){
                minRes = i+1;
                break;
            }
        }
        if (maxRes < 0)
            maxRes = -maxRes - 1;
        else for (int i = maxRes+1; i <= arr.length-1; i++) {
            if(comp.compare(arr[i],arr[maxRes]) > 0){
                maxRes = i-1;
                break;
            }
        }

        return Arrays.copyOfRange(arr,minRes,maxRes);



    }
}

