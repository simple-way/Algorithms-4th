package com.company.sort;

public class Quick3Way extends Quick {
    public static void sort(Comparable[] a,int lo, int hi){
        //���ô˷����Ĺ��з���sort()��Quick��
        if(hi <= lo) return;
        int lt = lo,i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt){
            int cmp = a[i].compareTo(v);
            if(cmp < 0)         exch(a, lt++, i++);
            else if(cmp > 0)    exch(a, i, gt--);
            else                i++;
        }//����a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]����
        sort(a, lo, lt-1);
        sort(a, gt + 1, hi);
    }
}
