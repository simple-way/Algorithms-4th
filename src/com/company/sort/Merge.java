package com.company.sort;

public class Merge extends Example{

    private static Comparable[] aux;
    private static int[] arr;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        //将数组a[lo..hi]排序
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        //将a[lo..mid]和a[mid+1..hi]归并
        int i = lo,j =mid+1;
        for(int k = lo; k <= hi; k++)//将a[lo..mid]复制到aux[lo..mid]
            aux[k] = a[k];
        for(int k = lo; k <= hi; k++){//归并回到a[lo..hi]
            if     (i > mid)                        a[k] = aux[j++];
            else if(j > hi)                         a[k] = aux[i++];
            else if(less(aux[j],aux[i]))    a[k] = aux[j++];
            else                                    a[k] = aux[i++];
        }
    }

    public static void sort(int[] a){
        arr = new int[a.length];
        sort(a,0,a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi){
        System.arraycopy(a, lo, arr, lo, hi + 1 - lo);
        //System.arraycopy(a, lo, arr, lo, hi + 1 - lo);
        int i=lo,j=mid+1;
        for(int k = lo; k <= hi; k++){
            if(i > mid)                 a[k] = arr[j++];
            else if(j > hi)             a[k] = arr[i++];
            else if(arr[i] < arr[j])    a[k] = arr[i++];
            else                        a[k] = arr[j++];
        }
    }
}
