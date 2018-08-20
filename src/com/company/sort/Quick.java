package com.company.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Quick extends Example{
    public static void sort(Comparable[] a){
        Collections.shuffle(Arrays.asList(a));
        sort(a,0,a.length);
    }
    private static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    private static int partition(Comparable[] a,int lo, int hi){
        //将数组切分为a[lo..i-1],a[i],a[i+1..hi]
        int i =lo,j = hi +1;//左右扫描指针
        Comparable v = a[lo];//切分元素
        while (true){
            while (less(a[++i], v)) if(i == hi) break;
            while (less(v,a[--j]))  if(j == lo) break;
            if(i >= j) break;
            exch(a,i,j);
        }
        exch(a,lo,j);//将v = a[j]放入正确的位置
        return j;//a[lo..i-1] <= a[i] <= a[i+1..hi]达成
    }

    public static void sort(int[] a){
        sort(a,0,a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    private static int partition(int[] data, int lo, int hi){
        int random = data[lo];
        int i = lo,j = hi+1;
        while (true){
            while (data[++i] < random)
                if(i == hi) break;
            while (random < data[--j])
                if(j == lo) break;
            if(i >= j)
                break;
            swap(data,i,j);
        }
        swap(data,lo,j);
        return j;
    }
    private static void swap(int[] a,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
