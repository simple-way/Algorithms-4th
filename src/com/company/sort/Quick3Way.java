package com.company.sort;

public class Quick3Way extends Quick {
    public static void sort(Comparable[] a,int lo, int hi){
        //调用此方法的共有方法sort()在Quick中
        if(hi <= lo) return;
        int lt = lo,i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp < 0)         exch(a, lt++, i++);
            else if(cmp > 0)    exch(a, i, gt--);
            else                i++;
        }//现在a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]成立
        sort(a, lo, lt-1);
        sort(a, gt + 1, hi);
    }
}
